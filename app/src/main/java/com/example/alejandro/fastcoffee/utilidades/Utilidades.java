package com.example.alejandro.fastcoffee.utilidades;

public class Utilidades {

    //Constantes campos tabla orden
    public static final String TABLA_ORDEN="orden";
    public static final String TABLA_ORDEN2="orden2";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_TITULO="titulo";
    public static final String CAMPO_DESCRIPCION="descripcion";
    public static final String CAMPO_PRECIO="precio";
    public static final String CAMPO_PRECIOTOTAL="preciototal";
    public static final String CAMPO_TIPO="tipo";



    public static final String CREAR_TABLA_ORDEN="CREATE TABLE "+TABLA_ORDEN+"("+CAMPO_ID+" INTEGER, "+CAMPO_TITULO+" TEXT," +
            " "+CAMPO_DESCRIPCION+" TEXT, "+CAMPO_PRECIO+" INT, "+CAMPO_PRECIOTOTAL+" INT, "+CAMPO_TIPO+" TEXT)";

    public static final String CREAR_TABLA_ORDEN2="CREATE TABLE "+TABLA_ORDEN2+"("+CAMPO_ID+" INTEGER, "+CAMPO_TITULO+" TEXT," +
            " "+CAMPO_DESCRIPCION+" TEXT, "+CAMPO_PRECIO+" INT, "+CAMPO_PRECIOTOTAL+" INT, "+CAMPO_TIPO+" TEXT)";
}
