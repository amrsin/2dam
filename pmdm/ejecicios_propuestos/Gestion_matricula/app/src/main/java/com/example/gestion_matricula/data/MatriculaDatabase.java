package com.example.gestion_matricula.data;


import android.content.Context;
import android.text.style.AbsoluteSizeSpan;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.gestion_matricula.data.Alumno.Alumno;
import com.example.gestion_matricula.data.Alumno.AlumnoDao;
import com.example.gestion_matricula.data.Alumno.AlumnoInsert;
import com.example.gestion_matricula.data.Asignatura.Asignatura;
import com.example.gestion_matricula.data.Asignatura.AsignaturaDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Alumno.class, Asignatura.class}, version = 2, exportSchema = false)
public abstract  class MatriculaDatabase extends RoomDatabase {

    // Exposición de DAOs
    public abstract AlumnoDao AlumnoDao();
    public abstract AsignaturaDao AsignaturaDao();

    private static final String DATABASE_NAME = "Matricula-bd";

    private static MatriculaDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static MatriculaDatabase getInstance(final Context context) {

        if (INSTANCE == null) {
            synchronized (MatriculaDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), MatriculaDatabase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Prepoblar base de datos con callback
    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                //var
                AlumnoDao dao_alumno = INSTANCE.AlumnoDao();
                AsignaturaDao dao_asignatura = INSTANCE.AsignaturaDao();
                List<Asignatura> list_asignataras = new ArrayList<>();
                //insert de predefinido en tabla alumno
                AlumnoInsert a1 = new AlumnoInsert("12345", "Juan", "García");
                dao_alumno.insert(a1);
                //insert de predefinido en tabla asignatura
                Asignatura asig1 = new Asignatura("Acceso a datos");
                Asignatura asig2 = new Asignatura("Desarrollo de interfaces");
                Asignatura asig3 = new Asignatura("Programación de servicios y procesos");
                Asignatura asig4 = new Asignatura("Sistemas de gestión empresarial");
                Asignatura asig5 = new Asignatura("Empresa e iniciativa emprendedora");
                Asignatura asig6 = new Asignatura("Inglés");

                list_asignataras.add(asig1);
                list_asignataras.add(asig2);
                list_asignataras.add(asig3);
                list_asignataras.add(asig4);
                list_asignataras.add(asig5);
                list_asignataras.add(asig6);

                dao_asignatura.insertAsignaturas(list_asignataras);
            });
        }
    };
}