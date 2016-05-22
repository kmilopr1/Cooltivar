package com.hack.cooltivar.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hack.cooltivar.R;
import com.hack.cooltivar.services.TemperatureCaptureService;

/**
 * Created by Kmilo on 5/22/2016.
 */
public class AlertCooltivarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_cooltivar);
        stopService(new Intent(this, TemperatureCaptureService.class));



    }

}
