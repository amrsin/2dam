package com.example.gestion_matricula.Alumno;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.example.gestion_matricula.data.Alumno;
import com.example.gestion_matricula.data.AlumnoRepository;

public class AlumnoViewModel extends AndroidViewModel {

    private final AlumnoRepository mRepository;

    private final LiveData<List<Alumno>> alumnos;

    public AlumnoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AlumnoRepository(application);
        alumnos = mRepository.getAllAlumnos();
    }

    public LiveData<List<Alumno>> getAllAlumnos() {
        return alumnos;
    }

    public void insert(Alumno alumno) {
        mRepository.insert(alumno);
    }
}

