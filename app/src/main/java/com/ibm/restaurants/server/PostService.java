package com.ibm.restaurants.server;



import com.ibm.restaurants.models.Item;
import com.ibm.restaurants.models.ItemDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Tag;

public interface PostService {
    @GET("/restaurant/list")
    Call<List<Item>> getRestaurants();

    @GET("/restaurant/list")
    Call<ItemDetails> getRestaurantByName(String name);
}