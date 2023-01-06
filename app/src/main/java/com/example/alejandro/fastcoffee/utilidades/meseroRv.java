package com.example.alejandro.fastcoffee.utilidades;

public class meseroRv {
    String estado, mesa, producto, id;
    int idp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public meseroRv(String estado, String mesa, String producto, String id, int idp) {
        this.estado = estado;
        this.mesa = mesa;
        this.producto = producto;
        this.id = id;
        this.idp = idp;
    }

    public String getEstado() {
        return estado;
    }

    public String getMesa() {
        return mesa;
    }

    public String getProducto() {
        return producto;
    }

    public int getIdp() {
        return idp;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }


    public meseroRv() {
    }
}
