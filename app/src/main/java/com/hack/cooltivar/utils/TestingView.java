package com.hack.cooltivar.utils;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hack.cooltivar.R;
import com.hack.cooltivar.services.TemperatureCaptureService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Retrofit;

public class TestingView extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech ttsElement;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_testing_view);

        // Intent temperatureServiceStartAction = new Intent(this, TemperatureCaptureService.class);
        // startService(temperatureServiceStartAction);

        //ttsElement = new TextToSpeech(this, this);
        //speakOut();

        //new TestingConnection().execute();


    }

    /*
    private class TestingConnection extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... params) {

            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL("http://192.168.1.133:8070/044a7f4b43fa42f19ba577af3fb21918/pin/V1");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return null;
        }
    }
    */


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
