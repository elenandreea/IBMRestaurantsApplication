package com.ibm.restaurants.restaurantdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ibm.restaurants.R;
import com.ibm.restaurants.adapters.ItemDetailsAdapter;
import com.ibm.restaurants.models.Item;

public class RestaurantDetailsActivity extends AppCompatActivity {
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail_layout);

        AppCompatTextView restaurantTitle = findViewById(R.id.title_detail);
        AppCompatTextView restaurantDetails = findViewById(R.id.description_detail);

        restaurantDetails.setText(item.getSubTitle());
        restaurantTitle.setText(item.getTitle());

        RecyclerView recyclerView = findViewById(R.id.recycle_detail);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        ItemDetailsAdapter itemDetailsAdapter = new ItemDetailsAdapter(item.getImageURLs(), this);
//        recyclerView.setAdapter(itemDetailsAdapter);
    }
}
