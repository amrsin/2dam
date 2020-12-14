package com.example.crm_leads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LeadsFragment leadsFragment = (LeadsFragment)
                getSupportFragmentManager().findFragmentById(R.id.leads_container);

        //si leadsFragment esta a null cargamos la instancia.
        if (leadsFragment == null) {

            leadsFragment = LeadsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.leads_container , leadsFragment)
                    .commit();
        }
    }
}