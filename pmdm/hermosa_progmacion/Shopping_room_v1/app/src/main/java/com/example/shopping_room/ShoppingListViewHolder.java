package com.example.shopping_room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingListViewHolder extends RecyclerView.ViewHolder {

    private final TextView mNameText;


    public ShoppingListViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameText = itemView.findViewById(R.id.name);

    }

    public void bind(ShoppingList item) {
        mNameText.setText(item.getName());
    }

    public static ShoppingListViewHolder create(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shopping_list_item, parent, false);
        return new ShoppingListViewHolder(v);
    }
}
