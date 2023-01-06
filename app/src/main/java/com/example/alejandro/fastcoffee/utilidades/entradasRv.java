package com.example.alejandro.fastcoffee.utilidades;

public class entradasRv {

    int imageEntradas;
    String mesa, productos, titulo, descripcion, precio, tipo;


    public int getImageEntradas() {
        return imageEntradas;
    }

    public void setImageEntradas(int imageEntradas) {
        this.imageEntradas = imageEntradas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }


    public entradasRv(int imageEntradas, String titulo, String descripcion, String precio) {
        this.imageEntradas = imageEntradas;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;

    }


}
