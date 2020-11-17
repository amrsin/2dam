package com.example.perrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static int OPINION_REQUEST_CODE = 1;
    private TextView tv_autores;
    private Button btn_mascota;
    private TextView tv_opnion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //identificamos elementos con sus correspondiente id y agregamos OnClickListener
        tv_autores = (TextView) findViewById(R.id.tv_autores);
        tv_autores.setOnClickListener(new click_listener());
        btn_mascota = (Button) findViewById(R.id.btn_mascota);
        btn_mascota.setOnClickListener(new click_listener());
        tv_opnion = (TextView) findViewById(R.id.tv_opinion);
    }

    //class listener para al hacer click
    class click_listener implements View.OnClickListener {


        @Override
        public void onClick(View v) {

            if (v == tv_autores) {

                navegador();//llamamos al metodo navegador


            }

            if (v == btn_mascota) {
                //bundle para pasar el string
                Bundle bundle = new Bundle();
                String imgName_pet = "pet1.jpg";
                bundle.putString("img_name", imgName_pet);

                //Iniciando la actividad Visor
                Intent intent = new Intent(MainActivity.this, ActivityVisor.class);
                intent.putExtras(bundle);
                //Inicio de la actividad esperando un resultado
                startActivityForResult(intent,OPINION_REQUEST_CODE);
            }
        }

        public void navegador() {

            Uri webpage = Uri.parse("https://www.iesserpis.org/");//pagina web donde quemos ir
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);//intente oara ir a la pagina

            // Verificar si hay aplicaciones disponibles
            PackageManager packageManager = getPackageManager();
            List activities = packageManager.queryIntentActivities(webIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            // Si hay, entonces ejecutamos la actividad
            if (isIntentSafe) {
                Toast.makeText(MainActivity.this, "Iniciando navegador", Toast.LENGTH_SHORT).show();
                startActivity(webIntent);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == OPINION_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                Bundle bundel2 = data.getExtras();
                tv_opnion.setText("Tu opinion fué " + bundel2.getString("opnion"));

            }
        }

    }
}