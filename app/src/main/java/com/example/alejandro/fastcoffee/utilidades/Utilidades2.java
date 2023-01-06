package com.example.alejandro.fastcoffee.utilidades;

public class Utilidades2 {

    //Constantes campos tabla orden
    public static final String TABLA_ORDEN="ordenn";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_TITULO="titulo";
    public static final String CAMPO_DESCRIPCION="descripcion";
    public static final String CAMPO_PRECIO="precio";
    public static final String CAMPO_PRECIOTOTAL="preciototal";
    public static final String CAMPO_TIPO="tipo";



    public static final String CREAR_TABLA_ORDENN="CREATE TABLE "+TABLA_ORDEN+"("+CAMPO_ID+" INTEGER, "+CAMPO_TITULO+" TEXT," +
            " "+CAMPO_DESCRIPCION+" TEXT, "+CAMPO_PRECIO+" INT, "+CAMPO_PRECIOTOTAL+" INT, "+CAMPO_TIPO+" TEXT)";
}
