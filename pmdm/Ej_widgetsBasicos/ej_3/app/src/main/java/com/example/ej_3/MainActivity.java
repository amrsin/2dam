package com.example.ej_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    TextView textView_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identificamos los elementos segun id
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        textView_color = (TextView) findViewById(R.id.textView_color);
        //agregamos listener al RadioGroup
        radioGroup.setOnCheckedChangeListener(new radio_listener());

    }
    //listener radioGroup
    class radio_listener implements RadioGroup.OnCheckedChangeListener {


        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            //dependiendo cual esta seleccionado se asigna el correspondiente color
            if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton_rojo) {

                textView_color.setBackgroundColor(Color.RED);
            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton_verde) {

                textView_color.setBackgroundColor(Color.GREEN);
            }
            if (radioGroup.getCheckedRadioButtonId() == R.id.radioButton_azul) {

                textView_color.setBackgroundColor(Color.BLUE);
            }
        }
    }
}