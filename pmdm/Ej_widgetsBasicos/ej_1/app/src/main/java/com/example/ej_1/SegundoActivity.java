package com.example.ej_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SegundoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity());

        final CheckBox chk_prueba = (CheckBox)findViewById(R.id.chk_prueba);
        Button btn_vuelveMain = (Button)findViewById(R.id.btn_vuelveMain);

        btn_vuelveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SegundoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        chk_prueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (chk_prueba.isChecked()) {

                    Toast.makeText(SegundoActivity.this, "Haz marcado el checkBox", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SegundoActivity.this, "Haz desmarcado el checkbox", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public int activity() {

        Bundle bunde_recoge = getIntent().getExtras();
        int act = bunde_recoge.getInt("activity");

        return act;
    }
}