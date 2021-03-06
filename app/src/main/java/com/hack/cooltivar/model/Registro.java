package com.hack.cooltivar.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "REGISTRO".
 */
public class Registro {

    private Long id;
    private String tipoCultivo;
    private String fecha;
    private String hora;
    private String temperatura;

    public Registro() {
    }

    public Registro(Long id) {
        this.id = id;
    }

    public Registro(Long id, String tipoCultivo, String fecha, String hora, String temperatura) {
        this.id = id;
        this.tipoCultivo = tipoCultivo;
        this.fecha = fecha;
        this.hora = hora;
        this.temperatura = temperatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
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
