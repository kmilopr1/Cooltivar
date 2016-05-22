package com.hack.cooltivar.services;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.hack.cooltivar.R;
import com.hack.cooltivar.r2m.controller.api.TemperatureTaker;
import com.hack.cooltivar.r2m.controller.api.TemperatureTakerFactory;
import com.hack.cooltivar.views.AlertCooltivarActivity;
import com.hack.cooltivar.views.MainActivity;
import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cconstante on 21/05/2016.
 */
public class TemperatureCaptureService extends Service {
    // constant
    public static final long NOTIFY_INTERVAL = 5000; // 10 seconds
    private Button buttonAceptar;
    // run on another Thread to avoid crash
    private Handler mHandler = new Handler();
    // timer handling
    private Timer mTimer = null;
    private TemperatureTaker temperatureTaker;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // cancel if already existed


        if(mTimer != null) {
            mTimer.cancel();
        } else {
            // recreate new
            mTimer = new Timer();
        }
        // schedule task
       try {
           mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
       }catch (Exception e){


       }

        return Service.START_STICKY;
    }



    class TimeDisplayTimerTask extends TimerTask {

        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {

                @Override
                public void run() {

                    try{

                        // Instantiate a controller
                        MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(getApplicationContext());
                        TemperatureTakerFactory controllerFactory = new TemperatureTakerFactory(magnetClient);
                        temperatureTaker = controllerFactory.obtainInstance();

                        Call<List<String>> callObject = temperatureTaker.takeTemperatureValue(null);
                        List<java.lang.String> result = callObject.get();
                        Log.e("RESPONSE" , ": " + result);

                        Log.e("RESPONSE where!!!!" , ": " + setResult(result.toString()));
                        if(setResult(result.toString()) > 30) {

                            Intent i = new Intent(TemperatureCaptureService.this, AlertCooltivarActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);
//                            Process.killProcess(Process.myPid());

//
//  stopSelf();


                        }


                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                }

            });
        }


    }

    private int setResult(String result) {

        String firstReplace = result.toString().replace("000]", "");
        String secondReplace = firstReplace.replace("[", "");
        String thirdReplace = secondReplace.replace(".", "");

        return Integer.parseInt(thirdReplace);

    }

}