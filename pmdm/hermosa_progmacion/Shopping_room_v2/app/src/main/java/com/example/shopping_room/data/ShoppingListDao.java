package com.example.shopping_room.data;

import androidx.lifecycle.LiveData;
import androidx.room.*;


import com.example.shopping_room.data.ShoppingList;
import com.example.shopping_room.shoppinglists.ShoppingListForList;

import java.util.List;

@Dao

public interface ShoppingListDao {

    @Query("SELECT id, name FROM shopping_list")
    LiveData<List<ShoppingListForList>> getAll();

    @Query("SELECT * FROM shopping_list WHERE id = :id LIMIT 1")
    LiveData<ShoppingList> getShoppingList(String id);

    @Query("SELECT id, name FROM shopping_list WHERE category IN(:categories)")
    LiveData<List<ShoppingListForList>> getShoppingListsByCategories(List<String> categories);


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void partialInsert(ShoppingListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void insertShoppingLists(List<ShoppingListInsert> lists);



}

