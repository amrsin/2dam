package com.example.hola_mundo3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   public static int cod_respuesta = 0;
   final TextView volve = (TextView)findViewById(R.id.vuelve);

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

    @Override
    protected void onActivityResult(int cod_resp, int cod_result, Intent intent) {


        super.onActivityResult(cod_resp, cod_result, intent);
        if (cod_result == RESULT_OK) {

            Bundle bundel2 = intent.getExtras();
            volve.setText(bundel2.getString("saludo"));
        }
    }
}