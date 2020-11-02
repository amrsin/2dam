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

      //var
      public static int cod_respuesta = 0;
      private TextView vuelve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //var
        final EditText escribe_saludo = (EditText)findViewById(R.id.escibe_saludo);
        final Button btn_pulsar = (Button)findViewById(R.id.btn_pulsar);
        vuelve = (TextView)findViewById(R.id.vuelve);

        //al tener el foco en escribe_saludo se vaciara el EditText
        escribe_saludo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                if (b) {
                    escribe_saludo.setText("");
                }
            }
        });

        //al hacer click en boton btn_pulsar
        btn_pulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pantalla_2.class); //se crear un intent de pantalla_2
                Bundle bundle = new Bundle(); //Creamos Bundle para poner texto
                String msg = "Te saludo " + escribe_saludo.getText(); //saludos + lo que ha escrito en EditText escribe_saludo
                bundle.putString("saludo", msg);//ponemos el msg en bundle
                intent.putExtras(bundle);//agregamos el bundle al intent
                startActivityForResult(intent, cod_respuesta);//empezamos el activity y comprobara que la otra activity ha acabado bien
            }

        });
    }
    //metodo onActivityResult
   @Override
    protected void onActivityResult(int cod_resp, int cod_result, Intent intent) {


        super.onActivityResult(cod_resp, cod_result, intent);
        //si la otra actividad ha acabado bien
        if (cod_result == RESULT_OK) {

            //bundle para recoger el saludo completo
            Bundle bundel2 = intent.getExtras();
            vuelve.setText(bundel2.getString("Devuelto"));
        }
    }
}