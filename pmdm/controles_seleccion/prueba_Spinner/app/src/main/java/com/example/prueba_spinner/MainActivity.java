package com.example.prueba_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //var
    Spinner spinner_1;
    final static String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //var
        spinner_1 = (Spinner) findViewById(R.id.spinner_1);
        String msg;
        //ArrayAdapter en cual escogemos la plantilla ya creada de spinner "simple_spinner_dropdown_item en la cual añadimos el array de semana
        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, semana);
        miAdaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//indicamos que va ser desplegable el spinner no es necesario en este caso porque usamos platilla por defecto
        spinner_1.setAdapter(miAdaptador);//establecemos el adapter a la lview
        //listerner spinner_1  en cual indicara en toast el elemento seleciconado
        spinner_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String msg;
                msg = "Item selected => " + semana[position];
                showToast(msg);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    //toast del elemnto seleccionado
    public void showToast(String text) {

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}