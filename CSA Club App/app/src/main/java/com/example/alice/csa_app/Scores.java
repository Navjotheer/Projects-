package com.example.alice.csa_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Scores extends AppCompatActivity {
    Boolean adminCheck;
    public int chScore = 0;
    public int ciScore = 0;
    public int naScore = 0;
    public int orScore = 0;
    public int peScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Intent intent = getIntent();
        adminCheck = intent.getBooleanExtra("admin", false);

        final TextView chrysanthemumScore = findViewById(R.id.ChrysanthemumScore);
        chScore = Integer.parseInt(chrysanthemumScore.getText().toString());
        ImageButton chrysanthemumPlus = findViewById(R.id.ChrysanthemumPlus);
        chrysanthemumPlus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                chScore++;
                chrysanthemumScore.setText(Integer.toString(chScore));
            }
        });
        ImageButton chrysanthemumMinus = findViewById(R.id.ChrysanthemumMinus);
        chrysanthemumMinus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                chScore--;
                chrysanthemumScore.setText(Integer.toString(chScore));
            }
        });

        final TextView citronScore = findViewById(R.id.CitronScore);
        ciScore = Integer.parseInt(citronScore.getText().toString());
        ImageButton citronPlus = findViewById(R.id.CitronPlus);
        citronPlus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                ciScore++;
                citronScore.setText(Integer.toString(ciScore));
            }
        });
        ImageButton citronMinus = findViewById(R.id.CitronMinus);
        citronMinus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                ciScore--;
                citronScore.setText(Integer.toString(ciScore));
            }
        });

        final TextView narcissusScore = findViewById(R.id.NarcissusScore);
        naScore = Integer.parseInt(narcissusScore.getText().toString());
        ImageButton narcissusPlus = findViewById(R.id.NarcissusPlus);
        narcissusPlus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                naScore++;
                narcissusScore.setText(Integer.toString(naScore));
            }
        });
        ImageButton narcissusMinus = findViewById(R.id.NarcissusMinus);
        narcissusMinus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                naScore--;
                narcissusScore.setText(Integer.toString(naScore));
            }
        });

        final TextView orchidScore = findViewById(R.id.OrchidScore);
        orScore = Integer.parseInt(orchidScore.getText().toString());
        ImageButton orchidPlus = findViewById(R.id.OrchidPlus);
        orchidPlus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                orScore++;
                orchidScore.setText(Integer.toString(orScore));
            }
        });
        ImageButton orchidMinus = findViewById(R.id.OrchidMinus);
        orchidMinus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                orScore--;
                orchidScore.setText(Integer.toString(orScore));
            }
        });

        final TextView peonyScore = findViewById(R.id.PeonyScore);
        peScore = Integer.parseInt(peonyScore.getText().toString());
        ImageButton peonyPlus = findViewById(R.id.PeonyPlus);
        peonyPlus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                peScore++;
                peonyScore.setText(Integer.toString(peScore));
            }
        });
        ImageButton peonyMinus = findViewById(R.id.PeonyMinus);
        peonyMinus.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                peScore--;
                peonyScore.setText(Integer.toString(peScore));
            }
        });

        if (adminCheck == true) {
            chrysanthemumPlus.setEnabled(true);
            chrysanthemumPlus.setVisibility(View.VISIBLE);
            chrysanthemumMinus.setEnabled(true);
            chrysanthemumMinus.setVisibility(View.VISIBLE);
            citronPlus.setEnabled(true);
            citronPlus.setVisibility(View.VISIBLE);
            citronMinus.setEnabled(true);
            citronMinus.setVisibility(View.VISIBLE);
            narcissusPlus.setEnabled(true);
            narcissusPlus.setVisibility(View.VISIBLE);
            narcissusMinus.setEnabled(true);
            narcissusMinus.setVisibility(View.VISIBLE);
            orchidPlus.setEnabled(true);
            orchidPlus.setVisibility(View.VISIBLE);
            orchidMinus.setEnabled(true);
            orchidMinus.setVisibility(View.VISIBLE);
            peonyPlus.setEnabled(true);
            peonyPlus.setVisibility(View.VISIBLE);
            peonyMinus.setEnabled(true);
            peonyMinus.setVisibility(View.VISIBLE);
        }
        else {
            chrysanthemumPlus.setEnabled(false);
            chrysanthemumPlus.setVisibility(View.INVISIBLE);
            chrysanthemumMinus.setEnabled(false);
            chrysanthemumMinus.setVisibility(View.INVISIBLE);
            citronPlus.setEnabled(false);
            citronPlus.setVisibility(View.INVISIBLE);
            citronMinus.setEnabled(false);
            citronMinus.setVisibility(View.INVISIBLE);
            narcissusPlus.setEnabled(false);
            narcissusPlus.setVisibility(View.INVISIBLE);
            narcissusMinus.setEnabled(false);
            narcissusMinus.setVisibility(View.INVISIBLE);
            orchidPlus.setEnabled(false);
            orchidPlus.setVisibility(View.INVISIBLE);
            orchidMinus.setEnabled(false);
            orchidMinus.setVisibility(View.INVISIBLE);
            peonyPlus.setEnabled(false);
            peonyPlus.setVisibility(View.INVISIBLE);
            peonyMinus.setEnabled(false);
            peonyMinus.setVisibility(View.INVISIBLE);
        }
    }
}
