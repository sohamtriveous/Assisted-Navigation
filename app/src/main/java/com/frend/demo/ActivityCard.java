package com.frend.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityCard extends AppCompatActivity {

    View banking, business;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle("Internet Saathi");

        banking = findViewById(R.id.tvBanking);
        business = findViewById(R.id.tvBusiness);

        banking.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityCard.this, ActivityDetails.class);
            intent.putExtra("name", getResources().getString(R.string.textBanking));
            startActivity(intent);
        });

        business.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityCard.this, ActivityDetails.class);
            intent.putExtra("name", getResources().getString(R.string.textBusiness));
            startActivity(intent);
        });


    }
}
