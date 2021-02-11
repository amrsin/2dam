package com.example.gestion_matricula.Asignatura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gestion_matricula.Alumno.AlumnoForList;
import com.example.gestion_matricula.R;
import com.example.gestion_matricula.data.Alumno.AlumnoInsert;
import com.example.gestion_matricula.data.Asignatura.AsignaturaInsert;

public class Asignaturas extends AppCompatActivity implements DialogAsignatura.OnSimpleDialogListener {


    private AsignaturaViewModel mViewModel;
    private RecyclerView mList;
    private AsignaturaAdapter mAdapter;
    private String icon_identity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        getSupportActionBar().setTitle("Asignaturas");

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        setupList();

        setupFab();


    }
    //metodo para añadir lista de alumnos
    private void setupList() {
        mList = findViewById(R.id.list_asignaturas);
        mAdapter = new AsignaturaAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AsignaturaAdapter.ItemListener() {

            @Override
            public void onEditIconClicked(AsignaturaForList Asignatura) {

                icon_identity = "edit";
                DialogAsignatura d = new DialogAsignatura(Asignatura);
                d.show(getSupportFragmentManager(), "DialogAsignatura");

            }

            @Override
            public void onDeleteIconClicked(AsignaturaForList Asignatura) {

                int id = Asignatura.id;
                mViewModel.deleteAsignatura(Asignatura);
                Toast.makeText(getApplication(), "Eliminado " + id, Toast.LENGTH_SHORT).show();

            }
        });
        // Observar cambios de listas alumnos
        mViewModel.getAllAsignaturas().observe(this, mAdapter::setItems);


    }
    //listener para button flotante
    private void setupFab() {

        findViewById(R.id.floating_action_button_asignaturas)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        icon_identity = "add";
                        Asignatura_dialog();
                    }
                });
    }
    //obtener instancia del dialogo
    private void Asignatura_dialog() {

        new DialogAsignatura().show(getSupportFragmentManager(), "DialogAsignatura"); //instanciamos el dialogo

    }
    //metodo dialogo al hacer click guardar
    @Override
    public void onPossitiveButtonClick(String name_asignatura, int id, int num_students) {

        // Ignorar acción si hay 0 caracteres
        if (name_asignatura.isEmpty()) {
            return;
        }

        //si el icono pulsado es añadir
        if (icon_identity.equals("add")) {

            AsignaturaInsert a = new AsignaturaInsert(name_asignatura);
            mViewModel.insert(a);
            Toast.makeText(this, "Añadido " + name_asignatura, Toast.LENGTH_SHORT).show();

        }
        //si el icono pulsado es edit
        if (icon_identity.equals("edit")) {

            AsignaturaForList a = new AsignaturaForList();
            a.name = name_asignatura;
            a.id = id;
            a.num_students = num_students;
            mViewModel.updateAsignatura(a);
            Toast.makeText(this, "Actualizado " + a.id, Toast.LENGTH_SHORT).show();
        }
    }
}