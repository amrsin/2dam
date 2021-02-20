package com.example.gestion_matricula.data.AlumnoWithAsignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.gestion_matricula.AlumnoWithAsignatura.alu_asig_insert;
import com.example.gestion_matricula.Asignatura.AsignaturaForList;
import com.example.gestion_matricula.Asignatura.AsignaturaId;
import com.example.gestion_matricula.data.MatriculaDatabase;

import java.util.List;

public class Alu_asigRepository {
    //variables
    private final Alu_asigDAO alu_asigDAO;
    List<String> list_alu_in;
    List<String> list_all_asig;

    //constructor con los parametros
    public Alu_asigRepository(Context context) {
        MatriculaDatabase db = MatriculaDatabase.getInstance(context);
        alu_asigDAO = db.alu_asigDAO();
        list_all_asig = alu_asigDAO.all_asig();
    }

    //para obtener listado asignaturas de alumno
    public LiveData<AlumnoWithAsignatura> get_Alumno_with_asig(String DNI) {

        LiveData<AlumnoWithAsignatura> list;
        list = alu_asigDAO.get_Alumno_with_asig(DNI);

        return list;
    }

    //para asignar asignatura a alumno
    public void insertAsignatura_alu(alu_asig_insert alu_asig_insert) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alu_asigDAO.insertAlumnoAsignatura(alu_asig_insert)
        );
    }

    //para eliminar asignatura a alumno
    public void delete_alumno_asig(int id, String dni) {
        MatriculaDatabase.dbExecutor.execute(
                () -> alu_asigDAO.delete_alumno_asig(id, dni)
        );
    }

    //metodo para tener listado nombre asignaturas en las que esta el alumno en list String
    public List<String> list_alu_in(String DNI) {

        list_alu_in = alu_asigDAO.list_alu_in(DNI);

        return list_alu_in;
    }

    //metodo para tener listado nombre asignaturas todas las asignaturas en list String
    public List<String> list_all_asig() {

        return list_all_asig;
    }

    //metodo para obtener id asignastura
    public int id_asignatura(String name) {

        int id = alu_asigDAO.id_asignatura(name);

        return id;
    }
}