package com.example.shopping_room.shoppinglists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.shopping_room.R;
import com.example.shopping_room.relationentities.ShoppingListAndInfo;

import java.util.List;

public class ShoppingListAdapter
        extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {

    private List<ShoppingListAndInfo> mShoppingLists;
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
        ShoppingListAndInfo item = mShoppingLists.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return mShoppingLists == null ? 0 : mShoppingLists.size();
    }

    public void setItems(List<ShoppingListAndInfo> items) {
        mShoppingLists = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }

    interface ItemListener {
        void onClick(ShoppingListAndInfo shoppingList);

        void onFavoriteIconClicked(ShoppingListAndInfo shoppingList);

        void onDeleteIconClicked(ShoppingListAndInfo shoppingList);
    }

    public class ShoppingListViewHolder extends RecyclerView.ViewHolder {
        private final TextView mNameText;
        private final CheckBox mFavoriteButton;
        private final ImageView mDeleteButton;
        private TextView mCreatedDateText;

        public ShoppingListViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameText = itemView.findViewById(R.id.name);
            mCreatedDateText = itemView.findViewById(R.id.created_date);
            mFavoriteButton = itemView.findViewById(R.id.favorite_button);
            mDeleteButton = itemView.findViewById(R.id.delete_button);

            // Setear eventos
            mFavoriteButton.setOnClickListener(this::manageEvents);
            mDeleteButton.setOnClickListener(this::manageEvents);
            itemView.setOnClickListener(this::manageEvents);
        }

        private void manageEvents(View view) {
            if (mItemListener != null) {
                ShoppingListAndInfo clickedItem = mShoppingLists.get(getAdapterPosition());

                // Manejar evento de click en Favorito
                if (view.getId() == R.id.favorite_button) {
                    mItemListener.onFavoriteIconClicked(clickedItem);
                    return;
                } else if (view.getId() == R.id.delete_button) {
                    mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }

                mItemListener.onClick(clickedItem);
            }
        }

        public void bind(ShoppingListAndInfo item) {
            mNameText.setText(item.shoppingList.name);
            mFavoriteButton.setChecked(item.shoppingList.favorite);
            mCreatedDateText.setText(item.info.createdDate);
        }
    }
}