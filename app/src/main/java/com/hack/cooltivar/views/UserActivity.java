package com.hack.cooltivar.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hack.cooltivar.R;
import com.hack.cooltivar.model.RegistroBusiness;
import com.hack.cooltivar.utils.TestingView;

public class UserActivity extends AppCompatActivity {

    private TextView etUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        getSupportActionBar().hide();

    etUsuario = (TextView)findViewById(R.id.etUsuario);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistroBusiness registroBusiness= new RegistroBusiness(getApplicationContext());
                registroBusiness.guardarNombreUsuario(etUsuario.getText().toString());
                Intent i = new Intent(UserActivity.this, ResumenActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
