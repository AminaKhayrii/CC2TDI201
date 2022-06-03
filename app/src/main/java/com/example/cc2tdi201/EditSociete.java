package com.example.cc2tdi201;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EditSociete extends AppCompatActivity {
    Spinner spr;
    EditText t1,t2,t3;
    Button btnEdit,btnDelete;
    MyDatabase data;
    ArrayList<Societe> liste;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_societe);

        spr.findViewById(R.id.spr);
        t1.findViewById(R.id.txtrc);
        t2.findViewById(R.id.txtads);
        t3.findViewById(R.id.txtcpt);
        btnEdit.findViewById(R.id.btnEdit);
        btnDelete.findViewById(R.id.btndelete);
        data=new MyDatabase(this);

        liste = MyDatabase.getAllSociete(data.getReadableDatabase());

        ArrayList<String> nomsSoc = new ArrayList<>();
        for(Societe pp: liste)
            nomsSoc.add(pp.getId() + " - " );

        ad = new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,nomsSoc);
        spr.setAdapter(ad);
        spr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Societe e=liste.get(i);
                t1.setText(e.getNom());
                t2.setText(e.getSecteur());
                t3.setText(Integer.valueOf(e.getNbEmploye()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void modifier(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditSociete.this);
        alert.setTitle("Modifier societe");
        alert.setMessage("Voulez-vous modifier cette societe ?");


        alert.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe s= liste.get(spr.getSelectedItemPosition());

                s.setNom(t1.getText().toString());
                s.setSecteur(t2.getText().toString());
                s.setNbEmploye(Integer.valueOf(t3.getText().toString()));

                if (MyDatabase.UpdateSociete(data.getWritableDatabase(), s) == -1)
                    Toast.makeText(EditSociete.this, "Modification echoue", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditSociete.this, "Modification reussie", Toast.LENGTH_SHORT).show();


            }
        });

        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditSociete.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();
    }

    public void supprimer(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(EditSociete.this);
        alert.setTitle("Suppression societe");
        alert.setMessage("Voulez-vous supprimer cette societe?");


        alert.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Societe s = liste.get(spr.getSelectedItemPosition());

                if(MyDatabase.DeleteSociete(data.getWritableDatabase(),s.getId())==-1)
                    Toast.makeText(EditSociete.this, "suppression echoue", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(EditSociete.this, "Suppression reussie", Toast.LENGTH_SHORT).show();
                    ad.remove(s.getId() + " - " + s.getNom());
                }
            }
        });
        alert.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(EditSociete.this, "Operation annulee", Toast.LENGTH_SHORT).show();
            }
        });

        alert.show();

    }
}