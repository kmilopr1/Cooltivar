package com.hack.cooltivar.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cconstante on 21/05/2016.
 */
public class TemperatureCaptureService extends Service{

    private Timer mtimer;
    private static final int INTERVAL = 3000;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("SERVICE STATE", "STARTED RUNNING!");

        mtimer = new Timer();

        mtimer.scheduleAtFixedRate(

                new TimerTask() {

                    @Override
                    public void run() {

                        Log.e("SERVICE STATE", "EXECUTION");



                    }

                }

        , 2000, INTERVAL);


        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {return null;}

}
