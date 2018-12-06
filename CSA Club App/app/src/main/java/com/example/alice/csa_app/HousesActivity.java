package com.example.alice.csa_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.content.Intent;

public class HousesActivity extends AppCompatActivity {
    Boolean adminCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_houses);
        Intent intent = getIntent();
        adminCheck = intent.getBooleanExtra("admin", false);
    }

    public void onClickViewHouses(View view) {
        Intent i = new Intent(this, DifferentHouses.class);
        i.putExtra("admin", adminCheck);
        startActivity(i);
    }
    public void onClickBWChalleges(View view) {
        Intent i = new Intent(this, BWChallenge.class);
        i.putExtra("admin", adminCheck);
        startActivity(i);
    }
    public void onClickScores(View view) {
        Intent i = new Intent(this, Scores.class);
        i.putExtra("admin", adminCheck);
        startActivity(i);
    }
}
