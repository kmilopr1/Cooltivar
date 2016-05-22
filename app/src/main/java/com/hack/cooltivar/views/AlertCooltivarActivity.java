package com.hack.cooltivar.views;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hack.cooltivar.R;
import com.hack.cooltivar.model.Registro;
import com.hack.cooltivar.model.RegistroBusiness;
import com.hack.cooltivar.services.TemperatureCaptureService;

import java.util.List;
import java.util.Locale;

/**
 * Created by Kmilo on 5/22/2016.
 */
public class AlertCooltivarActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech ttsElement;
    private TextView tvUsuario;
    private TextView tvTemperatura;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_cooltivar);
//        startService(new Intent(AlertCooltivarActivity.this, TemperatureCaptureService.class));
        RegistroBusiness registroBusiness = new RegistroBusiness(getApplicationContext());

        tvUsuario= (TextView)findViewById(R.id.tvUsuario);
        tvTemperatura=(TextView)findViewById(R.id.tvTemperatura);
        List<Registro> listaRegistros = registroBusiness.traerRegistros();
        String temperatura= "30";
        try{
            temperatura = listaRegistros.get(listaRegistros.size()).getTemperatura();
        }catch (Exception ex){

        }
        tvUsuario.setText(registroBusiness.traerNombreUsuario()+" tus cultivos podrian quemarse");
        tvTemperatura.setText("Temperatura por encima de "+temperatura+"°C");
        ttsElement = new TextToSpeech(this, this);
        speakOut();

        findViewById(R.id.buttonAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                startService(new Intent(AlertCooltivarActivity.this, TemperatureCaptureService.class));
                finish();
            }
        });

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
        RegistroBusiness registroBusiness = new RegistroBusiness(getApplicationContext());
        String cooltivador = registroBusiness.traerNombreUsuario();
        ttsElement.speak("Oye "+ cooltivador+ ", tu cultivo se podria estar quemando corre corre", TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        startService(new Intent(AlertCooltivarActivity.this, TemperatureCaptureService.class));
        finish();
    }
}
