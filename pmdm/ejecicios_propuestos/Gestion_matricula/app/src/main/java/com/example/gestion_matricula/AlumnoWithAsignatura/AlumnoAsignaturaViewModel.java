package com.example.gestion_matricula.AlumnoWithAsignatura;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.gestion_matricula.Asignatura.AsignaturaForList;
import com.example.gestion_matricula.Asignatura.AsignaturaId;
import com.example.gestion_matricula.data.AlumnoWithAsignatura.Alu_asigRepository;
import com.example.gestion_matricula.data.AlumnoWithAsignatura.AlumnoWithAsignatura;
import com.example.gestion_matricula.data.Asignatura.AsignaturaInsert;
import com.example.gestion_matricula.data.Asignatura.AsignaturaRepository;
import com.example.gestion_matricula.data.MatriculaDatabase;

import java.util.List;

public class AlumnoAsignaturaViewModel extends AndroidViewModel {

    //varibales
    private final Alu_asigRepository mRepository;
    private final MutableLiveData<String> dni = new MutableLiveData<>();
    private final LiveData<AlumnoWithAsignatura> aList;
    List<String> list_alu_in;
    List<String> list_all_asig;

    //constructor con los parametros necesarios
    public AlumnoAsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Alu_asigRepository(application);
        aList = Transformations.switchMap(
                dni,
                mRepository::get_Alumno_with_asig
        );
        list_all_asig = mRepository.list_all_asig();
    }

    //para establecer dni
    public void start(String dni_alu) {
        if (dni_alu.equals(dni.getValue())) {
            return;
        }
        dni.setValue(dni_alu);
    }

    //para listar asignaturas de alumno
    public LiveData<AlumnoWithAsignatura> get_Alumno_with_asig() {
        return aList;
    }

    //para asignar asignatura a alumno
    public void insertAsignatura_alu(alu_asig_insert alu_asig_insert) {

        mRepository.insertAsignatura_alu(alu_asig_insert);
    }

    //para eliminar asignatura de alumno
    public void delete_alumno_asig(int id, String dni) {

        mRepository.delete_alumno_asig(id, dni);
    }

    //metodo para tener listado nombre asignaturas en las que esta el alumno en list String
    public List<String> list_alu_in(String DNI) {

        list_alu_in = mRepository.list_alu_in(DNI);
        return list_alu_in;
    }

    //metodo para tener listado nombre asignaturas todas las asignaturas en list String
    public List<String> list_all_asig() {
        return list_all_asig;
    }

    //metodo para obtener id asignastura
    public int id_asignatura(String name) {

        int id = mRepository.id_asignatura(name);

        return id;
    }
}