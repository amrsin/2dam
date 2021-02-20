package com.example.gestion_matricula.AlumnoWithAsignatura;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.gestion_matricula.Asignatura.AsignaturaViewModel;
import com.example.gestion_matricula.Asignatura.DialogAsignatura;
import com.example.gestion_matricula.R;
import com.example.gestion_matricula.data.Asignatura.Asignatura;

import java.util.List;
import java.util.function.Consumer;

public class MainAlumno_asig extends AppCompatActivity implements DialogAlumno_Asignatura.OnSimpleDialogListener {
    //var
    private AlumnoAsignaturaViewModel mViewModel;
    private AsignaturaViewModel viewModel_asignatura;
    private RecyclerView mList;
    private AlumnoWithAsignaturaAdapter mAdapter;
    String dni;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alumno_asig);


        //bundle para recoger String de MainActivity
        Bundle bunde_recoge = getIntent().getExtras();
        dni = bunde_recoge.getString("dni");
        name = bunde_recoge.getString("name");

        getSupportActionBar().setTitle("Asignaturas de " + name + "(" + dni + ")");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AlumnoAsignaturaViewModel.class);

        viewModel_asignatura = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        mViewModel.start(dni);
        setupList();
        subscribeToUi();
        setupFab();

    }

    //metodo para añadir lista de alumnos
    private void setupList() {
        mList = findViewById(R.id.list_alumno_asignaturas);
        mAdapter = new AlumnoWithAsignaturaAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AlumnoWithAsignaturaAdapter.ItemListener() {


            @Override
            public void onDeleteIconClicked(Asignatura Asignatura) {

                mViewModel.delete_alumno_asig(Asignatura.getId(), dni);
                viewModel_asignatura.updatest_res(Asignatura.getId());
                Toast.makeText(MainAlumno_asig.this, "Eliminado asignatura con cod " + Asignatura.getId() + " a " + name, Toast.LENGTH_SHORT).show();
            }

        });
    }

    // Observar cambios
    private void subscribeToUi() {
        mViewModel.get_Alumno_with_asig().observe(this,
                alumno -> {
                    mAdapter.setItems(alumno.asignaturas);
                }
        );
    }

    //listener para button flotante
    private void setupFab() {

        findViewById(R.id.floating_action_button_alumno_asignaturas)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Alumno_Asignatura_dialog();
                    }
                });
    }

    //obtener instancia del dialogo
    private void Alumno_Asignatura_dialog() {

        new DialogAlumno_Asignatura(dni,name).show(getSupportFragmentManager(), "DialogAlumnoAsignatura"); //instanciamos el dialogo

    }
    //metodo intefaz
    @Override
    public void onPossitiveButtonClick(int id_asignatura) {

        alu_asig_insert a = new alu_asig_insert(dni, id_asignatura);
        mViewModel.insertAsignatura_alu(a);
        viewModel_asignatura.updatest_sum(id_asignatura);
        Toast.makeText(MainAlumno_asig.this, "Asignado asignatura con cod " + id_asignatura + " a " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
