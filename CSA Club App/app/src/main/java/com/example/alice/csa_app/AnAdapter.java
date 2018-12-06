package com.example.alice.csa_app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

class AnAdapter extends BaseAdapter {

    private Activity context;
    private java.util.Calendar month;
    public GregorianCalendar pmonth;
    public GregorianCalendar monthmax;
    private GregorianCalendar selectedDate;
    int firstDay, maximumweek, maxprev,calendarMax, monthlength;

    String itemvalue, curentDate;
    DateFormat dateformat;

    private ArrayList<String> items;
    public static List<String> day_strng;
    public ArrayList<CalendarData> date_array;
    private String gridvalue;
    private ListView listView;
    private ArrayList<Dialogue> alCustom=new ArrayList<Dialogue>();

    public AnAdapter(Activity context, GregorianCalendar monthCalendar, ArrayList<CalendarData> date_array) {
        this.date_array =date_array;
        AnAdapter.day_strng = new ArrayList<String>();
        Locale.setDefault(Locale.US);
        month = monthCalendar;
        selectedDate = (GregorianCalendar) monthCalendar.clone();
        this.context = context;
        month.set(GregorianCalendar.DAY_OF_MONTH, 1);

        this.items = new ArrayList<String>();
        dateformat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        curentDate = dateformat.format(selectedDate.getTime());
        refreshDays();

    }

    public int getCount() {
        return day_strng.size();
    }

    public Object getItem(int position) {
        return day_strng.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TextView dayView;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item, null);

        }

        dayView = (TextView) v.findViewById(R.id.date);
        String[] separatedTime = day_strng.get(position).split("-");

        gridvalue = separatedTime[2].replaceFirst("^0*", "");
        if ((Integer.parseInt(gridvalue) > 1) && (position < firstDay)) {
            dayView.setTextColor(Color.parseColor("#A9A9A9"));
            dayView.setClickable(false);
            dayView.setFocusable(false);
        } else if ((Integer.parseInt(gridvalue) < 7) && (position > 28)) {
            dayView.setTextColor(Color.parseColor("#A9A9A9"));
            dayView.setClickable(false);
            dayView.setFocusable(false);
        } else {
            // setting curent month's days in blue color.
            dayView.setTextColor(Color.parseColor("#696969")); //rest of numbers
        }


        if (day_strng.get(position).equals(curentDate)) {

            v.setBackgroundColor(Color.parseColor("#ffffff")); //current day
        } else {
            v.setBackgroundColor(Color.parseColor("#ffffff"));
        }


        dayView.setText(gridvalue);

        String date = day_strng.get(position);

        if (date.length() == 1) {
            date = "0" + date;
        }
        String monthStr = "" + (month.get(GregorianCalendar.MONTH) + 1);
        if (monthStr.length() == 1) {
            monthStr = "0" + monthStr;
        }

        setEventView(v, position,dayView);

        return v;
    }

    public void refreshDays() {

        items.clear();
        day_strng.clear();
        Locale.setDefault(Locale.US);
        pmonth = (GregorianCalendar) month.clone();
        firstDay = month.get(GregorianCalendar.DAY_OF_WEEK);
        maximumweek = month.getActualMaximum(GregorianCalendar.WEEK_OF_MONTH);
        monthlength = maximumweek * 7;
        maxprev = getMaxprev();
        calendarMax = maxprev - (firstDay - 1);
        monthmax = (GregorianCalendar) pmonth.clone();

        monthmax.set(GregorianCalendar.DAY_OF_MONTH, calendarMax + 1);

        for (int n = 0; n < monthlength; n++) {

            itemvalue = dateformat.format(monthmax.getTime());
            monthmax.add(GregorianCalendar.DATE, 1);
            day_strng.add(itemvalue);

        }
    }

    private int getMaxprev() {
        int maxprevious;
        if (month.get(GregorianCalendar.MONTH) == month
                .getActualMinimum(GregorianCalendar.MONTH)) {
            pmonth.set((month.get(GregorianCalendar.YEAR) - 1),
                    month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            pmonth.set(GregorianCalendar.MONTH,
                    month.get(GregorianCalendar.MONTH) - 1);
        }
        maxprevious = pmonth.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

        return maxprevious;
    }




    public void setEventView(View v,int pos,TextView txt){

        int len= CalendarData.date_array.size();
        for (int i = 0; i < len; i++) {
            CalendarData cal_obj= CalendarData.date_array.get(i);
            String date=cal_obj.date;
            int len1= day_strng.size();
            if (len1>pos) {

                if (day_strng.get(pos).equals(date)) {
                    if ((Integer.parseInt(gridvalue) > 1) && (pos < firstDay)) {

                    } else if ((Integer.parseInt(gridvalue) < 7) && (pos > 28)) {

                    } else {
                        v.setBackgroundColor(Color.parseColor("#343434"));
                        v.setBackgroundResource(R.drawable.rounded_calender);
                        txt.setTextColor(Color.parseColor("#008080")); //circle number color
                    }

                }
            }}
    }

    public void getPositionList(String date,final Activity act){


        int len= CalendarData.date_array.size();
        JSONArray jbarrays=new JSONArray();
        for (int j=0; j<len; j++){
            if (CalendarData.date_array.get(j).date.equals(date)){
                HashMap<String, String> maplist = new HashMap<String, String>();
                maplist.put("namess", CalendarData.date_array.get(j).name);
                maplist.put("location", CalendarData.date_array.get(j).location);
                maplist.put("descript", CalendarData.date_array.get(j).description);
                JSONObject json1 = new JSONObject(maplist);
                jbarrays.put(json1);
            }
        }
        if (jbarrays.length()!=0) {
            final Dialog dialogs = new Dialog(context);
            dialogs.setContentView(R.layout.dialoguebox);
            listView = (ListView) dialogs.findViewById(R.id.list_teachers);
            ImageView imgCross = (ImageView) dialogs.findViewById(R.id.img_cross);
            listView.setAdapter(new DialogueAdapter(context, getMatchList(jbarrays + "")));
            imgCross.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialogs.dismiss();
                }
            });
            dialogs.show();
        }

    }

    private ArrayList<Dialogue> getMatchList(String detail) {
        try {
            JSONArray jsonArray = new JSONArray(detail);
            alCustom = new ArrayList<Dialogue>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);

                Dialogue dialogue = new Dialogue();

                dialogue.setTitles(jsonObject.optString("namess"));
                dialogue.setLocation(jsonObject.optString("location"));
                dialogue.setDescripts(jsonObject.optString("descript"));

                alCustom.add(dialogue);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return alCustom;
    }
}
