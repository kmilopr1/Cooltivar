package com.hack.cooltivar.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
//        startService(new Intent(AlertCooltivarActivity.this, TemperatureCaptureService.class));

        findViewById(R.id.buttonAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startService(new Intent(AlertCooltivarActivity.this, TemperatureCaptureService.class));
                finish();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
//        startService(new Intent(AlertCooltivarActivity.this, TemperatureCaptureService.class));
        finish();
    }
}
