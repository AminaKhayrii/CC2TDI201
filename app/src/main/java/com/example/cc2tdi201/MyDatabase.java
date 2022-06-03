package com.example.cc2tdi201;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {
    public static String Db_Name="societes.db";
    public static String table="Societe";
    public static String col1="id";
    public static String col2="nom";
    public static String col3="secteur";
    public static String col4="nb_employe";

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

    public static long AddSociete(SQLiteDatabase sqLiteDatabase, Societe e){
        ContentValues ct=new ContentValues();
        ct.put(col2,e.getNom());
        ct.put(col3,e.getSecteur());
        ct.put(col4,e.getNbEmploye());
        return sqLiteDatabase.insert(table,null,ct);

    }
    public static long UpdateSociete(SQLiteDatabase sqLiteDatabase, Societe e){
        ContentValues ct=new ContentValues();
        ct.put(col2,e.getNom());
        ct.put(col3,e.getSecteur());
        ct.put(col4,e.getNbEmploye());
        return sqLiteDatabase.update(table,ct,"id="+e.getId(),null);


    }
}
