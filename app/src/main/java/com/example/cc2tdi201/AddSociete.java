package com.example.cc2tdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddSociete extends AppCompatActivity {
    EditText t1,t2,t3;
    Button btnSave,btnCancel;
    MyDatabase data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_societe);
    }

    public void enregistrer(View view) {
        if(t1.getText().toString().isEmpty()){
            Toast.makeText(this, "nom vide", Toast.LENGTH_SHORT).show();
            t1.requestFocus();
            return;
        }
        if(t2.getText().toString().isEmpty()){
            Toast.makeText(this, "secteur vide", Toast.LENGTH_SHORT).show();
            t2.requestFocus();
            return;
        }
        if(t3.getText().toString().isEmpty()){
            Toast.makeText(this, "nombre d'employe vide", Toast.LENGTH_SHORT).show();
            t3.requestFocus();
            return;
        }
        Societe s=new Societe();
        s.setId(1);
        s.setNom(t1.getText().toString());
        s.setSecteur(t2.getText().toString());
        s.setNbEmploye(Integer.parseInt( t3.getText().toString()));

        if(MyDatabase.AddSociete(data.getWritableDatabase(),s)==-1){
            Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Reussie", Toast.LENGTH_SHORT).show();
        }
    }

    public void annuler(View view) {
        finish();
    }
}