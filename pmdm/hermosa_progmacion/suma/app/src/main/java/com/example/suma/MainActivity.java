package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        //identificamos btn por su id
        btn_frag = (Button) findViewById(R.id.btn_frag);
        //listener al btn_frag
        btn_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragment();

            }
            //metodo para cargar el fragmento
            public void fragment() {

                FragmentManager fragmentManager = getSupportFragmentManager();
                BlankFragment blankFragment = new BlankFragment();

                fragmentManager.beginTransaction()

                .add(R.id.contenedor, blankFragment)
                .commit();


            }
        });
    }
}