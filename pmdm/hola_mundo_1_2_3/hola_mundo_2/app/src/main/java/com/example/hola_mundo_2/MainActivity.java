package com.example.hola_mundo_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //var
        final EditText escribe_Eview = (EditText)findViewById(R.id.escribe_editText);
        final Button pulsar_btn = (Button) findViewById(R.id.pulsar_btn);

        //al hacer click en pulsar_button
        pulsar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, activity_pantalla2.class);//intent de la actividad activity_pantalla2

                Bundle miBundle = new Bundle();//bundel para gurdar el mensaje
                String msg = "Te saludo " + escribe_Eview.getText();//guardamos el saludo con nombre introduccido en escribe_Eview
                miBundle.putString("TEXTO", msg);//guadamos en bundle el string
                miIntent.putExtras(miBundle);//añadimos el bundel al intent
                startActivity(miIntent);//iniciamos la actividad

            }
        });
    }
}