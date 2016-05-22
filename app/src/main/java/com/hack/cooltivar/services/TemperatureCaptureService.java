package com.hack.cooltivar.services;

import android.app.AlertDialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.hack.cooltivar.views.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cconstante on 21/05/2016.
 */
public class TemperatureCaptureService extends Service {
    // constant
    public static final long NOTIFY_INTERVAL = 10 * 1000; // 10 seconds

    // run on another Thread to avoid crash
    private Handler mHandler = new Handler();
    // timer handling
    private Timer mTimer = null;

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
        mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, NOTIFY_INTERVAL);
        return Service.START_NOT_STICKY;
    }



    class TimeDisplayTimerTask extends TimerTask {


        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {

                @Override
                public void run() {
                    // display toast

                    AlertDialog.Builder builder = new AlertDialog.Builder(TemperatureCaptureService.this);
                    builder.setTitle("Test dialog");
                    builder.setMessage("Content");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            //Do something
//                            stopService(new Intent(TemperatureCaptureService.this, TemperatureCaptureService.class));
//                            stopSelf();

                            
                            Intent i = new Intent(TemperatureCaptureService.this, MainActivity.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);
                            dialog.dismiss();
                            Process.killProcess(Process.myPid());
                        }
                    });
                    builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                    alert.show();

                }

            });
        }

    }}