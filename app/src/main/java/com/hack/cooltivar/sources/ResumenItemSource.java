package com.hack.cooltivar.sources;

import android.content.Context;

import com.hack.cooltivar.adapters.ResumenItemModel;
import com.hack.cooltivar.model.Registro;
import com.hack.cooltivar.model.RegistroBusiness;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gsanchez on 22/05/2016.
 */
public class ResumenItemSource {

    private Context context;

    public ResumenItemSource() {
    }

    public ArrayList<ResumenItemModel> getData(){

        ArrayList<ResumenItemModel> arrayList = new  ArrayList<ResumenItemModel>();
/*        RegistroBusiness registroBusiness = new RegistroBusiness(context);

        List<Registro> registros = registroBusiness.traerRegistros();
        for (Registro registro: registros) {
            ResumenItemModel resumenItemModel = new ResumenItemModel();
            resumenItemModel.setDescripcionCultivo(registro.getTipoCultivo());
            resumenItemModel.setFecha(registro.getFecha());
            resumenItemModel.setHora(registro.getHora());
            resumenItemModel.setTemperatura(registro.getTemperatura());
            arrayList.add(resumenItemModel);
        }*/

        ResumenItemModel resumenItemModel = new ResumenItemModel();
        resumenItemModel.setDescripcionCultivo("Cultivo Maiz");
        resumenItemModel.setFecha("22/Mayo/2016");
        resumenItemModel.setHora("8:25AM");
        resumenItemModel.setTemperatura("27°C");
        arrayList.add(resumenItemModel);

         resumenItemModel = new ResumenItemModel();
        resumenItemModel.setDescripcionCultivo("Papa sabanera");
        resumenItemModel.setFecha("22/Mayo/2016");
        resumenItemModel.setHora("8:00AM");
        resumenItemModel.setTemperatura("25°C");
        arrayList.add(resumenItemModel);


        return arrayList;
    }
}
