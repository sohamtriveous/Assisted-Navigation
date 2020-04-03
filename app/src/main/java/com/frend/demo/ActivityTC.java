package com.frend.demo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTC extends AppCompatActivity {

    TextView tvProceed;
    CheckBox cBTerms;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tc);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        linearLayout = findViewById(R.id.tvTermsConditions);
        tvProceed = findViewById(R.id.tvProceed);
        cBTerms = findViewById(R.id.cbTerms);

        linearLayout.setOnClickListener(v -> {
            if (!cBTerms.isChecked())
                cBTerms.setChecked(true);
            else
                cBTerms.setChecked(false);
        });


        tvProceed.setOnClickListener(v ->
                startActivity(new Intent(
                        ActivityTC.this, ActivityCard.class
                )));


    }
}
