package com.example.dos_pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class segunda_pantalla extends AppCompatActivity {

    private EditText edit_t1, edit_t2;
    private TextView text_v;
    private Button bt_suma;

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

        edit_t1= (EditText) findViewById(R.id.txt_num1);
        edit_t2 = (EditText) findViewById(R.id.txt_num2);
        text_v = (TextView) findViewById(R.id.resultado);
        bt_suma = (Button) findViewById(R.id.button_suma);

        bt_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num_1;
                int num_2;
                int suma;
                num_1 = Integer.parseInt(edit_t1.getText().toString());
                num_2 = Integer.parseInt(edit_t2.getText().toString());
                suma = num_1 + num_2;
                text_v.setText(String.valueOf(num_1 + " + " + num_2 + " = " +  suma));

            }
        });
    }

    /*protected void onStart() {
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
    }*/
}