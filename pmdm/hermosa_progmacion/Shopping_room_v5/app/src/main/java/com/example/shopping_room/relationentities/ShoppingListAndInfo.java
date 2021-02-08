package com.example.shopping_room.relationentities;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.shopping_room.data.entities.Info;
import com.example.shopping_room.data.partialentities.ShoppingListForList;


public class ShoppingListAndInfo {
    @Embedded
    public ShoppingListForList shoppingList;

    @Relation(
            parentColumn = "id",
            entityColumn = "shopping_list_id"
    )
    public Info info;
}