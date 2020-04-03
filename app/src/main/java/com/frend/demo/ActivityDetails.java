package com.frend.demo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityDetails extends AppCompatActivity {

    TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getIntent().getExtras().getString("name"));

        tvText = findViewById(R.id.tvTemp);

        tvText.setText(getIntent().getExtras().getString("name"));


    }

}
