package com.example.shopping_room.editshoppinglist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.shopping_room.data.entities.ShoppingList;
import com.example.shopping_room.data.ShoppingListRepository;

public class EditShoppingListViewModel extends AndroidViewModel {

    private final ShoppingListRepository mRepository;

    private final MutableLiveData<String> mShoppingListId = new MutableLiveData<>();

    private final LiveData<ShoppingList> mShoppingList;

    public EditShoppingListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ShoppingListRepository(application);
        mShoppingList = Transformations.switchMap(
                mShoppingListId,
                mRepository::getShoppingList
        );
    }

    public void start(String id){
        if(id.equals(mShoppingListId.getValue())){
            return;
        }
        mShoppingListId.setValue(id);
    }

    public LiveData<ShoppingList> getShoppingList() {
        return mShoppingList;
    }
}