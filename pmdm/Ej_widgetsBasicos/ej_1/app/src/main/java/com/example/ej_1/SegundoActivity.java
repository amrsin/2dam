package com.example.ej_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SegundoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity());//le asignamos el layout  recogiendo del bundle el int de activity correspondiente
        //identificamos elementos segun su id
        final CheckBox chk_prueba = (CheckBox)findViewById(R.id.chk_prueba);
        Button btn_vuelveMain = (Button)findViewById(R.id.btn_vuelveMain);
        //listener para el btn
        btn_vuelveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent para volver a MainActivity
                Intent intent = new Intent(SegundoActivity.this, MainActivity.class);
                startActivity(intent);//inicamos MainActivity
            }
        });
        //listener para el chk
        chk_prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //si esta checked entonces lanza toast de que haz marcado el checkbox
                if (chk_prueba.isChecked()) {

                    Toast.makeText(SegundoActivity.this, "Haz marcado el checkBox", Toast.LENGTH_SHORT).show();
                }else {//sino toast de que haz desmarcado el checkbox
                    Toast.makeText(SegundoActivity.this, "Haz desmarcado el checkbox", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //metodo para recoger el bundle de MainActivity con el int de layout a asignar
    public int activity() {

        Bundle bunde_recoge = getIntent().getExtras();
        int act = bunde_recoge.getInt("activity");

        return act;
    }
}