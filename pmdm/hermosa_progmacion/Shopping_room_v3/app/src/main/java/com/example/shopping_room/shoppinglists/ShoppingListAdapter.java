package com.example.shopping_room.shoppinglists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping_room.R;
import com.example.shopping_room.data.ShoppingList;

import java.util.List;

public class ShoppingListAdapter
        extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {

    private List<ShoppingListForList> mShoppingLists;
    private ItemListener mItemListener;

    @NonNull
    @Override
    public ShoppingListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShoppingListViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.shopping_list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingListViewHolder holder, int position) {
        ShoppingListForList item = mShoppingLists.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mShoppingLists == null ? 0 : mShoppingLists.size();
    }

    public void setItems(List<ShoppingListForList> items) {
        mShoppingLists = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }


    interface ItemListener {
        void onClick(ShoppingListForList shoppingList);

        void onFavoriteIconClicked(ShoppingListForList shoppingList);
    }

    public class ShoppingListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNameText;
        private final CheckBox mFavoriteButton;

        public ShoppingListViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameText = itemView.findViewById(R.id.name);
            mFavoriteButton = itemView.findViewById(R.id.favorite_button);
            // Setear eventos
            mFavoriteButton.setOnClickListener(this::manageEvents);
            itemView.setOnClickListener(this::manageEvents);

        }

        private void manageEvents(View view) {
            if (mItemListener != null) {
                ShoppingListForList clickedItem = mShoppingLists.get(getAdapterPosition());

                // Manejar evento de click en Favorito
                if (view.getId() == R.id.favorite_button) {
                    mItemListener.onFavoriteIconClicked(clickedItem);
                    return;
                }

                mItemListener.onClick(clickedItem);
            }
        }


        public void bind(ShoppingListForList item) {
            mNameText.setText(item.name);
            mFavoriteButton.setChecked(item.favorite);
        }
    }
}