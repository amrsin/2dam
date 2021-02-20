package com.example.gestion_matricula.data.AlumnoWithAsignatura;

import androidx.annotation.NonNull;
import androidx.room.*;

import com.example.gestion_matricula.data.Alumno.Alumno;
import com.example.gestion_matricula.data.Asignatura.Asignatura;
//Entity para guardar las asignaturas de los alumnos
@Entity(tableName = "alumno_asignatura",
        primaryKeys = {"DNI", "id"},
        foreignKeys = {
            @ForeignKey(
                entity = Alumno.class,
                parentColumns = "DNI",
                childColumns = "DNI",
                onDelete = ForeignKey.CASCADE),
            @ForeignKey(
                entity = Asignatura.class,
                parentColumns = "id",
                childColumns = "id")
   }
)
public class AlumnoAsignaturaCrossRef {

    @NonNull
    String DNI;
    @NonNull
    int id;

    public AlumnoAsignaturaCrossRef(@NonNull String DNI, int id) {
        this.DNI = DNI;
        this.id = id;
    }
}
