package com.example.gestion_matricula.data.AlumnoWithAsignatura;

import androidx.room.*;

import com.example.gestion_matricula.data.Alumno.Alumno;
import com.example.gestion_matricula.data.Asignatura.Asignatura;

import java.util.List;

public class AlumnoWithAsignatura {

    @Embedded
    public Alumno alumno;

    @Relation(
        parentColumn = "DNI",
        entityColumn = "id",
        associateBy = @Junction(AlumnoAsignaturaCrossRef.class)
)
public List<Asignatura> asignaturas;

}
