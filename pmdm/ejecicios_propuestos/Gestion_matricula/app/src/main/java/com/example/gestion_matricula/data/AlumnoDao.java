package com.example.gestion_matricula.data;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface AlumnoDao {

    @Query("SELECT * FROM alumno")
    LiveData<List<Alumno>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Alumno alumno);
}
