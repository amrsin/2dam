package com.example.prueba_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkbox_Cycling;
    private CheckBox chkbox_Teaching;
    private CheckBox chkbox_Blogging;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //var
        chkbox_Cycling = (CheckBox)findViewById(R.id.chkbox_Cycling);
        chkbox_Teaching = (CheckBox)findViewById(R.id.chkbox_Teaching);
        chkbox_Blogging = (CheckBox)findViewById(R.id.chkbox_Blogging);
        Button btn_hobby = (Button)findViewById(R.id.btn_hobby);
        Button btn_checbox_v2 = (Button)findViewById(R.id.btn_chk_v2);

        final TextView tv_hobby = (TextView)findViewById(R.id.tv_hobby);
        //al hacer click en btn_hobby
        btn_hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = "";
                //deteminando cual esta checked concatena en variable msg hobby
                if (chkbox_Cycling.isChecked()) {

                    msg = msg + "Cycling ";
                }

                if (chkbox_Teaching.isChecked()) {

                    msg = msg + "Teaching ";
                }

                if (chkbox_Blogging.isChecked()) {

                    msg = msg + "Blogging ";
                }
                tv_hobby.setText(msg);
            }
        });
        //al hacer click en btn_checkbox_v2 pasa a MainActivity2
        btn_checbox_v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_activity2 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent_activity2);
            }
        });
    }
}