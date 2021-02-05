package com.example.gestion_matricula.data;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Alumno.class}, version = 1, exportSchema = false)
public abstract  class MatriculaDatabase extends RoomDatabase {

    // Exposición de DAOs
    public abstract AlumnoDao AlumnoDao();

    private static final String DATABASE_NAME = "Matricula-db";

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
                AlumnoDao dao = INSTANCE.AlumnoDao();

                Alumno a1 = new Alumno("12345", "Juan", "García");

                dao.insert(a1);
            });
        }
    };
}