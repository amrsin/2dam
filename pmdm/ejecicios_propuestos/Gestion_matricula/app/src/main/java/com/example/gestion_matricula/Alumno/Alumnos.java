package com.example.gestion_matricula.Alumno;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gestion_matricula.R;
import com.example.gestion_matricula.data.Alumno.AlumnoInsert;

public class Alumnos extends AppCompatActivity implements DialogAlumno.OnSimpleDialogListener {

    private AlumnoViewModel mViewModel;
    private RecyclerView mList;
    private AlumnoAdapter mAdapter;
    private String icon_identity;


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
    //metodo para añadir lista de alumnos
    private void setupList() {
        mList = findViewById(R.id.list_alumnos);
        mAdapter = new AlumnoAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AlumnoAdapter.ItemListener() {

            @Override
            public void onEditIconClicked(AlumnoForList Alumno) {

                icon_identity = "edit";
                DialogAlumno d = new DialogAlumno(Alumno);
                d.show(getSupportFragmentManager(), "DialogAlumno");

            }

            @Override
            public void onDeleteIconClicked(AlumnoForList Alumno) {

                String dni = Alumno.DNI;
                mViewModel.deleteAlumno(Alumno);
                Toast.makeText(getApplication(), "Eliminado " + dni, Toast.LENGTH_SHORT).show();

            }
        });
        // Observar cambios de listas alumnos
        mViewModel.getAllAlumnos().observe(this, mAdapter::setItems);


    }
    //listener para button flotante
    private void setupFab() {

        findViewById(R.id.floating_action_button_alumonos)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        icon_identity = "add";
                        Alumno_dialog();
                    }
                });
    }
    //obtener instancia del dialogo
    private void Alumno_dialog() {

        new DialogAlumno().show(getSupportFragmentManager(), "DialogAlumno"); //instanciamos el dialogo

    }
    //metodo dialogo al hacer click guardar
    @Override
    public void onPossitiveButtonClick(String DNI, String name, String surnames) {

        // Ignorar acción si hay 0 caracteres
        if (name.isEmpty() || DNI.isEmpty() || surnames.isEmpty()) {
            return;
        }

        //si el icono pulsado es añadir
        if (icon_identity.equals("add")) {

            AlumnoInsert a = new AlumnoInsert(DNI, name, surnames);
            mViewModel.insert(a);
            Toast.makeText(this, "Añadido " + DNI, Toast.LENGTH_SHORT).show();

        }
        //si el icono pulsado es edit
        if (icon_identity.equals("edit")) {

            AlumnoForList a = new AlumnoForList();
            a.DNI = DNI;
            a.name = name;
            a.surnames = surnames;
            mViewModel.updateAlumno(a);
            Toast.makeText(this, "Actualizado " + DNI, Toast.LENGTH_SHORT).show();

        }
    }
}