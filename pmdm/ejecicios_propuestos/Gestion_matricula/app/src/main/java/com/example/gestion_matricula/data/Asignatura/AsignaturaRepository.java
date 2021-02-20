package com.example.gestion_matricula.data.Asignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.gestion_matricula.Alumno.AlumnoDNI;
import com.example.gestion_matricula.Asignatura.AsignaturaForList;
import com.example.gestion_matricula.Asignatura.AsignaturaId;
import com.example.gestion_matricula.data.Alumno.AlumnoDao;
import com.example.gestion_matricula.data.AlumnoWithAsignatura.AlumnoWithAsignatura;
import com.example.gestion_matricula.data.MatriculaDatabase;

import java.util.List;

public class AsignaturaRepository {

    //variables
    private final LiveData<List<AsignaturaForList>> AsignaturaLists;
    private final AsignaturaDao asignaturaDao;
    private final AlumnoDao alumnoDao;
    //constructor con los parametros
    public AsignaturaRepository(Context context) {
        MatriculaDatabase db = MatriculaDatabase.getInstance(context);
        asignaturaDao = db.AsignaturaDao();
        alumnoDao = db.AlumnoDao();
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

    //para actualizar num_students incrementando 1
    public void updatest_sum(int id ) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.up_numst_sum(id)
        );
    }

    //para actualizar num_students desincrementando 1
    public void updatest_res(int id ) {
        MatriculaDatabase.dbExecutor.execute(
                () -> asignaturaDao.up_numst_res(id)
        );
    }
}