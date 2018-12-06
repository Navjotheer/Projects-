package com.example.navjotheer.smh;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DetailActivity extends AppCompatActivity {
    public JSONObject jos = null;
    public JSONArray ja = null;
    public int temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //
          //  Intent i = getIntent();
        //  String temp = i.getStringExtra("temp");
         // final int tempi = Integer.parseInt(temp);

        Intent i = getIntent();

        String title = i.getStringExtra("first");
        String description = i.getStringExtra("second");
        String dat = i.getStringExtra("data");
        String tim = i.getStringExtra("time");
        temp = i.getIntExtra("temp",0);


        //new
         Button c = findViewById(R.id.button2);
         c.setOnClickListener(new Button.OnClickListener() {
             @SuppressLint("NewApi")
             //jos = null;
             public void onClick(View v) {
                 try {
                     // Reading a file that already exists
                     File f = new File(getFilesDir(), "file.ser");
                     FileInputStream fi = new FileInputStream(f);
                     ObjectInputStream o = new ObjectInputStream(fi);
                     // Notice here that we are de-serializing a String object (instead of
                     // a JSONObject object) and passing the String to the JSONObject’s
                     // constructor. That’s because String is serializable and
                     // JSONObject is not. To convert a JSONObject back to a String, simply
                     // call the JSONObject’s toString method.
                     String j = null;
                     try {
                         j = (String) o.readObject();
                     } catch (ClassNotFoundException c) {
                         c.printStackTrace();
                     }
                     try {
                         jos = new JSONObject(j);
                         ja = jos.getJSONArray("data");
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                 } catch (FileNotFoundException e) {
                     e.printStackTrace();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }

                 ja.remove(temp);
                 // write the file
                 try {
                     File f = new File(getFilesDir(), "file.ser");
                     FileOutputStream fo = new FileOutputStream(f);
                     ObjectOutputStream o = new ObjectOutputStream(fo);
                     String j = jos.toString();
                     o.writeObject(j);
                     o.close();
                     fo.close();
                 } catch (IOException e) {

                 }

                 //pop the activity off the stack
                 Intent i = new Intent(DetailActivity.this, MainActivity.class);
                 i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 startActivity(i);
             }

            });




 /*       ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                99);


        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();

        private final LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                longitude = location.getLongitude();
                latitude = location.getLatitude();
            }
        } */





     //   String currentDateTimeString = DateFormat.getTimeInstance().format(new Date());

        //SimpleDateFormat postFormater = new SimpleDateFormat("MMMM dd, yyyy");
        //  String Date = postFormater.format(new Date());
        //  String time = i.getStringExtra("third");

       // SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
       // String formattedDate = df.format(new Date());

        TextView t = (TextView)findViewById(R.id.textView3);
        TextView d = (TextView)findViewById(R.id.textView4);

        TextView ti = (TextView)findViewById(R.id.textView11);
        TextView da = (TextView)findViewById(R.id.textView10);

        t.setText(title);
        d.setText(description);
        ti.setText(tim);
        da.setText(dat);

       // ti.setText(currentDateTimeString);
      //  da.setText(formattedDate);



    }
}
