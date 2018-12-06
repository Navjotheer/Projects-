package com.example.alice.csa_app;

import java.util.ArrayList;

public class CalendarData {
    public String date="", name="", location ="", description="";
    public static ArrayList<CalendarData> date_array;
    public CalendarData(String date, String name, String location, String description){
        this.date=date;
        this.name=name;
        this.location =location;
        this.description= description;
    }
}
