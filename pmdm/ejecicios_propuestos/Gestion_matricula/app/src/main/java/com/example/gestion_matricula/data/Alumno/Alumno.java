package com.example.gestion_matricula.data.Alumno;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//entity con el nombre alumno, con sus correspondientes atributos
@Entity(tableName = "alumno")
public class Alumno {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "DNI")
    private final String DNI;

    @NonNull
    @ColumnInfo(name = "name")
    private final String name;

    @Nullable
    @ColumnInfo(name = "surnames")
    private final String surnames;

    public Alumno(@NonNull String DNI, @NonNull String name, @NonNull String surnames) {
        this.DNI = DNI;
        this.name = name;
        this.surnames = surnames;
    }

    @NonNull
    public String getDNI() {
        return DNI;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Nullable
    public String getSurnames() {
        return surnames;
    }
}