package com.gading.praktikum5mobilehero;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class activityhero extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        int photoResource = getIntent().getIntExtra("HERO_PHOTO", 0);
        String name = getIntent().getStringExtra("HERO_NAME");
        String description = getIntent().getStringExtra("HERO_DESCRIPTION");
        ImageView imageView = findViewById(R.id.img_item_photo);
        TextView nameTextView = findViewById(R.id.tv_item_name);
        TextView descriptiomTextView = findViewById(R.id.tv_item_description);
        imageView.setImageResource(photoResource);
        nameTextView.setText(name);
        descriptiomTextView.setText(description);
    }

}