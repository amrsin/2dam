package com.example.shopping_room.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.shopping_room.data.entities.Info;
import com.example.shopping_room.data.entities.ShoppingList;
import com.example.shopping_room.data.partialentities.ShoppingListId;
import com.example.shopping_room.data.partialentities.ShoppingListInsert;
import com.example.shopping_room.relationentities.ShoppingListAndInfo;

import java.util.List;

@Dao
public abstract class ShoppingListDao {
    @Transaction
    @Query("SELECT id, name, is_favorite FROM shopping_list")
    abstract LiveData<List<ShoppingListAndInfo>> getAll();

    @Query("SELECT * FROM shopping_list WHERE id = :id LIMIT 1")
    abstract LiveData<ShoppingList> getShoppingList(String id);

    @Transaction
    @Query("SELECT id, name, is_favorite FROM shopping_list WHERE category IN(:categories)")
    abstract LiveData<List<ShoppingListAndInfo>> getShoppingListsByCategories(List<String> categories);

    @Transaction
    public void insertWithInfo(ShoppingListInsert shoppingList, Info info) {
        insertShoppingList(shoppingList);
        insertInfo(info);
    }

    @Transaction
    public void insertAllWithInfos(List<ShoppingListInsert> shoppingLists, List<Info> infos) {
        insertAll(shoppingLists);
        insertAllInfos(infos);
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertShoppingList(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    abstract void insertShoppingList(ShoppingListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    abstract void insertAll(List<ShoppingListInsert> lists);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertInfo(Info info);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertAllInfos(List<Info> infos);

    @Transaction
    public void markFavorite(String id) {
        updateShoppingListFavorite(id);
        updateInfoLastUpdated(id);
    }

    @Query("UPDATE shopping_list SET is_favorite= NOT is_favorite WHERE id = :id")
    protected abstract void updateShoppingListFavorite(String id);

    @Query("UPDATE info SET last_updated = CURRENT_TIMESTAMP WHERE shopping_list_id=:shoppingListId")
    protected abstract void updateInfoLastUpdated(String shoppingListId);

    @Delete(entity = ShoppingList.class)
    abstract void deleteShoppingList(ShoppingListId id);

    @Query("DELETE FROM shopping_list")
    abstract void deleteAll();
}