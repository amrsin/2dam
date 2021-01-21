package com.example.shopping_room.shoppinglists;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import com.example.shopping_room.data.ShoppingList;
import com.example.shopping_room.data.ShoppingListRepository;

public class ShoppingListViewModel extends AndroidViewModel {

    private final ShoppingListRepository mRepository;

    private final LiveData<List<ShoppingListForList>> mShoppingLists;

    // Filtros observados
    private final MutableLiveData<List<String>> mCategories
            = new MutableLiveData<>(new ArrayList<>());




    // Filtros
    private final List<String> mFilters = new ArrayList<>();


    public void addFilter(String category) {
        mFilters.add(category);
        mCategories.setValue(mFilters);
    }

    public void removeFilter(String category) {
        mFilters.remove(category);
        mCategories.setValue(mFilters);
    }


    public LiveData<List<ShoppingListForList>> getShoppingLists() {
        return mShoppingLists;
    }

    public void insert(ShoppingList shoppingList) {
        mRepository.insert(shoppingList);
    }
}
