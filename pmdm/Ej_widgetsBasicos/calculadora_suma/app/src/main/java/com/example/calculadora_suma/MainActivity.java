package com.example.calculadora_suma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit_t1, edit_t2;
    private TextView text_v;
    private Button bt_suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //identificar elementos con su correspondiente id
        edit_t1= (EditText) findViewById(R.id.txt_num1);
        edit_t2 = (EditText) findViewById(R.id.txt_num2);
        text_v = (TextView) findViewById(R.id.resultado);
        bt_suma = (Button) findViewById(R.id.button_suma);
        //listener suma
        bt_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int num_1;
                    int num_2;
                    int suma;
                    num_1 = Integer.parseInt(edit_t1.getText().toString());
                    num_2 = Integer.parseInt(edit_t2.getText().toString());
                    suma = num_1 + num_2;
                    text_v.setText(String.valueOf(num_1 + " + " + num_2 + " = " +  suma));
                }catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Introduzca dos numeros enteros", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}