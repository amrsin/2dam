package com.example.dos_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class segunda_pantalla extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        Button btn_volver = (Button) findViewById(R.id.btn_volver);

        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(segunda_pantalla.this, MainActivity.class);
                startActivity(intent);
               
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A2:onStart", Toast.LENGTH_LONG).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A2:onResume", Toast.LENGTH_LONG).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A2:onStop", Toast.LENGTH_LONG).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "A2:onRestart", Toast.LENGTH_LONG).show();
    }


    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "A2:onDestroy", Toast.LENGTH_LONG).show();
    }
}