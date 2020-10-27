package com.ibm.restaurants.restaurantdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ibm.restaurants.R;
import com.ibm.restaurants.adapters.ItemDetailsAdapter;
import com.ibm.restaurants.models.Item;
import com.ibm.restaurants.models.ItemDetail;
import com.ibm.restaurants.restaurants.RestaurantsActivity;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail_layout);

        item = getIntent().getParcelableExtra(RestaurantsActivity.RESTAURANT_DETAILS_KEY);

        AppCompatTextView restaurantTitle = findViewById(R.id.title_detail);
        restaurantTitle.setText(item.getTitle());

        AppCompatTextView restaurantDetails = findViewById(R.id.description_detail);
        restaurantDetails.setText(item.getSubTitle());
        restaurantDetails.setMovementMethod(ScrollingMovementMethod.getInstance());

        MapView mapView = findViewById(R.id.image_map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        mapView.getMapAsync(this);


        RecyclerView recyclerView = findViewById(R.id.recycle_detail);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        if (item != null) {
            ArrayList<String> imagesToDisplay = new ArrayList<>();
            List<ItemDetail> allDetails = item.getImageURLs();

            for (ItemDetail detail : allDetails) {
                imagesToDisplay.add(detail.getImagePath());
            }

            ItemDetailsAdapter itemDetailsAdapter = new ItemDetailsAdapter(imagesToDisplay, this);
            recyclerView.setAdapter(itemDetailsAdapter);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng coordinates = new LatLng(item.getLatitude(), item.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(coordinates).title(item.getTitle()));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordinates,16));
    }
}
