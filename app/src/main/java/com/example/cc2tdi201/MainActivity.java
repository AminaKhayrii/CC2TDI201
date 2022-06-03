package com.example.cc2tdi201;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newForm(View view) {
        Intent i = null;
        switch (view.getId()){
            case R.id.btnAdd: i=new Intent(MainActivity.this, AddSociete.class); break;
            case R.id.btnEdit: i=new Intent(MainActivity.this, EditSociete.class); break;
            case R.id.btnLst: i=new Intent(MainActivity.this, listeSociete.class); break;

        }
        startActivity(i);

    }
}