package com.example.gestion_matricula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Asignaturas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        getSupportActionBar().setTitle("Asignaturas");

    }
}