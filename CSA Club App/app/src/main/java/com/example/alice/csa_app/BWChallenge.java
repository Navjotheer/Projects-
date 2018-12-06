package com.example.alice.csa_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BWChallenge extends AppCompatActivity {
    public String text = null;
    Boolean adminCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bwchallenge);

        Intent intent = getIntent();
        adminCheck = intent.getBooleanExtra("admin", false);
    }
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        adminCheck = intent.getBooleanExtra("admin", false);
        final TextView challengeT = (TextView)findViewById(R.id.biWeeklyChallenge);
        final TextView challengeE = (TextView)findViewById(R.id.ChallengeEdit);
        challengeE.setEnabled(false);
        challengeE.setVisibility(View.INVISIBLE);

        //read file
        try {
            File f = new File(getFilesDir(), "fileChallenges.ser");
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream o = new ObjectInputStream(fi);
            try {
                text = (String) o.readObject();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }
        } catch (IOException e) {
            // initialize num
            text = "No challenges.";
        }

        challengeT.setText(text);

        //done button
        final Button doneB = findViewById(R.id.DoneEdit);
        doneB.setEnabled(false);
        doneB.setVisibility(View.INVISIBLE);
        //edit button
        final Button editB = findViewById(R.id.EditChallenge);
        if (adminCheck == true) {
            editB.setEnabled(true);
            editB.setVisibility(View.VISIBLE);
        }
        else {
            editB.setEnabled(false);
            editB.setVisibility(View.INVISIBLE);
        }
        editB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                //read file
                try {
                    File f = new File(getFilesDir(), "fileChallenges.ser");
                    FileInputStream fi = new FileInputStream(f);
                    ObjectInputStream o = new ObjectInputStream(fi);
                    try {
                        text = (String) o.readObject();
                    } catch (ClassNotFoundException c) {
                        c.printStackTrace();
                    }
                } catch (IOException e) {
                    // initialize num
                    text = "No challenges.";
                }

                editB.setEnabled(false);
                editB.setVisibility(View.INVISIBLE);
                doneB.setEnabled(true);
                doneB.setVisibility(View.VISIBLE);

                challengeT.setEnabled(false);
                challengeT.setVisibility(View.INVISIBLE);
                challengeE.setEnabled(true);
                challengeE.setVisibility(View.VISIBLE);
                challengeE.setText(text);
            }
        });

        doneB.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                text = challengeE.getText().toString();
                doneB.setEnabled(false);
                doneB.setVisibility(View.INVISIBLE);
                editB.setEnabled(true);
                editB.setVisibility(View.VISIBLE);

                challengeE.setEnabled(false);
                challengeE.setVisibility(View.INVISIBLE);
                challengeT.setEnabled(true);
                challengeT.setVisibility(View.VISIBLE);
                challengeT.setText(text);

                //write file
                try {
                    File f = new File(getFilesDir(), "fileChallenges.ser");
                    FileOutputStream fo = new FileOutputStream(f);
                    ObjectOutputStream o = new ObjectOutputStream(fo);
                    o.writeObject(text);
                    o.close();
                    fo.close();
                } catch(IOException e) {

                }

            }
        });
    }
}
