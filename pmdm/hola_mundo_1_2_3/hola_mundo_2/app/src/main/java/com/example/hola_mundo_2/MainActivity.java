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

        EditText escirbe_tview = (EditText)findViewById(R.id.escribe_editText);
        Button pulsar_btn = (Button) findViewById(R.id.pulsar_btn);


        pulsar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                Intent miIntent = new Intent(MainActivity.this, activity_pantalla2.class);

                Bundle miBundle = new Bundle();
                String msg = "Te saludo " + escirbe_tview.getText();
                miBundle.putString("TEXTO", msg);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);


                //Toast.makeText(this, "DEBE INTRODUCIR UN USUARIO", Toast.LENGTH_SHORT).show();


            }
        });
    }
}