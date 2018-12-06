package com.example.alice.csa_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AnnouncementEntry extends AppCompatActivity {
    Boolean adminCheck;
    public JSONObject json = null;
    public JSONArray jsonA = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // start location service
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_entry);

        Intent i = getIntent();
        adminCheck = i.getBooleanExtra("admin", false);

        final EditText title = findViewById(R.id.TitleEntry);
        final EditText description = findViewById(R.id.DescriptionEntry);
        Button enter = findViewById(R.id.EnterButton);

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

        enter.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String titleText = title.getText().toString();
                String descriptionText = description.getText().toString();

                JSONObject temp = new JSONObject();
                try {
                    temp.put("title", titleText);
                    temp.put("description", descriptionText);
                } catch (JSONException j) {
                    j.printStackTrace();
                }

                jsonA.put(temp);

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
                Intent i = new Intent(AnnouncementEntry.this, AnnouncementActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("admin", adminCheck);
                startActivity(i);
            }
        });
    }
}
