package com.example.Tarea_1_3_Salvar_Informacion_SQlite.configuracion;

public class Transacciones
{
    // Nombre de la base de datos
    public static final String NameDatabase = "PM01DB";
    /*
    TABLAS DE LA BASE DE DATOS EN  SQLLITE
    * **/
    public static final String tablaPersonas = "personas";

    /*
    CAMPOS DE LA TABLA PERSONAS DE LA  BASE DE DATOS EN SQL
     */

    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";

    /*
    TRANSACCIONES DDL(Data Definition Lenguage) TABLA PERSONAS
     */
    public static final String CreateTablePersonas = "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT, direccion TEXT)";

    public static final String DROPTablePersonas = "DROP TABLE IF EXISTS personas";
}
