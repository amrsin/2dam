package com.example.first_dialogfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SimpleDialog.OnSimpleDialogListener {

    Button btn_dialog;
    TextView textView_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciamos los elementos
        btn_dialog = (Button) findViewById(R.id.btn_dialog);
        textView_msg = (TextView) findViewById(R.id.tv_msg);
        //añadimos listener al btn
        btn_dialog.setOnClickListener(new btn_listener());



    }

    //metodos de intefaz OnSimpleDialogListener
    @Override
    public void onPossitiveButtonClick() {

        textView_msg.setText("Text changed");
        Toast.makeText(this, "Changed", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNegativeButtonClick() {

        Toast.makeText(this, "I do not change anything", Toast.LENGTH_SHORT).show();
    }

    //class para btn_dialog
    class btn_listener implements View.OnClickListener {


        @Override
        public void onClick(View v) {

            initDialogFragment(); //llamamos al metodo initDialogFragment
        }

        public void initDialogFragment () {

            new SimpleDialog().show(getSupportFragmentManager(), "SimpleDialog"); //instanciamos el dialogo

        }
    }
}