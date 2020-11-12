package com.example.ej_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    //var
    private ImageButton imgBtn_linearLayout;
    private ImageButton imgBtn_Table_Layout;
    private ImageButton imgBtn_ConstraintLayout;
    private ImageButton imgBtn_GridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //identificamos los elementos con sus correspondiente id
        imgBtn_linearLayout = (ImageButton)findViewById(R.id.imgBtn_linearLayout);
        imgBtn_Table_Layout = (ImageButton)findViewById(R.id.imgBtn_TableLayout);
        imgBtn_ConstraintLayout = (ImageButton)findViewById(R.id.imgBtn_ConstraintLayout);
        imgBtn_GridLayout = (ImageButton)findViewById(R.id.imgBtn_GridLayout);
        //añadimos listener a cada imgbtn llamando a clase img_btn_listener
        imgBtn_linearLayout.setOnClickListener(new img_btn_Listener());
        imgBtn_Table_Layout.setOnClickListener(new img_btn_Listener());
        imgBtn_ConstraintLayout.setOnClickListener(new img_btn_Listener());
        imgBtn_GridLayout.setOnClickListener(new img_btn_Listener());
    }
    //listener de imgbTN
    class img_btn_Listener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int activity = 0;
            Bundle bundle = new Bundle();
            //Segun quien llame a esta clase se asigna la variable activity con su identificador de activity y lo panemos en el bundel
            if (view == imgBtn_linearLayout ) {

                activity = R.layout.linearlayout;
                bundle.putInt("activity", activity);

            }

            if (view == imgBtn_Table_Layout) {

                activity = R.layout.tablelayout;
                bundle.putInt("activity", activity);


            }

            if (view == imgBtn_ConstraintLayout) {

                activity = R.layout.constraintlayout;
                bundle.putInt("activity", activity);

            }

            if (view == imgBtn_GridLayout) {

                activity = R.layout.gridlayout;
                bundle.putInt("activity", activity);

            }
            //intent para segundoActivity y añadimos bundel al intent
            Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);// iniciamos el segundoActivity

        }
    }
}