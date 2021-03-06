package com.example.gestion_matricula.data.Alumno;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.gestion_matricula.Alumno.AlumnoForList;
import com.example.gestion_matricula.Alumno.AlumnoDNI;
import com.example.gestion_matricula.AlumnoWithAsignatura.alu_asig_insert;
import com.example.gestion_matricula.data.AlumnoWithAsignatura.AlumnoAsignaturaCrossRef;
import com.example.gestion_matricula.data.AlumnoWithAsignatura.AlumnoWithAsignatura;

import java.util.List;

@Dao
public interface AlumnoDao {

    //Consulta para listar todos los alumnos
    @Query("SELECT * FROM alumno ORDER BY surnames")
    LiveData<List<AlumnoForList>> getAll();
    //Consulta para insertar alumno
    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Alumno.class)
    void insert(AlumnoInsert Alumno);
    //Consulta para eliminar alumno
    @Delete(entity = Alumno.class)
    void deleteAlumno(AlumnoDNI id);
    //Consulta para actualizar alumno
    @Update(entity = Alumno.class)
    void updateAlumno(AlumnoForList Alumno);

}
