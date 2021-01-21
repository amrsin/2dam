package com.example.shopping_room.data;

import androidx.lifecycle.LiveData;
import androidx.room.*;


import com.example.shopping_room.data.ShoppingList;

import java.util.List;

@Dao

public interface ShoppingListDao {

    @Query("SELECT * FROM shopping_list")
    LiveData<List<ShoppingList>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);
}
