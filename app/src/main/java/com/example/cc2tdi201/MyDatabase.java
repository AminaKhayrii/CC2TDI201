package com.example.cc2tdi201;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public static String Db_Name="societes.db";
    public static String table="Societe";
    public static String col1="id";
    public static String col2="Raison_Sociale";
    public static String col3=", Secteur_activite";
    public static String col4=", nb_employe";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
