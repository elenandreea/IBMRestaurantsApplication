package com.ibm.restaurants.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.ibm.restaurants.R;
import com.ibm.restaurants.adapters.ItemAdapter;
import com.ibm.restaurants.models.Item;
import com.ibm.restaurants.restaurantdetails.RestaurantDetailsActivity;
import com.ibm.restaurants.server.ServiceProvider;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantsActivity extends AppCompatActivity {
    public static final String RESTAURANT_DETAILS_KEY = "100";

    List<Item> body;
    RecyclerView recyclerView;
    ItemAdapter itemAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);

        getRestaurantsAsynchronously();

        recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

    }

    private void getRestaurantsAsynchronously() {
        ServiceProvider.createPostService().getRestaurants().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    body = response.body();
                    itemAdapter = new ItemAdapter((ArrayList<Item>) body, getBaseContext());
                    setItemAdapter();
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


    public void setItemAdapter() {
        itemAdapter.setOnItemListener(position -> {
            Intent detailsRestaurant = new Intent(RestaurantsActivity.this, RestaurantDetailsActivity.class);
            detailsRestaurant.putExtra(RestaurantsActivity.RESTAURANT_DETAILS_KEY, body.get(position));
            startActivity(detailsRestaurant);
        });
        recyclerView.setAdapter(itemAdapter);
    }
}
