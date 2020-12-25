package com.example.calculadora_fragmento_dinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //identificamos el switch segun su id
        final Switch switch_calculadra = (Switch) findViewById(R.id.switch_calculadora);

        //listener para el switch
        switch_calculadra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                //si es activo
                if (isChecked) {
                    //cargamos el fragmento
                    fragment_laod();
                //sino
                }else {
                    //quitamos el fragmento
                    fragment_remove();
                }
            }
            //metodo para cargar el fragmento
            public void fragment_laod() {

                FragmentManager fragmentManager = getSupportFragmentManager();
                CalculadoraFragment calculadoraFragment = new CalculadoraFragment();

                fragmentManager.beginTransaction()
                        .add(R.id.container_calculadora, calculadoraFragment)
                        .commit();

                Toast.makeText(MainActivity.this, "Fragment is added", Toast.LENGTH_SHORT).show();

            }
            //metodo para quitar el fragmento
            public void fragment_remove() {

                getSupportFragmentManager().beginTransaction().
                        remove(getSupportFragmentManager()
                        .findFragmentById(R.id.container_calculadora))
                        .commit();

                Toast.makeText(MainActivity.this, "Fragment is removed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}