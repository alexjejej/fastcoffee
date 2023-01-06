package com.example.alejandro.fastcoffee.utilidades;

public class ventaRv {
    String producto;
    int cantidad, costo;

    public ventaRv(String producto, int cantidad, int costo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ventaRv() {
    }
}
