package com.example.gestion_matricula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gestion_matricula.Alumno.Alumnos;
import com.example.gestion_matricula.Asignatura.Asignaturas;

public class MainActivity extends AppCompatActivity {

    private Button btn_asignaturas, btn_alumnos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //identificamos los elementos por su id's
        getSupportActionBar().setTitle("Gestion Matricula");
        btn_asignaturas = (Button) findViewById(R.id.btn_asignaturas);
        btn_alumnos = (Button) findViewById(R.id.btn_alumnos);

        btn_asignaturas.setOnClickListener(new listener_btn());
        btn_alumnos.setOnClickListener(new listener_btn());

    }
    //listener para botones
    class listener_btn implements View.OnClickListener {


        @Override
        public void onClick(View view) {

            if (view.equals(btn_asignaturas)) {

                Intent intent = new Intent(MainActivity.this, Asignaturas.class);
                startActivity(intent);

            }

            if (view.equals(btn_alumnos)) {

                Intent intent = new Intent(MainActivity.this, Alumnos.class);
                startActivity(intent);

            }
        }
    }
}