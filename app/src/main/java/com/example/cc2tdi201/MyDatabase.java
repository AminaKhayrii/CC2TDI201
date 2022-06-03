package com.example.cc2tdi201;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

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

    public static long DeleteSociete(SQLiteDatabase sqLiteDatabase, int id){
        return  sqLiteDatabase.delete(table,"id="+id,null);

    }
    public static ArrayList<Societe> getAllSociete(SQLiteDatabase sqLiteDatabase){
        ArrayList<Societe> listeSociete=new ArrayList<>();
        Cursor curs = sqLiteDatabase.rawQuery("SELECT * FROM " + table,null);

        while(curs.moveToNext()){
            Societe sc= new Societe();
            sc.setId(curs.getInt(0));
            sc.setNom(curs.getString(1));
            sc.setSecteur(curs.getString(2));
            sc.setNbEmploye(curs.getInt(3));

            listeSociete.add(sc);
        }

        return listeSociete;
    }
}
