package com.example.prueba_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //var
    ListView lview;
    final static String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //var
        String msg;
        lview = (ListView)findViewById(R.id.list1);
        //ArrayAdapter en cual escogemos la plantilla ya creada de list "simple_list_item_1 en la cual añadimos el array de semana
        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, semana);
        lview.setAdapter(miAdaptador);//establecemos el adapter a la lview

        //listerner lview  en cual indicara en toast el elemento seleciconado
        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String msg= "";
                msg = "Item clicked => " + semana[position];
                showToast(msg);
            }
        });

    }
    //toast del elemnto seleccionado
     public void showToast(String text) {

         Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
     }
}