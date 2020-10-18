package com.example.prueba_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CheckBox chkbox_Cycling = (CheckBox)findViewById(R.id.chkbox_Cycling);
        final CheckBox chkbox_Teaching = (CheckBox)findViewById(R.id.chkbox_Teaching);
        final CheckBox chkbox_Blogging = (CheckBox)findViewById(R.id.chkbox_Blogging);
        Button btn_hobby = (Button)findViewById(R.id.btn_hobby);
        final TextView tv_hobby = (TextView)findViewById(R.id.tv_hobby);

        btn_hobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = "";

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

    }
}