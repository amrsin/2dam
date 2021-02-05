package com.example.gestion_matricula.Alumno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestion_matricula.R;
import com.example.gestion_matricula.data.Alumno;

public class Alumnos extends AppCompatActivity implements DialogAlumno.OnSimpleDialogListener {

    private AlumnoViewModel mViewModel;
    private RecyclerView mList;
    private AlumnoAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        getSupportActionBar().setTitle("Alumnos");
        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AlumnoViewModel.class);

        setupList();

        setupFab();


    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AlumnoAdapter();
        mList.setAdapter(mAdapter);
        mViewModel.getAllAlumnos().observe(this, mAdapter::setItems);
    }

    private void setupFab() {
        findViewById(R.id.floating_action_button)
                .setOnClickListener(view -> addNewAlumno());
    }

    private void addNewAlumno() {

        new DialogAlumno().show(getSupportFragmentManager(), "DialogAlumno"); //instanciamos el dialogo

    }


    @Override
    public void onPossitiveButtonClick(String DNI, String name, String surnames) {

        // Ignorar acción si hay 0 caracteres
        if (name.isEmpty() || DNI.isEmpty() || surnames.isEmpty()) {
            return;
        }

        // Crear entidad y guardarla
        Alumno a = new Alumno(DNI, name, surnames);
        mViewModel.insert(a);


    }
}
