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

public class MainActivity2 extends AppCompatActivity {

    private CheckBox chkbox_Cycling;
    private CheckBox chkbox_Teaching;
    private CheckBox chkbox_Blogging;
    private String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        chkbox_Cycling = (CheckBox)findViewById(R.id.chkbox_Cycling);
        chkbox_Teaching = (CheckBox)findViewById(R.id.chkbox_Teaching);
        chkbox_Blogging = (CheckBox)findViewById(R.id.chkbox_Blogging);
        Button btn_hobby = (Button)findViewById(R.id.btn_hobby);
        Button btn_checbox_v1 = (Button)findViewById(R.id.btn_chk_v1);
        final TextView tv_hobby = (TextView)findViewById(R.id.tv_hobby);

        chkbox_Cycling.setOnCheckedChangeListener(new MainActivity2.checkboxListener());
        chkbox_Teaching.setOnCheckedChangeListener(new MainActivity2.checkboxListener());
        chkbox_Blogging.setOnCheckedChangeListener(new MainActivity2.checkboxListener());

        btn_checbox_v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_Main_activity = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent_Main_activity);
            }
        });


    }

    class checkboxListener implements CheckBox.OnCheckedChangeListener {


        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


            if(isChecked) {

                if (buttonView == chkbox_Cycling) {

                    msg = msg + "Cycling ";
                }

                if (buttonView == chkbox_Teaching) {

                    msg = msg + "Teaching ";
                }

                if (buttonView == chkbox_Blogging) {

                    msg = msg + "Blogging ";
                }
                showTextNotification(msg);

            }else {

                msg = "";
            }
        }

        public  void showTextNotification(String msg) {

            Toast.makeText(MainActivity2.this, msg, Toast.LENGTH_SHORT).show();

        }
    }


}