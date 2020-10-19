package com.example.radiobutton_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView lbl_radios = (TextView)findViewById(R.id.lbl_radios);
        final RadioGroup radio_g = (RadioGroup)findViewById(R.id.group_radio);

        radio_g.clearCheck();
        radio_g.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String op = "";

                if (group.getCheckedRadioButtonId()==R.id.radio_1) {

                    op = op + "OPCION 1 con ID: " + checkedId;

                }

                if (group.getCheckedRadioButtonId()==R.id.radio_2) {

                    op = op + "OPCION 2 con ID: " + checkedId;

                }


                lbl_radios.setText(op);
            }
        });


    }
}