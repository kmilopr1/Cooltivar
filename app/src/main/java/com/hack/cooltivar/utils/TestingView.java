package com.hack.cooltivar.utils;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hack.cooltivar.R;
import com.hack.cooltivar.services.TemperatureCaptureService;

import java.util.Locale;

public class TestingView extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech ttsElement;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_testing_view);

        // Intent temperatureServiceStartAction = new Intent(this, TemperatureCaptureService.class);
        // startService(temperatureServiceStartAction);

        ttsElement = new TextToSpeech(this, this);
        speakOut();

    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = ttsElement.setLanguage(new Locale("es", "ES"));

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                speakOut();
            }

        }

    }

    private void speakOut() {
        ttsElement.speak("hey, se esta quemando tu cultivo corre corre", TextToSpeech.QUEUE_FLUSH, null);
    }
}
