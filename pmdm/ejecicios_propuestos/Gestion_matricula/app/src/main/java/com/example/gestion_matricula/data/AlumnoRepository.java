package com.example.gestion_matricula.data;


import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AlumnoRepository {

    private final LiveData<List<Alumno>> AlumnoLists;
    private final AlumnoDao alumnoDao;

    public AlumnoRepository(Context context) {
        MatriculaDatabase db = MatriculaDatabase.getInstance(context);
        alumnoDao = db.AlumnoDao();
        AlumnoLists = alumnoDao.getAll();
    }

    public LiveData<List<Alumno>> getAllAlumnos() {
        return AlumnoLists;
    }

    public void insert(Alumno alumno) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alumnoDao.insert(alumno)
        );
    }
}
