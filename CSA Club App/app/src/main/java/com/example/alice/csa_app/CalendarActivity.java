package com.example.alice.csa_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
/*
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
*/

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {

    //Firebase firebasereference;

    public GregorianCalendar month, month_copy;
    private AnAdapter anAdapter;
    private TextView textviewmonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        CalendarData.date_array =new ArrayList<CalendarData>();
        CalendarData.date_array.add( new CalendarData("2018-06-14" ,"CSA Meeting","UCSC","1st Club Meeting"));
        CalendarData.date_array.add( new CalendarData("2018-07-09" ,"Diwali","Ho","this is holiday"));


        month = (GregorianCalendar) GregorianCalendar.getInstance();
        month_copy = (GregorianCalendar) month.clone();
        anAdapter = new AnAdapter(this, month, CalendarData.date_array);

        textviewmonth = (TextView) findViewById(R.id.tv_month);
        textviewmonth.setText(android.text.format.DateFormat.format("MMMM yyyy", month));


        ImageButton previous = (ImageButton) findViewById(R.id.ib_prev);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backMonth();         //goes to prev month
                refreshCalendar();
            }
        });

        ImageButton next = (ImageButton) findViewById(R.id.Ib_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextMonth();        //goes to next month
                refreshCalendar();
            }
        });

        GridView gridview = (GridView) findViewById(R.id.gv_calendar);
        gridview.setAdapter(anAdapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String selectedGridDate = AnAdapter.day_strng.get(position);
                ((AnAdapter) parent.getAdapter()).getPositionList(selectedGridDate, CalendarActivity.this);
            }

        });
        //mDatabase = FirebaseDatabase.getInstance();
        // mDataBaseRef = mDatabase.getReference().child("list").child("users");
        /*
        firebasereference = new Firebase("https://csa-app-v2.firebaseio.com/");
        firebasereference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    //String namess = ds.child("namess").getValue(String.class);
                    //String location = ds.child("location").getValue(String.class);

                    // CalendarData.date_array.add( new CalendarData("2018-06-10" ,"why","tf","this is holiday"));


                }*/

               /* String date = dataSnapshot.getValue(String.class);
                String name = dataSnapshot.getValue(String.class);
                String location = dataSnapshot.getValue(String.class);
                String description = dataSnapshot.getValue(String.class);

                CalendarData.date_array.add(new CalendarData(date,name,location,description));
                CalendarData.date_array.add(new CalendarData(date,name,location,description)); */
                // CalendarData.date_array.add( new CalendarData("2018-06-10" ,"why","tf","this is holiday"));

            }
/*
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }*/


    protected void nextMonth() {
        if (month.get(GregorianCalendar.MONTH) == month.getActualMaximum(GregorianCalendar.MONTH)) {
            month.set((month.get(GregorianCalendar.YEAR) + 1), month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            month.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void backMonth() {
        if (month.get(GregorianCalendar.MONTH) == month.getActualMinimum(GregorianCalendar.MONTH)) {
            month.set((month.get(GregorianCalendar.YEAR) - 1), month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            month.set(GregorianCalendar.MONTH, month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    public void refreshCalendar() {
        anAdapter.refreshDays();
        anAdapter.notifyDataSetChanged();
        textviewmonth.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
    }
}
