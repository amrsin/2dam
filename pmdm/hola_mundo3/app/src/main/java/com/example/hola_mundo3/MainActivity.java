package com.example.hola_mundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final TextView vuelve = (TextView)findViewById(R.id.vuelve);

    public static int cod_respuesta = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText escribe_saludo = (EditText)findViewById(R.id.escibe_saludo);
        final Button btn_pulsar = (Button)findViewById(R.id.btn_pulsar);


        escribe_saludo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                if (b) {
                    escribe_saludo.setText("");
                }
            }
        });

        btn_pulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pantalla_2.class);
                Bundle bundle = new Bundle();
                String msg = "Te saludo " + escribe_saludo.getText();
                bundle.putString("saludo", msg);
                intent.putExtras(bundle);
                startActivityForResult(intent, cod_respuesta);
            }


        });
    }


   protected void onActivityResult (int cod_resp, int cod_result, Intent intent){

        if(cod_result == RESULT_OK){

            Bundle bundel2 = intent.getExtras();
            vuelve.setText(bundel2.getString("Devuelto"));
        }
    }
}