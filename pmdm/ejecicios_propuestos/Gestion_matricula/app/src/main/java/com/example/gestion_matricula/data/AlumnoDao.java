package com.example.gestion_matricula.data;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.gestion_matricula.Alumno.AlumnoForList;
import com.example.gestion_matricula.Alumno.AlumnoDNI;

import java.util.List;

@Dao
public interface AlumnoDao {

    //Consulta para listar todos los alumnos
    @Query("SELECT * FROM alumno")
    LiveData<List<AlumnoForList>> getAll();
    //Consulta para insertar alumno
    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Alumno.class)
    void insert(AlumnoInsert Alumno);
    //Consulta para eliminar alumno
    @Delete(entity = Alumno.class)
    void deleteAlumno(AlumnoDNI id);
}
