package com.example.dos_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton img_btn = (ImageButton) findViewById(R.id.img_btn);
        final TextView result = (TextView) findViewById(R.id.result);

        Toast.makeText(this, "el texto", Toast.LENGTH_SHORT).show();


        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showToast("Espere");


                Intent intent = new Intent(MainActivity.this, segunda_pantalla.class);
                startActivity(intent);



            }
        });






    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        //CharSequence text = getResources().getString(R.string.noNameMsg);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /*protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A1:onStart", Toast.LENGTH_LONG).show();
    }

    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "A1:onResume", Toast.LENGTH_LONG).show();
    }

    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "A1:onStop", Toast.LENGTH_LONG).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "A1:onRestart", Toast.LENGTH_LONG).show();
    }


    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "A1:onDestroy", Toast.LENGTH_LONG).show();
    }*/

}