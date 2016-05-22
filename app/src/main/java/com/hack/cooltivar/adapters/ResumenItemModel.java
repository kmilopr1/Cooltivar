package com.hack.cooltivar.adapters;

/**
 * Created by gsanchez on 22/05/2016.
 */
public class ResumenItemModel {

    private String descripcionCultivo="";
    private String fecha="";
    private String hora="";
    private String temperatura="";

    public String getDescripcionCultivo() {
        return descripcionCultivo;
    }

    public void setDescripcionCultivo(String descripcionCultivo) {
        this.descripcionCultivo = descripcionCultivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }
}
