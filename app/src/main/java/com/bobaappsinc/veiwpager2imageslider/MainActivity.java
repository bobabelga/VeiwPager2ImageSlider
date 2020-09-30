package com.bobaappsinc.veiwpager2imageslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 locationViewPager = findViewById(R.id.locationsViewPager);

        List<Travellocation> travellocations = new ArrayList<>();

        Travellocation travellocationEffelTour = new Travellocation();
        travellocationEffelTour.imageUrl="https://static1.wllppr.co/preview/city/radio-city-music-hall-neons-at-night_264.jpg";
        travellocationEffelTour.titile=("France");
        travellocationEffelTour.locaiton=("Eiffel Tour");
        travellocationEffelTour.startRating=4.8f;
        travellocations.add(travellocationEffelTour);

        Travellocation travellocationnewyor = new Travellocation();
        travellocationnewyor.imageUrl="https://i.pinimg.com/originals/30/37/13/3037133188dc16cf3e226a4da79fff6c.jpg";
        travellocationnewyor.titile=("New York");
        travellocationnewyor.locaiton=("York Tour");
        travellocationnewyor.startRating=4.0f;
        travellocations.add(travellocationnewyor);

        Travellocation travellocationlondon = new Travellocation();
        travellocationlondon.imageUrl="https://i.pinimg.com/736x/6b/df/b7/6bdfb7ec3982bfde5e878970ff05658c.jpg";
        travellocationlondon.titile=("London");
        travellocationlondon.locaiton=("london Tour");
        travellocationlondon.startRating=5.0f;
        travellocations.add(travellocationlondon);

        Travellocation travellocationCHina = new Travellocation();
        travellocationCHina.imageUrl="https://static1.wllppr.co/preview/city/radio-city-music-hall-neons-at-night_264.jpg";
        travellocationCHina.titile=("China");
        travellocationCHina.locaiton=("China Tour");
        travellocationCHina.startRating=4.5f;
        travellocations.add(travellocationCHina);

        Travellocation travellocationEgypt = new Travellocation();
        travellocationEgypt.imageUrl="https://i.pinimg.com/736x/6b/df/b7/6bdfb7ec3982bfde5e878970ff05658c.jpg";
        travellocationEgypt.titile=("Egypt");
        travellocationEgypt.locaiton=("Egypt Tour");
        travellocationEgypt.startRating=3.8f;
        travellocations.add(travellocationEgypt);


        Travellocation travellocationBrazil = new Travellocation();
        travellocationBrazil.imageUrl="https://i.pinimg.com/originals/30/37/13/3037133188dc16cf3e226a4da79fff6c.jpg";
        travellocationBrazil.titile=("Brazil");
        travellocationBrazil.locaiton=("Brazil Tour");
        travellocationBrazil.startRating=4.7f;
        travellocations.add(travellocationBrazil);


        locationViewPager.setAdapter(new TravelLocationAdapter(travellocations));
        locationViewPager.setClipToPadding(false);
        locationViewPager.setClipChildren(false);
        locationViewPager.setOffscreenPageLimit(3);
        locationViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });
        locationViewPager.setPageTransformer(compositePageTransformer);
    }
}
