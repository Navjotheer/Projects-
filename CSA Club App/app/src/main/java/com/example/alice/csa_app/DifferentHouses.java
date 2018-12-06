package com.example.alice.csa_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DifferentHouses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different_houses);
    }

    public void onClickChrysanthemum(View view) {
        Intent i = new Intent(this, HouseChrysanthemum.class);
        //i.putExtra("admin", adminCheck);
        startActivity(i);
    }
    public void onClickCitron(View view) {
        Intent i = new Intent(this, HouseCitron.class);
        //i.putExtra("admin", adminCheck);
        startActivity(i);
    }
    public void onClickNarcissus(View view) {
        Intent i = new Intent(this, HouseNarcissus.class);
        //i.putExtra("admin", adminCheck);
        startActivity(i);
    }

    public void onClickOrchid(View view) {
        Intent i = new Intent(this, HouseOrchid.class);
        //i.putExtra("admin", adminCheck);
        startActivity(i);
    }

    public void onClickPeony(View view) {
        Intent i = new Intent(this, HousePeony.class);
        //i.putExtra("admin", adminCheck);
        startActivity(i);
    }
}
