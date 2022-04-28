package com.example.seccion_06_fragments.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.seccion_06_fragments.Fragments.DetailsFragment;
import com.example.seccion_06_fragments.R;

public class DetailsActivity extends AppCompatActivity {

    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().getExtras() != null) {
            text = getIntent().getStringExtra("text");
        }
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detailsFragment);
        detailsFragment.renderText(text);
    }
}