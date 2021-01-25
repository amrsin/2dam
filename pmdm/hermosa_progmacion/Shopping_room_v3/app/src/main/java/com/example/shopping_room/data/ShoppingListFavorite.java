package com.example.shopping_room.data;


import androidx.room.ColumnInfo;

public class ShoppingListFavorite {
    public String id;
    @ColumnInfo(name = "is_favorite")
    public boolean favorite;
    @ColumnInfo(name = "last_updated")
    public String lastUpdated;
}