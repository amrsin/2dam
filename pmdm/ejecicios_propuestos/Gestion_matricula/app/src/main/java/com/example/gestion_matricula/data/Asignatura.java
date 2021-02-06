package com.example.gestion_matricula.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//entity con el nombre asignatura, con sus correspondientes atributos
@Entity(tableName = "asignatura")
public class Asignatura {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final String Id;

    @NonNull
    @ColumnInfo(name = "name")
    private final String Name;

    @Nullable
    @ColumnInfo(name = "num_students")
    private final int num_students;

    public Asignatura(@NonNull String id, @NonNull String name) {
        Id = id;
        Name = name;
        this.num_students = 0;
    }

    @NonNull
    public String getId() {
        return Id;
    }

    @NonNull
    public String getName() {
        return Name;
    }

    @Nullable
    public int getNum_students() {
        return num_students;
    }
}