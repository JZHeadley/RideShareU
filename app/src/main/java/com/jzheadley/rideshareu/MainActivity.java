package com.jzheadley.rideshareu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void rideSearch(View view) {
        Log.d("RideShareU", "Ride search selected");
        Intent rideListIntent = new Intent(this, rideSearch.class);
        startActivity(rideListIntent);
    }

    public void tripCreation(View view) {
        Log.d("RideShareU", "Trip creation selected");
        Intent tripCreationIntent = new Intent(this, DriverForm.class);
        startActivity(tripCreationIntent);
    }

    public void helpScreen(MenuItem item) {
        Log.d("RideShareU", "Help screen selected");
        Intent helpScreenIntent = new Intent(this, newhelpscreen.class);
        startActivity(helpScreenIntent);
    }
}