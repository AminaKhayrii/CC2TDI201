package com.example.cc2tdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class listeSociete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_societe);

        ListView liste;
        MyDatabase data;

        liste=findViewById(R.id.lst);
        data=new MyDatabase(this);
        ArrayList<Societe> e =MyDatabase.getAllSociete(data.getReadableDatabase());
        ArrayList<HashMap<String,Object>> h = new ArrayList<>();
        for(Societe sc : e){
            HashMap<String,Object> hm =new HashMap<>();
            hm.put("nom",sc.getNom());
            hm.put("nb_employe",sc.getNbEmploye());
            h.add(hm);
        }
        String[] from = {"nom","nb_employe"};
        int [] tr ={R.id.txtNom,R.id.txtNB};
        SimpleAdapter b = new SimpleAdapter(this,h,R.layout.activity_liste_societe,from,tr);
        liste.setAdapter(b);


    }
}