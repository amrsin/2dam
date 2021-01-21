package com.example.shopping_room.shoppinglists;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_room.data.ShoppingList;

import java.util.List;

public class ShoppingListAdapter
        extends RecyclerView.Adapter<ShoppingListViewHolder> {

    private List<ShoppingList> mShoppingLists;

    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ShoppingListViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListViewHolder holder, int position) {
        ShoppingList item = mShoppingLists.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mShoppingLists == null ? 0 : mShoppingLists.size();
    }

    public void setItems(List<ShoppingList> items) {
        mShoppingLists = items;
        notifyDataSetChanged();
    }
}
