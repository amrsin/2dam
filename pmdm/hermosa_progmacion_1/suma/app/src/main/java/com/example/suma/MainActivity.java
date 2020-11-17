package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText et_num_1;
    private EditText et_num_2;
    private TextView tv_result;
    private Button btn_suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_num_1 = (EditText) findViewById(R.id.num_1);
        et_num_2 = (EditText) findViewById(R.id.num_2);
        tv_result = (TextView)findViewById(R.id.tv_result);
        btn_suma = (Button) findViewById(R.id.btn_suma);

        btn_suma.setOnClickListener(new btn_listener());

    }


    class btn_listener implements View.OnClickListener {

        int num_1;
        int num_2;
        int suma;

        @Override
        public void onClick(View v) {

            suma();

        }

        public void suma() {

            try {

                num_1 = Integer.parseInt(et_num_1.getText().toString());
                num_2 = Integer.parseInt(et_num_2.getText().toString());
                suma = num_1 + num_2;

                tv_result.setText(num_1 + " + " + num_2 + " = " + Integer.toString(suma));

            }catch (Exception e) {

                tv_result.setText("Introduzca numeros");
            }


        }
    }
}