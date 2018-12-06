package com.example.alice.csa_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "admin";
    Boolean adminCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAnnouncement(View view) {
        Intent i = new Intent(this, AnnouncementActivity.class);
        Log.d(TAG, Boolean.toString(adminCheck));
        i.putExtra("admin", adminCheck);
        startActivity(i);
    }
    public void onClickCalendar(View view) {
        Intent i = new Intent(this, CalendarActivity.class);
        startActivity(i);
    }
    public void onClickHouses(View view) {
        Intent i = new Intent(this, HousesActivity.class);
        i.putExtra("admin", adminCheck);
        startActivity(i);
    }
    public void onClickAboutUs(View view) {
        Intent i = new Intent(this, AboutUsActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        // the menu being referenced here is the menu.xml from res/menu/menu.xml
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    /* Here is the event handler for the menu button that I forgot in class.
    The value returned by item.getItemID() is
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.admin_login:
                /*the R.id.action_favorite is the ID of our button (defined in strings.xml).
                Change Activity here (if that's what you're intending to do, which is probably is).
                 */
                Intent i = new Intent(this, LogInActivity.class);
                startActivity(i);
            default:
                super.onOptionsItemSelected(item);
        }
        return true;
    }
}
