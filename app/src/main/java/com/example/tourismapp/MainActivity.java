package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DestinationAdapter.OnRowClickListener, HorizontalAdapter.OnRowClickListener{

    RecyclerView horizontalRecyclerView, verticalRecyclerView;
    DestinationAdapter destinationAdapter;
    HorizontalAdapter horizontalAdapter;
    List<Destination> destinationList = new ArrayList<>();
    List<Gallery> galleryList = new ArrayList<>();

    Integer[] horizontalImageList = {R.drawable.eiffel, R.drawable.greatoceanroad, R.drawable.sydney, R.drawable.thailand};
    Integer[] verticalImageList = {R.drawable.eiffel, R.drawable.greatoceanroad, R.drawable.sydney, R.drawable.thailand};

    String[] titleList = {"Eiffel Tower", "Great Ocean Road", "Sydney", "Thailand"};
    String[] descList = {"This is a really long and cool desc", "This is a another really long and cool desc", "one more", "maybe another one"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ----------------------------------- Vertical cards -----------------------------


        verticalRecyclerView = findViewById(R.id.VerticalRecyclerView);
        destinationAdapter = new DestinationAdapter(destinationList, MainActivity.this, this);
        verticalRecyclerView.setAdapter(destinationAdapter);
        RecyclerView.LayoutManager VerticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        verticalRecyclerView.setLayoutManager(VerticalLayoutManager);

        for (int i = 0; i < verticalImageList.length; i++) {
            com.example.tourismapp.Destination destination = new com.example.tourismapp.Destination(i, verticalImageList[i], titleList[i], descList[i]);
            destinationList.add(destination);
        }

        // ----------------------------------- Horizontal Gallery -----------------------------

        horizontalRecyclerView = findViewById(R.id.HorizontalRecyclerView);
        horizontalAdapter = new HorizontalAdapter(galleryList, getApplicationContext(), this);
        horizontalRecyclerView.setAdapter(horizontalAdapter);
        RecyclerView.LayoutManager HorizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(HorizontalLayoutManager);
//
        for (int i = 0; i < horizontalImageList.length; i++) {
            com.example.tourismapp.Gallery gallery = new com.example.tourismapp.Gallery(i, horizontalImageList[i]);
            galleryList.add(gallery);
        }
    }
    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(MainActivity.this, card_clicked.class);
        intent.putExtra("IMAGE", destinationList.get(position).getImage());
        intent.putExtra("TITLE", destinationList.get(position).getTitle());
        intent.putExtra("DESC", destinationList.get(position).getDesc());
        startActivity(intent);
}
}