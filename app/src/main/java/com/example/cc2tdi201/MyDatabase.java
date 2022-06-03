package com.example.cc2tdi201;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public static String Db_Name="societes.db";
    public static String table="Societe";
    public static String col1="id";
    public static String col2="nom";
    public static String col3=", secteur_activite";
    public static String col4=", nb_employe";

    public MyDatabase(Context c){
        super(c,Db_Name,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String req = "create table " + table + "("+col1+" integer primary key autoincrement,"+col2+" TEXT,"+col3+" TEXT,"+col4+" integer)";
        sqLiteDatabase.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String req= "DROP TABLE " + table;
        sqLiteDatabase.execSQL(req);
        onCreate(sqLiteDatabase);

    }
}
