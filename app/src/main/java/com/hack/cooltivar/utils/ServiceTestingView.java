package com.hack.cooltivar.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hack.cooltivar.R;
import com.hack.cooltivar.services.TemperatureCaptureService;

public class ServiceTestingView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_testing_view);

        Intent temperatureServiceStartAction = new Intent(this, TemperatureCaptureService.class);
        startService(temperatureServiceStartAction);

    }
}
