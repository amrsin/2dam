package com.example.perrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityVisor extends AppCompatActivity {

    private TextView tv_pet;
    private RadioGroup radioGroup;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);
        //identificamos elementos con sus id correspondientes
        tv_pet = (TextView) findViewById(R.id.tv_pet);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btn_send = (Button) findViewById(R.id.btn_send);

        //bundle para recoger String de MainActivity
        Bundle bunde_recoge = getIntent().getExtras();
        String pet_name = bunde_recoge.getString("img_name");
        //set el valor del bundle en el TextView
        tv_pet.setText(pet_name);
        //Añadiendo escucha al botón send_button
        btn_send.setOnClickListener(new btn_listener());

    }
    //Listener para btn_send
    class btn_listener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            String opinion = "";
            RadioButton currentRadio = (RadioButton) findViewById(radioGroup
                    .getCheckedRadioButtonId());

            //Obtener la cadena del radiobutton
            try {
                opinion = currentRadio.getText().toString();
            }catch (Exception e) {
                Toast.makeText(ActivityVisor.this, "Falta opinion, selecciona algun RadioButton porfavor", Toast.LENGTH_SHORT).show();
            }

            Intent intent_vuelve = new Intent();//creamos intent
            Bundle bundle_vuelve = new Bundle();//craemos bundle
            if (!opinion.equals("")) {

                bundle_vuelve.putString("opnion", opinion);//ponemos en bundle var opnion
                intent_vuelve.putExtras(bundle_vuelve);//ponemos en intent el bundle
                //Devolver por el canal de forma exitosa el mensaje del intent
                setResult(RESULT_OK, intent_vuelve);
                //Terminar la actividad
                finish();

            }

        }
    }
}