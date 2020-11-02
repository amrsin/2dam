package com.example.hola_mundo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class pantalla_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_2);

        //var
         final TextView saludo2 = (TextView)findViewById(R.id.saludo2);
         final Button btn_volver = (Button)findViewById(R.id.btn_volver);

         //bundle para recoger el texto de EditText en MainActivity
         Bundle bundle_recoge = getIntent().getExtras();
         saludo2.setText(bundle_recoge.getString("saludo")); //setText al saludo2 con saludo
         final String completarSaludo=bundle_recoge.getString("saludo");//saludo

         btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vuelve = new Intent();//creamos intent
                Bundle bundle_vuelve = new Bundle();//craemos bundle
                String msg = " Devuelvo a principal " + completarSaludo;//msg con saludo para devolver al lbl MainActivity
                bundle_vuelve.putString("Devuelto", msg);//ponemos en bundle el msg
                intent_vuelve.putExtras(bundle_vuelve);//ponemos en intent el bundle
                setResult(RESULT_OK, intent_vuelve);//ponemos que RESULT_OK mas el intent
                finish();//acabamos actividad pantalla_2 de esta manera volvera bien al actictyMain
            }
        });
    }
}