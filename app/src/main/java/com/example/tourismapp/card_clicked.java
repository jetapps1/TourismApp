package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class card_clicked extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_clicked);
        Integer image = getIntent().getIntExtra("IMAGE", 0);
        String title = getIntent().getStringExtra("TITLE");
        String desc = getIntent().getStringExtra("DESC");

        ImageView image1 = (ImageView) findViewById(R.id.imgSplash);
        TextView Title = (TextView) findViewById(R.id.txtTitle);
        TextView Desc = (TextView) findViewById(R.id.txtDesc);

        image1.setImageResource(image);
        Title.setText(title);
        Desc.setText(desc);
    }

    public void returnToMain(){
        finish();
    }
}