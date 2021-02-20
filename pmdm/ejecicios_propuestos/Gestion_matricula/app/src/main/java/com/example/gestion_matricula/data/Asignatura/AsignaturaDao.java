package com.example.gestion_matricula.data.Asignatura;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gestion_matricula.Asignatura.AsignaturaForList;
import com.example.gestion_matricula.Asignatura.AsignaturaId;

import java.util.List;

@Dao
public interface AsignaturaDao {

    //Consulta para listar todos las asignaturas
    @Query("SELECT * FROM asignatura")
    LiveData<List<AsignaturaForList>> getAll();
    //Consulta para insertar asignatura
    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Asignatura.class)
    void insert(AsignaturaInsert Asignatura);
    //Consulta para insertar varias asignaturas
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAsignaturas(List<Asignatura> asignaturas);
    //Consulta para eliminar asignatura
    @Delete(entity = Asignatura.class)
    void deleteAsignatura(AsignaturaId id);
    //Consulta para actualizar asignatura
    @Update(entity = Asignatura.class)
    void updateAsignatura(AsignaturaForList Asignatura);
    //para sumar numero estudiantres atras asignar un alumno a asignatura
    @Query("UPDATE Asignatura SET num_students = num_students + 1 WHERE id = :id")
    void up_numst_sum(int id);
    //para restar numero estudiantres atras asignar un alumno a asignatura
    @Query("UPDATE Asignatura SET num_students = num_students - 1 WHERE id = :id")
    void up_numst_res(int id);
}

