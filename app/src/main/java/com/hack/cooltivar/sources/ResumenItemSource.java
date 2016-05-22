package com.hack.cooltivar.sources;

import com.hack.cooltivar.adapters.ResumenItemModel;

import java.util.ArrayList;

/**
 * Created by gsanchez on 22/05/2016.
 */
public class ResumenItemSource {

    public ResumenItemSource() {
    }

    public ArrayList<ResumenItemModel> getData(){

        ArrayList<ResumenItemModel> arrayList = new  ArrayList<ResumenItemModel>();

        ResumenItemModel resumenItemModel = new ResumenItemModel();
        resumenItemModel.setDescripcionCultivo("");
        resumenItemModel.setFecha("");
        resumenItemModel.setHora("");
        resumenItemModel.setTemperatura("");
        arrayList.add(resumenItemModel);

        return arrayList;
    }
}
