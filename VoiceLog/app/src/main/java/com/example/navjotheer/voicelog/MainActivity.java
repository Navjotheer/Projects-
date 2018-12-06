package com.example.navjotheer.voicelog;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "JSON_LIST";
    private ListView mListView;
  //  private final String TAG = "ListView";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, String.format("" + item.getItemId()));
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_favorite:
                /*the R.id.action_favorite is the ID of our button (defined in strings.xml).
                Change Activity here (if that's what you're intending to do, which is probably is).
                 */
                Intent i = new Intent(this, Adding.class);
                startActivity(i);
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }

    protected void onResume(){
        super.onResume();
        mListView = (ListView) findViewById(R.id.data_list_view);



        //ListView list = findViewById(R.id.data_list_view);
        //TextView text = findViewById(R.id.text);
        //text.setVisibility(View.INVISIBLE);

       // Log.d(TAG, ""+getFilesDir());

       // jos = null;

            // Reading a file that already exists
         //  File f = new File(getFilesDir(), "file.ser");
         //  FileInputStream fi = new FileInputStream(f);
          // ObjectInputStream o = new ObjectInputStream(fi);

         /* String j = null;
        try{
            j = (String) o.readObject();
        }
        catch(ClassNotFoundException c){
            c.printStackTrace();
        }
        int numMemos = Integer.parseInt(j);
        String [] Array = new String[numMemos]; */

        String Audfiles = null;
        try {
            InputStream is = getAssets().open("numMemos.ser");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            Audfiles = new String(buffer, "UTF-8");
        }
        catch (java.io.IOException ex) {
            ex.printStackTrace();
            return;
        }



        try {
            int numMemos = Integer.parseInt(j);
            String [] Array = new String[numMemos];
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        final ArrayList<ListData> list = new ArrayList<ListData>();

        // create ListData objects from data and store in ArrayList called list
        for(int i = 0; i < dataList.length(); i++){

            ListData ld = new ListData();
            try {
                ld.title = dataList.getJSONObject(i).getString("title");
                ld.description = dataList.getJSONObject(i).getString("description");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }


            list.add(ld);
        }
        String[] listItems = new String[list.size()];

        for(int i = 0; i < list.size(); i++){
            ListData listD = list.get(i);
            listItems[i] = listD.title;
        }

        // Show the list view with the each list item an element from listItems
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        mListView.setAdapter(adapter);

        // Set an OnItemClickListener for each of the list items
        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListData selected = list.get(position);

                // Create an Intent to reference our new activity, then call startActivity
                // to transition into the new Activity.
                Intent detailIntent = new Intent(context, Adding.class);

                // pass some key value pairs to the next Activity (via the Intent)
                detailIntent.putExtra("title", selected.title);
                detailIntent.putExtra("description", selected.description);

                startActivity(detailIntent);
            }

        });



    }
}
