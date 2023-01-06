package com.example.alejandro.fastcoffee.utilidades;

import android.util.Log;

public class cocinaRv {

    String estado, mesa, producto, id;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public cocinaRv(String estado, String mesa, String producto, String id) {
        this.estado = estado;
        this.mesa = mesa;
        this.producto = producto;
        this.id = id;
    }

    public cocinaRv(){

    }



}
