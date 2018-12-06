package com.example.alice.csa_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {
    Boolean adminCheck;
    public JSONObject jsonO = null;
    public JSONArray jsonA = null;
    private static final String TAG = "JSON_LIST";
    private static final String TAGi = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        Intent intent = getIntent();
        adminCheck = intent.getBooleanExtra("admin", false);
        Log.d(TAGi, "create" + Boolean.toString(adminCheck));
    }

    protected void onResume(){
        super.onResume();
        Intent intent = getIntent();
        adminCheck = intent.getBooleanExtra("admin", false);
        Log.d(TAGi, "resume" + Boolean.toString(adminCheck));

        ListView list = findViewById(R.id.AnnouncementList);
        TextView listEmptyText = findViewById(R.id.text);
        listEmptyText.setVisibility(View.INVISIBLE);

        Log.d(TAG, ""+getFilesDir());

        jsonO = null;

        try{
            //read file that already exists
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
                jsonO = new JSONObject(j);
                jsonA = jsonO.getJSONArray("data");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            //show list
            final ArrayList<ListData> aList = new ArrayList<ListData>();
            for (int i = 0; i < jsonA.length(); i++) {
                ListData ld = new ListData();
                try {
                    ld.title = jsonA.getJSONObject(i).getString("title");
                    ld.description = jsonA.getJSONObject(i).getString("description");
                } catch (JSONException e1) {
                    e1.printStackTrace();
                }
                aList.add(ld);
            }

            String[] listItems = new String[aList.size()];
            for (int i = 0; i < aList.size(); i++) {
                ListData listD = aList.get(i);
                listItems[i] = listD.title;
            }
            // show empty list text when no announcements
            if (listItems.length == 0) {
                list.setEnabled(false);
                list.setVisibility(View.INVISIBLE);

                //show text when list is empty
                listEmptyText.setVisibility(View.VISIBLE);
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
            list.setAdapter(adapter);

            //onItemClickListener for each list item
            final Context context = this;
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    ListData selected = aList.get(position);

                    //intent to reference new activity
                    Intent detailIntent = new Intent(context, AnnouncementDetail.class);
                    detailIntent.putExtra("title", selected.title);
                    detailIntent.putExtra("description", selected.description);
                    detailIntent.putExtra("index", position);
                    Log.d(TAGi, Boolean.toString(adminCheck));
                    detailIntent.putExtra("admin", adminCheck);

                    startActivity(detailIntent);
                }
            });
        } catch (IOException e) {

            //no JSON file exist, don't show list
            //disable list view
            list.setEnabled(false);
            list.setVisibility(View.INVISIBLE);

            //show text view
            listEmptyText.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        // the menu being referenced here is the menu.xml from res/menu/menu.xml
        inflater.inflate(R.menu.menu, menu);
        Log.d(TAGi, "menu" + Boolean.toString(adminCheck));
        Log.d(TAGi, "menu" + Boolean.toString(adminCheck));
        if (adminCheck == true) {
            Log.d(TAGi, "menu" + Boolean.toString(adminCheck));
            menu.findItem(R.id.action_favorite).setEnabled(true);
            menu.findItem(R.id.action_favorite).setVisible(true);
        }
        else {
            menu.findItem(R.id.action_favorite).setEnabled(false);
            menu.findItem(R.id.action_favorite).setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* Here is the event handler for the menu button that I forgot in class.
    The value returned by item.getItemID() is
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, String.format("" + item.getItemId()));
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
                /*the R.id.action_favorite is the ID of our button (defined in strings.xml).
                Change Activity here (if that's what you're intending to do, which is probably is).
                 */
                Intent i = new Intent(this, AnnouncementEntry.class);
                i.putExtra("admin", adminCheck);
                startActivity(i);
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }
}
