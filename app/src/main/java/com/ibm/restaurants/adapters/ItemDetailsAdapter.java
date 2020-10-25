package com.ibm.restaurants.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ibm.restaurants.R;

import java.util.ArrayList;

public class ItemDetailsAdapter extends RecyclerView.Adapter<ItemDetailsAdapter.ItemDetailsViewHolder> {
    private ArrayList<String> imageURLs;
    private Context context;

    public ItemDetailsAdapter(ArrayList<String> imageURLs, Context context) {
        this.imageURLs = imageURLs;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_layout,parent,false);
        return new ItemDetailsAdapter.ItemDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDetailsViewHolder holder, int position) {
        String url = imageURLs.get(position);
        Glide.with(context)
                .load(url)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return imageURLs.size();
    }

    static class ItemDetailsViewHolder extends RecyclerView.ViewHolder{
        private AppCompatImageView imageView;

        ItemDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.view_single_pic);

        }
    }
}
