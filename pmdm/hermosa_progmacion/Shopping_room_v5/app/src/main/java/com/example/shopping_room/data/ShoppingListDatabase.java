package com.example.shopping_room.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.shopping_room.Utils;
import com.example.shopping_room.data.entities.Info;
import com.example.shopping_room.data.entities.ShoppingList;
import com.example.shopping_room.data.partialentities.ShoppingListInsert;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {ShoppingList.class, Info.class}, version = 5, exportSchema = false)
public abstract class ShoppingListDatabase extends RoomDatabase {

    // Exposición de DAOs
    public abstract ShoppingListDao shoppingListDao();

    private static final String DATABASE_NAME = "shopping-list-db";

    private static ShoppingListDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static ShoppingListDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ShoppingListDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), ShoppingListDatabase.class,
                            DATABASE_NAME)
                            .addCallback(mRoomCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Prepoblar base de datos con callback
    private static final RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                ShoppingListDao dao = INSTANCE.shoppingListDao();

                List<ShoppingListInsert> lists = new ArrayList<>();
                List<Info> infos = new ArrayList<>();

                for (int i = 0; i < 5; i++) {

                    // Crear lista de compras
                    ShoppingListInsert shoppingList = new ShoppingListInsert(
                            String.valueOf((i + 1)),
                            "Lista " + (i + 1)
                    );

                    // Crear info
                    String date = Utils.getCurrentDate();
                    Info info = new Info(String.valueOf((i+1)),
                            shoppingList.id, date, date);

                    lists.add(shoppingList);
                    infos.add(info);
                }
                 dao.insertAllWithInfos(lists, infos);
            });
        }
    };
}