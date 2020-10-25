package com.ibm.restaurants.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ibm.restaurants.R;
import com.ibm.restaurants.models.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<Item> items;
    private Context context;
    private ClickedItem clickedItem;

    public ItemAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void setData(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurant,parent,false);
        return new ItemViewHolder(view, clickedItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = items.get(position);
        String url = item.getIcon();
        Glide.with(context)
                .load(url)
                .into(holder.image);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private AppCompatImageView image;
        private AppCompatTextView title;
        private AppCompatTextView subTitle;
        private ClickedItem clickedItem;

        public ItemViewHolder(@NonNull View itemView, ClickedItem clickedItem) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            subTitle = itemView.findViewById(R.id.subtitle);
            this.clickedItem = clickedItem;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickedItem.onItemClicked(getAdapterPosition());
        }
    }

    public interface ClickedItem{
        void onItemClicked(int position);
    }
}
