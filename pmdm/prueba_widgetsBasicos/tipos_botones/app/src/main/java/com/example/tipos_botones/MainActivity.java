package com.example.tipos_botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //var
        final TextView lbl_msg = (TextView)findViewById(R.id.lbl_msg);
        Button btn_1 = (Button)findViewById(R.id.btn_1);
        final ToggleButton btn_2 = (ToggleButton)findViewById(R.id.btn_2);
        ImageButton btn_3 = (ImageButton)findViewById(R.id.btn_3);
        final ToggleButton btn_4 = (ToggleButton)findViewById(R.id.btn_4);

        //al hacer click btn_1
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lbl_msg.setText("Boton 1 pulsado!"); //en lbl_msg indicara Boton 1 pulsado
            }
        });
        //al hacer click btn_2
       btn_2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //si esta activo
               if (btn_2.isChecked()) {
                   lbl_msg.setText("Buton 2: ON"); //en lbl_msg indicara Boton 2 ON
               }else{//SINO
                   lbl_msg.setText("Buton 2: OFF"); //en lbl_msg indicara Boton 2 OFF
               }
           }
       });
        //al hacer click btn_3
        btn_3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               lbl_msg.setText("Buton 3 pulsado!"); //en lbl_msg indicara Boton 3 pulsado!
           }
       });
        //al hacer click btn_4
       btn_4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //si esta activo
               if (btn_4.isChecked()) {
                   lbl_msg.setText("Buton 4: ON"); //en lbl_msg indicara Boton 4 ON
               }else {
                   lbl_msg.setText("Buton 4: OFF"); //en lbl_msg indicara Boton 4 OFF
               }
           }
       });
    }
}