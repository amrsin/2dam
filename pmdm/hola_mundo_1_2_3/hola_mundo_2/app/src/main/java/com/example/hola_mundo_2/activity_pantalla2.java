package com.example.hola_mundo_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        //var
        TextView mi_mensaje = (TextView) findViewById(R.id.miMensaje);
        Button pulsar_volver = (Button) findViewById(R.id.btn_volver);
        //Bundle para revoger el nombre introducido en mainActivity
        Bundle miBundleRecoger = getIntent().getExtras();
        mi_mensaje.setText(miBundleRecoger.getString("TEXTO"));//setText saludos al lbl mi_mensaje
        //al hacer clicl en boton pulsar_volver
        pulsar_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(activity_pantalla2.this, MainActivity.class);//intent de MainActivity
                startActivity(miIntent); //iniciamos la actividad
            }
        });
    }
}