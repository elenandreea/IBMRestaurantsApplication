package com.ibm.restaurants.server;



import com.ibm.restaurants.models.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {
    @GET("/restaurant/list")
    Call<List<Item>> getRestaurants();
}