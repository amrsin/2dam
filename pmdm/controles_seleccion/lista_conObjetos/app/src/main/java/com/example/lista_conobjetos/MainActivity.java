package com.example.lista_conobjetos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Titulo1", "Subtitulo largo1", R.drawable.ic_launcher_foreground),
            new Titular("Titulo2", "Subtitulo largo2", R.drawable.ic_launcher_foreground),
            new Titular("Titulo3", "Subtitulo largo3", R.drawable.ic_launcher_foreground)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView list_titular = (ListView) findViewById(R.id.list_titular);
        list_titular.setAdapter(adaptador);

        list_titular.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String msg = "Titulo " + datos[position].getTitulo() + " Subtitulo: " + datos[position].getSubtitulo();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.list_layout, datos);
            this.context = context;
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public View getView(int i, View convertView, ViewGroup parent) {

            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_layout, null);

            TextView tv_titulo = (TextView) item.findViewById(R.id.tv_Titulo);
            tv_titulo.setText(datos[i].getTitulo());

            TextView tv_subtitulo = (TextView) item.findViewById(R.id.tv_subtitulo);
            tv_subtitulo.setText(datos[i].getSubtitulo());

            ImageView img = (ImageView) item.findViewById(R.id.img);
            img.setBackground(getDrawable(datos[i].getImg()));

            return (item);
        }
    }
}
