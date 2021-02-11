package com.example.gestion_matricula.data.Asignatura;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//entity con el nombre asignatura, con sus correspondientes atributos
@Entity(tableName = "asignatura")
public class Asignatura {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private final String name;

    @NonNull
    @ColumnInfo(name = "num_students")
    private int num_students;

    public Asignatura(@NonNull String name) {

        this.name = name;
        num_students = 0;
    }


    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public int getNum_students() {
        return num_students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_students(int num_students) {
        this.num_students = num_students;
    }
}