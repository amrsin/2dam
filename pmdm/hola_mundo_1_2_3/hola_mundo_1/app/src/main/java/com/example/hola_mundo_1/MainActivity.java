package com.example.hola_mundo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //var
        final EditText miTexto = (EditText) findViewById(R.id.miTxt);
        final Button miButton = (Button) findViewById(R.id.miBtn);
        final TextView elSaludos = (TextView) findViewById(R.id.miLbl);

        //al hacer click en miButton se hace un setText Te saludo + el texto puesto en miTexto
        miButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg_saludo = "Te saludo " + miTexto.getText();
                elSaludos.setText(msg_saludo.toUpperCase());
            }
        });
    }
}