package com.example.shopping_room.shoppinglists;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.example.shopping_room.data.ShoppingListFavorite;
import com.example.shopping_room.data.ShoppingListInsert;
import com.example.shopping_room.data.ShoppingListRepository;

public class ShoppingListViewModel extends AndroidViewModel {

    // Repositorio de listas de compras
    private final ShoppingListRepository mRepository;

    // Filtros observados
    private final MutableLiveData<List<String>> mCategories
            = new MutableLiveData<>(new ArrayList<>());

    // Listas de compras observadas
    private final LiveData<List<ShoppingListForList>> mShoppingLists;

    // Filtros
    private final List<String> mFilters = new ArrayList<>();

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ShoppingListRepository(application);

        // Obtener listas de compras por categorías
        mShoppingLists = Transformations.switchMap(
                mCategories,
                categories -> {
                    if (categories.isEmpty()) {
                        return mRepository.getShoppingLists();
                    } else {
                        return mRepository.getShoppingListsWithCategories(categories);
                    }
                }
        );
    }

    public void insert(ShoppingListInsert shoppingList) {
        mRepository.insert(shoppingList);
    }

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

    public void markFavorite(ShoppingListForList shoppingList) {
        ShoppingListFavorite favorite = new ShoppingListFavorite();
        favorite.id = shoppingList.id;
        favorite.favorite = !shoppingList.favorite;
        favorite.lastUpdated = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss",
                Locale.getDefault())
                .format(new Date());

        mRepository.markFavorite(favorite);
    }
}