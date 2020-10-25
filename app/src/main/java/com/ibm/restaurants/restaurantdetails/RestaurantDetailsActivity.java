package com.ibm.restaurants.restaurantdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.ibm.restaurants.R;
import com.ibm.restaurants.adapters.ItemDetailsAdapter;
import com.ibm.restaurants.models.Item;
import com.ibm.restaurants.models.ItemDetails;
import com.ibm.restaurants.server.ServiceProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantDetailsActivity extends AppCompatActivity {
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail_layout);

        getRestaurantsAsynchronously();

//        AppCompatTextView restaurantTitle = findViewById(R.id.title_detail);
//        AppCompatTextView restaurantDetails = findViewById(R.id.description_detail);

//        restaurantDetails.setText(item.getSubTitle());
//        restaurantTitle.setText(item.getTitle());

//        RecyclerView recyclerView = findViewById(R.id.recycle_detail);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        ItemDetailsAdapter itemDetailsAdapter = new ItemDetailsAdapter(item.getImageURLs(), this);
//        recyclerView.setAdapter(itemDetailsAdapter);
    }

    private void getRestaurantsAsynchronously() {
        ServiceProvider.createPostService().getRestaurantByName("Volare").enqueue(new Callback<ItemDetails>() {
            @Override
            public void onResponse(Call<ItemDetails> call, Response<ItemDetails> response) {
                if(response.isSuccessful()){
                    ItemDetails itemDetails = response.body();
                    System.out.println(itemDetails);
                    Log.i("CREATE", itemDetails.getTitle());

                    AppCompatTextView restaurantTitle = findViewById(R.id.title_detail);
                    AppCompatTextView restaurantDetails = findViewById(R.id.description_detail);

                    restaurantDetails.setText(itemDetails.getSubTitle());
                    restaurantTitle.setText(itemDetails.getTitle());
                }
            }

            @Override
            public void onFailure(Call<ItemDetails> call, Throwable t) {

            }
        });
    }
}
