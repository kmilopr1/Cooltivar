package com.hack.cooltivar.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hack.cooltivar.R;
import com.hack.cooltivar.services.TemperatureCaptureService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent temperatureServiceStartAction = new Intent();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        startService(new Intent(this, TemperatureCaptureService.class));
    }
}
