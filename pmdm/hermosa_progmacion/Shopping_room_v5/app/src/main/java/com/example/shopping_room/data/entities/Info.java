package com.example.shopping_room.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "info",
        foreignKeys = @ForeignKey(
                entity = ShoppingList.class,
                parentColumns = "id",
                childColumns = "shopping_list_id",
                onDelete = ForeignKey.CASCADE)

)
public class Info {
    @NonNull
    @PrimaryKey
    public String id;

    @NonNull
    @ColumnInfo(name = "shopping_list_id")
    public String shoppingListId;

    @ColumnInfo(name = "created_date", defaultValue = "CURRENT_TIMESTAMP")
    public String createdDate;

    @ColumnInfo(name = "last_updated", defaultValue = "CURRENT_TIMESTAMP")
    public String lastUpdated;

    public Info(@NonNull String id, @NonNull String shoppingListId,
                String createdDate, String lastUpdated) {
        this.id = id;
        this.shoppingListId = shoppingListId;
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
    }

}
