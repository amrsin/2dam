package com.example.gestion_matricula.data.Alumno;


import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.gestion_matricula.Alumno.AlumnoForList;
import com.example.gestion_matricula.Alumno.AlumnoDNI;
import com.example.gestion_matricula.data.MatriculaDatabase;

import java.util.List;

public class AlumnoRepository {
    //variables
    private final LiveData<List<AlumnoForList>> AlumnoLists;
    private final AlumnoDao alumnoDao;
    //constructor con los parametros
    public AlumnoRepository(Context context) {
        MatriculaDatabase db = MatriculaDatabase.getInstance(context);
        alumnoDao = db.AlumnoDao();
        AlumnoLists = alumnoDao.getAll();
    }
    //para obtener lista alumnos de db
    public LiveData<List<AlumnoForList>> getAllAlumnos() {
        return AlumnoLists;
    }
    //para insertar alumno a db
    public void insert(AlumnoInsert alumno) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alumnoDao.insert(alumno)
        );
    }

    public void updateAlumno(AlumnoForList Alumno) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alumnoDao.updateAlumno(Alumno)
        );
    }

    public void deleteAlumno(AlumnoDNI dni) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alumnoDao.deleteAlumno(dni)
        );
    }
}