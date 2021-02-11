package com.example.gestion_matricula.data.Asignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.gestion_matricula.Asignatura.AsignaturaForList;
import com.example.gestion_matricula.Asignatura.AsignaturaId;
import com.example.gestion_matricula.data.MatriculaDatabase;

import java.util.List;

public class AsignaturaRepository {

    //variables
    private final LiveData<List<AsignaturaForList>> AsignaturaLists;
    private final AsignaturaDao asignaturaDao;
    //constructor con los parametros
    public AsignaturaRepository(Context context) {
        MatriculaDatabase db = MatriculaDatabase.getInstance(context);
        asignaturaDao = db.AsignaturaDao();
        AsignaturaLists = asignaturaDao.getAll();
    }
    //para obtener lista asignaturas de db
    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return AsignaturaLists;
    }
    //para insertar asignatura a db
    public void insert(AsignaturaInsert asignatura) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.insert(asignatura)
        );
    }
    //para actualizar info de asignatura en bd
    public void updateAsignatura(AsignaturaForList Asignatura) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.updateAsignatura(Asignatura)
        );
    }
    //para eliminar
    public void deleteAsignatura(AsignaturaId id) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.deleteAsignatura(id)
        );
    }
}