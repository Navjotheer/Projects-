package com.example.alice.csa_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AnnouncementDetail extends AppCompatActivity {
    private static final String TAG = "admin";
    Boolean adminCheck = false;
    public JSONObject json = null;
    public JSONArray jsonA = null;
    public int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_detail);

        Intent i = getIntent();
        final String title = i.getStringExtra("title");
        final String description = i.getStringExtra("description");
        index = i.getIntExtra("index", 0);
        adminCheck = i.getBooleanExtra("admin", true);

        TextView t = (TextView)findViewById(R.id.Title);
        TextView d = (TextView)findViewById(R.id.Detail);

        t.setText(title);
        d.setText(description);

        //edit button
        Button editB = findViewById(R.id.EditButton);
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
                //pop activity off stack
                Intent i = new Intent(AnnouncementDetail.this, AnnouncementEdit.class);
                i.putExtra("index", index);
                i.putExtra("title", title);
                i.putExtra("description", description);
                i.putExtra("admin", adminCheck);
                //i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        //delete button
        Button deleteB = findViewById(R.id.DeleteButton);
        if (adminCheck == true) {
            deleteB.setEnabled(true);
            deleteB.setVisibility(View.VISIBLE);
        }
        else {
            deleteB.setEnabled(false);
            deleteB.setVisibility(View.INVISIBLE);
        }
        deleteB.setOnClickListener(new Button.OnClickListener() {
            @SuppressLint("NewApi")
            public void onClick(View view) {
                //read file
                try {
                    File f = new File(getFilesDir(), "file.ser");
                    FileInputStream fi = new FileInputStream(f);
                    ObjectInputStream o = new ObjectInputStream(fi);
                    String j = null;
                    try {
                        j = (String) o.readObject();
                    } catch (ClassNotFoundException c) {
                        c.printStackTrace();
                    }
                    try {
                        json = new JSONObject(j);
                        jsonA = json.getJSONArray("data");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    // initialize new JSONObject
                    json = new JSONObject();
                    jsonA = new JSONArray();
                    try {
                        json.put("data", jsonA);
                    } catch (JSONException j) {
                        j.printStackTrace();
                    }
                }

                jsonA.remove(index);

                //write file
                try {
                    File f = new File(getFilesDir(), "file.ser");
                    FileOutputStream fo = new FileOutputStream(f);
                    ObjectOutputStream o = new ObjectOutputStream(fo);
                    String j = json.toString();
                    o.writeObject(j);
                    o.close();
                    fo.close();
                } catch(IOException e) {

                }

                //pop activity off stack
                Intent i = new Intent(AnnouncementDetail.this, AnnouncementActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("admin", adminCheck);
                startActivity(i);
            }
        });
    }
}
