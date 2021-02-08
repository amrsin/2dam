package com.example.shopping_room.data;

import android.content.Context;
import androidx.lifecycle.LiveData;

import com.example.shopping_room.data.entities.Info;
import com.example.shopping_room.data.entities.ShoppingList;
import com.example.shopping_room.data.partialentities.ShoppingListId;
import com.example.shopping_room.data.partialentities.ShoppingListInsert;
import com.example.shopping_room.relationentities.ShoppingListAndInfo;

import java.util.List;

public class ShoppingListRepository {
    private final ShoppingListDao mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
    }

    public LiveData<List<ShoppingListAndInfo>> getShoppingLists() {
        return mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingListAndInfo>> getShoppingListsWithCategories(List<String> categories) {
        return mShoppingListDao.getShoppingListsByCategories(categories);
    }

    public LiveData<ShoppingList> getShoppingList(String id) {
        return mShoppingListDao.getShoppingList(id);
    }

    public void insert(ShoppingListInsert shoppingList, Info info) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.insertWithInfo(shoppingList, info)
        );
    }

    public void markFavorite(String shoppingListId) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.markFavorite(shoppingListId)
        );
    }

    public void deleteShoppingList(ShoppingListId id) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.deleteShoppingList(id)
        );
    }

    public void deleteAll() {
        ShoppingListDatabase.dbExecutor.execute(
                mShoppingListDao::deleteAll
        );
    }
}