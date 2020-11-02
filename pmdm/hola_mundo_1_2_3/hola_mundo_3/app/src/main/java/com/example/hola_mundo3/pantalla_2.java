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

         final TextView saludo2 = (TextView)findViewById(R.id.saludo2);
         final Button btn_volver = (Button)findViewById(R.id.btn_volver);


         Bundle bundle_recoge = getIntent().getExtras();
         saludo2.setText(bundle_recoge.getString("saludo"));
         final String completarSaludo=bundle_recoge.getString("saludo");

         btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vuelve = new Intent();
                Bundle bundle_vuelve = new Bundle();
                String msg = " Devuelvo a principal " + completarSaludo;
                bundle_vuelve.putString("Devuelto", msg);
                intent_vuelve.putExtras(bundle_vuelve);
                setResult(RESULT_OK, intent_vuelve);
                finish();
            }
        });
    }
}