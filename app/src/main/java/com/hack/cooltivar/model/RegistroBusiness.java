package com.hack.cooltivar.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by Kmilo on 5/22/2016.
 */
public class RegistroBusiness {

    private Context context;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SQLiteDatabase db;

    public RegistroBusiness(Context context){
        this.context = context;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "applicationdb", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public List<Registro> traerRegistros(){
        List<Registro> registros = daoSession.getRegistroDao().queryBuilder().list();
        return registros;
    }

    public void insertarRegistro(String fecha, String hora, String temperatura){

        RegistroDao registroDao = daoSession.getRegistroDao();
        Registro registro = new Registro();
        registro.setTipoCultivo("Cultivo de maiz");
        registro.setFecha(fecha);
        registro.setHora(hora);
        registro.setTemperatura(temperatura);
        registroDao.insert(registro);

    }

    public void guardarNombreUsuario(String nombreUsuario) {
        SharedPreferences prefs = context.getSharedPreferences("nombreUsuarios", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("nombre", nombreUsuario);
        edit.commit();
    }

    public String traerNombreUsuario() {
        SharedPreferences prefs = context.getSharedPreferences("nombreUsuarios", Context.MODE_PRIVATE);
        String nombreUsuario = prefs.getString("nombre", " ");
        return nombreUsuario;
    }
}
