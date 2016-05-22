package com.hack.cooltivar.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.hack.cooltivar.R;
import com.hack.cooltivar.adapters.ResumenItemAdapter;
import com.hack.cooltivar.sources.ResumenItemSource;

import java.util.ArrayList;

public class ResumenActivity extends AppCompatActivity {

    private ListView lvCooltivo;
    private TextView tvUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        tvUsuario = (TextView) findViewById(R.id.tvUsuario) ;
        lvCooltivo = (ListView) findViewById(R.id.lvResumen);

        tvUsuario.setText("");
        ResumenItemSource resumenItemSource = new ResumenItemSource();
        ResumenItemAdapter resumenItemAdapter = new ResumenItemAdapter(this, resumenItemSource.getData());
        lvCooltivo.setAdapter(resumenItemAdapter);
    }
}
