package com.example.gestion_matricula.data.AlumnoWithAsignatura;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.gestion_matricula.Alumno.AlumnoDNI;
import com.example.gestion_matricula.AlumnoWithAsignatura.alu_asig_insert;
import com.example.gestion_matricula.data.Alumno.Alumno;

import java.util.List;

@Dao
public interface Alu_asigDAO {

    //Listar asignaturas de alumno
    @Transaction
    @Query("SELECT * FROM alumno WHERE DNI = :DNI")
    LiveData<AlumnoWithAsignatura> get_Alumno_with_asig(String DNI);

    //Consulta para insertar asignatura a alumno
    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = AlumnoAsignaturaCrossRef.class)
    void insertAlumnoAsignatura(alu_asig_insert alu_asi);

    //Para eliminar asignatura asociada a alumno
    @Query("Delete FROM  alumno_asignatura WHERE DNI =:dni AND id = :id")
    void delete_alumno_asig(int id, String dni);

    //para obtener asignaturas en las que esta el alumno en lista String
    @Query("SELECT asignatura.name FROM asignatura " +
            "LEFT JOIN alumno_asignatura " +
            "ON asignatura.id = alumno_asignatura.id " +
            "WHERE alumno_asignatura.DNI = :dni"
    )
    List<String> list_alu_in(String dni);

    //para tener listado nombre asignaturas todas las asignaturas en list String
    @Query("SELECT asignatura.name FROM asignatura")
    List<String> all_asig();

    //metodo para obtener id asignastura

    @Query("SELECT asignatura.id FROM asignatura" +
            " WHERE name =:name")
    int id_asignatura(String name);
}