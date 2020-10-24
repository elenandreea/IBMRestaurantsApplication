package com.ibm.restaurants.restaurants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ibm.restaurants.R;
import com.ibm.restaurants.adapters.ItemAdapter;
import com.ibm.restaurants.models.Item;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        ItemAdapter itemAdapter = new ItemAdapter(getMockItems(), getBaseContext());
        recyclerView.setAdapter(itemAdapter);
    }

    private ArrayList<Item> getMockItems() {
        ArrayList<String> urls = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            urls.add("https://media-cdn.tripadvisor.com/media/photo-s/06/c6/e4/7e/the-clink-restaurant.jpg");

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("https://media-cdn.tripadvisor.com/media/photo-s/06/c6/e4/7e/the-clink-restaurant.jpg","The Clink Restaurant",
                "The Clink Restaurant at HMP Brixton opened in February 2014 as the third restaurant operated by The Clink Charity in the UK and offers up to 30 prisoners full-time work within the restaurant and kitchen.", urls));
        items.add(new Item("https://media-cdn.tripadvisor.com/media/photo-s/14/8a/6e/59/elegant-decoration.jpg","The Chelsea Corner",
                "Authentic Italian for us always means the freshest ingredients that are rightly dictated by the season.", urls));
        items.add(new Item("https://media-cdn.tripadvisor.com/media/photo-s/19/5f/35/54/salmon-teriyaki.jpg","Companero",
                "Compañero is the new Street Tapas brought to you by Nikolaus Greig and utilising his vast experience in food & wine.", urls));
        items.add(new Item("https://media-cdn.tripadvisor.com/media/photo-s/17/08/90/fe/deli.jpg","Chez Antoinette Victoria",
                "Chez Antoinette is a French Bistro. You can visit us from Breakfast, Brunch and all day long either for just a coffee, lunch, afternoon tea, a glass of wine or a dinner.", urls));
        items.add(new Item("https://media-cdn.tripadvisor.com/media/photo-s/12/03/e2/4e/ground-floor-dining-area.jpg","The Gojk",
                "The Gojk, pronounced G-oi-k, is a family run contemporary restaurant & lounge designed with great passion.", urls));
        items.add(new Item("https://media-cdn.tripadvisor.com/media/photo-s/04/be/4e/48/alyn-williams-at-the.jpg","Alyn Williams at the Westbury",
                "Alyn Williams at The Westbury is a shining star in Mayfair’s ever-growing Michelin constellation. ", urls));
        items.add(new Item("https://media-cdn.tripadvisor.com/media/photo-s/0b/63/a5/6b/pizzeria-volare.jpg","Volare",
                "Founded in 2015 by two Spanish sisters inspired by the love and passion of their Neapoletan Great-grandfather who opened his own pizzeria in Argentina in the 1920s.", urls));
        return items;
    }
}
