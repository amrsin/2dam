package com.example.gestion_matricula.Asignatura;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gestion_matricula.data.Asignatura.AsignaturaInsert;
import com.example.gestion_matricula.data.Asignatura.AsignaturaRepository;

import java.util.List;

public class AsignaturaViewModel extends AndroidViewModel {

    //varibales
    private final AsignaturaRepository mRepository;
    private final LiveData<List<AsignaturaForList>> asignaturas;
    //constructor con los parametros necesarios
    public AsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AsignaturaRepository(application);
        asignaturas = mRepository.getAllAsignaturas();
    }
    //para obtener lista asignaturas
    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return asignaturas;
    }
    //para insertar asignatura llamando al metodo insert de Repository
    public void insert(AsignaturaInsert asignatura) {
        mRepository.insert(asignatura);
    }
    //para actualizar asignatura lamando al metodo updateAsignatura de Repository
    public void updateAsignatura(AsignaturaForList Asignatura) {
        mRepository.updateAsignatura(Asignatura);
    }
    //para eliminar asignatura llamando al metodo deleteAsignatura de Repository
    public void deleteAsignatura(AsignaturaForList Asignatura) {
        AsignaturaId id = new AsignaturaId(Asignatura.id);
        mRepository.deleteAsignatura(id);
    }
}