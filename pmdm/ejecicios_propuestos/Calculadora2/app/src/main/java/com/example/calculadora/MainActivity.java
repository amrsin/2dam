package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String txt = "";
    double num_1 = 0;
    int cont_igual = 0;
    int cont_punto = 0;
    double num_2 = 0;
    double num_result = 0;
    char signo;
    private TextView tv_numero;
    private Button btn_clear, btn_dividir, btn_multi, bnt_borar, btn_num_7,
            btn_num_8, btn_num_9, btn_resta, btn_num_4, btn_num_5, btn_num_6,
            btn_suma, btn_num_1, btn_num_2, btn_num_3, btn_igual, btn_num_0, btn_punto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //identificamos elementos segun id
        tv_numero = (TextView) findViewById(R.id.tv_numero);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_dividir = (Button) findViewById(R.id.btn_dividir);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        bnt_borar = (Button) findViewById(R.id.btn_borrar);
        btn_num_7 = (Button) findViewById(R.id.btn_num_7);
        btn_num_8 = (Button) findViewById(R.id.btn_num_8);
        btn_num_9 = (Button) findViewById(R.id.btn_num_9);
        btn_resta = (Button) findViewById(R.id.btn_restar);
        btn_num_4 = (Button) findViewById(R.id.btn_num_4);
        btn_num_5 = (Button) findViewById(R.id.btn_num_5);
        btn_num_6 = (Button) findViewById(R.id.btn_num_6);
        btn_suma = (Button) findViewById(R.id.btn_suma);
        btn_num_1 = (Button) findViewById(R.id.btn_num_1);
        btn_num_2 = (Button) findViewById(R.id.btn_num_2);
        btn_num_3 = (Button) findViewById(R.id.btn_num_3);
        btn_igual = (Button) findViewById(R.id.btn_igual);
        btn_num_0 = (Button) findViewById(R.id.btn_num_0);
        btn_punto = (Button) findViewById(R.id.btn_punto);
        //añadimos listener a los button's
        btn_clear.setOnClickListener(new btn_listener());
        btn_dividir.setOnClickListener(new btn_listener());
        btn_multi.setOnClickListener(new btn_listener());
        bnt_borar.setOnClickListener(new btn_listener());
        btn_num_7.setOnClickListener(new btn_listener());
        btn_num_8.setOnClickListener(new btn_listener());
        btn_num_9.setOnClickListener(new btn_listener());
        btn_resta.setOnClickListener(new btn_listener());
        btn_num_4.setOnClickListener(new btn_listener());
        btn_num_5.setOnClickListener(new btn_listener());
        btn_num_6.setOnClickListener(new btn_listener());
        btn_suma.setOnClickListener(new btn_listener());
        btn_num_1.setOnClickListener(new btn_listener());
        btn_num_2.setOnClickListener(new btn_listener());
        btn_num_3.setOnClickListener(new btn_listener());
        btn_igual.setOnClickListener(new btn_listener());
        btn_num_0.setOnClickListener(new btn_listener());
        btn_punto.setOnClickListener(new btn_listener());

    }

    //class listener para los btn's
    class btn_listener implements View.OnClickListener {
        boolean clicked_igual = false;

        @Override
        public void onClick(View view) {

            try {
                btn(view);
            } catch (Exception e) {

            }
        }

        public void btn(View v) {

            if (txt.equals("0 ")) {
                txt = "";
            }

            if (v == btn_clear) {
                num_1 = 0;
                txt = "0 ";
            }

            if (v == btn_dividir) {
                signo = '/';
                num_1 = Double.parseDouble(txt);
                txt = " ";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_multi) {
                signo = 'x';
                num_1 = Double.parseDouble(txt);
                txt = " ";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == bnt_borar) {

                if (txt.length() > 0) {
                    txt = txt.substring(0, txt.length() - 1);
                }
            }

            if (v == btn_num_7) {
                txt = txt + "7";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_8) {
                txt = txt + "8";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_9) {
                txt = txt + "9";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_resta) {
                signo = '-';
                num_1 = Double.parseDouble(txt);
                txt = " ";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_4) {
                txt = txt + "4";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_5) {
                txt = txt + "5";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_6) {
                txt = txt + "6";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_suma) {
                signo = '+';
                num_1 = Double.parseDouble(txt);
                txt = " ";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_1) {
                txt = txt + "1";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_2) {
                txt = txt + "2";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_num_3) {
                txt = txt + "3";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_igual) {
                if (cont_igual == 0) {

                    num_2 = Double.parseDouble(txt);
                    operaciones();
                    txt = Double.toString(num_result);
                    cont_igual++;
                }
            }

            if (v == btn_num_0) {
                txt = txt + "0";
                cont_igual = 0;
                cont_punto = 0;
            }

            if (v == btn_punto) {
                if (cont_punto == 0) {
                    txt = txt + ".";
                    cont_punto++;
                }
            }
            tv_numero.setText(txt);
        }

        public void operaciones() {

            switch (signo) {

                case '+':
                    num_result = num_1 + num_2;
                    break;
                case '-':
                    num_result = num_1 - num_2;
                    break;
                case 'x':
                    num_result = num_1 * num_2;
                    break;
                case '/':
                    num_result = num_1 / num_2;
                    break;
            }
        }
    }
}

