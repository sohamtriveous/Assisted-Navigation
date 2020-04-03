package com.frend.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.frend.assistednavigation.CustomAssistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAssistant.offlineDownload(this);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Internet Saathi");
        }
        final TextView tvE = findViewById(R.id.tvEnglish);
        final TextView tvH = findViewById(R.id.tvHindi);
        final TextView tvM = findViewById(R.id.tvMalayalam);

        String temp = "tvNext";
        tvN = findViewById(getResources().getIdentifier(temp, "id", getPackageName()));


        tvE.setOnClickListener(v -> {
            new Util().setLocale(this, "en");
            tvN.setText(R.string.buttonNext);
        });


        tvH.setOnClickListener(view ->
        {
            new Util().setLocale(this, "hi");
            tvN.setText(R.string.buttonNext);
        });

        tvN.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, ActivityTC.class)));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_share:

                CustomAssistant.init(this.getApplication(), "sample2", "hi");
                CustomAssistant.guide(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
