package com.ibm.restaurants.restaurantdetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;

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
import com.ibm.restaurants.utils.SharedPrefUtil;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDetailsActivity extends AppCompatActivity implements OnMapReadyCallback {
    Item item;
    private boolean hasFavouriteRestaurant;
    private SharedPrefUtil prefUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_detail_layout);

        item = getIntent().getParcelableExtra(RestaurantsActivity.RESTAURANT_DETAILS_KEY);

        setToolbar();
        setTextViews();
        setMapView(savedInstanceState);
        setRecycleView();
    }

    private void setMapView(Bundle savedInstanceState) {
        MapView mapView = findViewById(R.id.image_map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        mapView.getMapAsync(this);
    }

    private void setTextViews() {
        AppCompatTextView restaurantTitle = findViewById(R.id.title_detail);
        restaurantTitle.setText(item.getTitle());

        AppCompatTextView restaurantDetails = findViewById(R.id.description_detail);
        restaurantDetails.setText(item.getSubTitle());
        restaurantDetails.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    private void setRecycleView() {
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

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(item.getTitle());
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu, menu);
        prefUtil = new SharedPrefUtil(this);
        hasFavouriteRestaurant = prefUtil.isFavorite(item.getTitle());
        menu.findItem(R.id.action_favourite)
                .setIcon(hasFavouriteRestaurant ? R.drawable.ic_heart : R.drawable.ic_heart_empty);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_favourite) {
            if (hasFavouriteRestaurant)
                menuItem.setIcon(R.drawable.ic_heart_empty);
             else
                menuItem.setIcon(R.drawable.ic_heart);

            hasFavouriteRestaurant=!hasFavouriteRestaurant;
            prefUtil.changeFavorite(item.getTitle(), hasFavouriteRestaurant);
        }
        return super.onOptionsItemSelected(menuItem);
    }

}
