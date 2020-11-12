package com.example.ej_2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageButton img_btn_red;
    private ImageButton img_btn_blue;
    private TextView tv_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //identificamos los elementos con el correspondiente ed
        img_btn_red = (ImageButton)findViewById(R.id.img_bt_red);
        img_btn_blue = (ImageButton)findViewById(R.id.img_bt_blue);
        tv_color = (TextView)findViewById(R.id.tv_color);
        //añadimos listener a los dos img_btn creando neeva clase img_listener
        img_btn_red.setOnClickListener(new img_listener());
        img_btn_blue.setOnClickListener(new img_listener());

    }
    //clase img_listener
    class img_listener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            //dependiendo quien llame a la clase asignara el color
            if (view == img_btn_red) {

                tv_color.setBackgroundColor(Color.RED);

            }else if(view == img_btn_blue) {

                tv_color.setBackgroundColor(Color.BLUE);

            }
        }
    }
}