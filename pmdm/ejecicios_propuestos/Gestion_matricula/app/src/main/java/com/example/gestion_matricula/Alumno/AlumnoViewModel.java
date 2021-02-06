package com.example.gestion_matricula.Alumno;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.gestion_matricula.data.Alumno;
import com.example.gestion_matricula.data.AlumnoInsert;
import com.example.gestion_matricula.data.AlumnoRepository;

public class AlumnoViewModel extends AndroidViewModel {

    //varibales
    private final AlumnoRepository mRepository;
    private final LiveData<List<AlumnoForList>> alumnos;
    //constructor con los parametros necesarios
    public AlumnoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AlumnoRepository(application);
        alumnos = mRepository.getAllAlumnos();
    }
    //para obtener lista alumnos
    public LiveData<List<AlumnoForList>> getAllAlumnos() {
        return alumnos;
    }
    //para insertar alumno llamando al metodo insert de Repository
    public void insert(AlumnoInsert alumno) {
        mRepository.insert(alumno);
    }
    //para eliminar alumno
    public void deleteAlumno(AlumnoForList Alumno) {
        AlumnoDNI dni = new AlumnoDNI(Alumno.DNI);
        mRepository.deleteAlumno(dni);
    }
}

