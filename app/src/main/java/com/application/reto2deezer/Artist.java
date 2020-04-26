package com.application.reto2deezer;

public class Artist {
    private String nombre;
    private String info;
    private String nItems;
    private int foto;

    public Artist(){
    }

    public Artist(String nombre, String info, String nItems, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
        this.nItems = nItems;
    }

    public String getnItems() {
        return nItems;
    }

    public void setnItems(String nItems) {
        this.nItems = nItems;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}