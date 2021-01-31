package com.example.gestion_matricula.data_asignatura;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
    private final String num_students;

    public Asignatura(@NonNull String id, @NonNull String name, @Nullable String num_students) {
        Id = id;
        Name = name;
        this.num_students = num_students;
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
    public String getNum_students() {
        return num_students;
    }
}