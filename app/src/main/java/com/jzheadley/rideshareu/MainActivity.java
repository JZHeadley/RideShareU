package com.jzheadley.rideshareu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    JSONAdapter mJSONAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public String QUERY_URL = "http://jzheadley.com/index.php?query=";

    public void queryDataBase(String queryString) {
        // Prepare your search string to be put in a URL It might have reserved characters or something
        String urlString = Base64.encodeToString(queryString.getBytes(), Base64.DEFAULT).trim();
        Log.d("FUCKUP", "'" + urlString + "'");

        // Create a client to perform networking
        AsyncHttpClient client = new AsyncHttpClient();

        // Have the client get a JSONAdapter of data and define how to respond
        client.get((QUERY_URL + urlString), new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(JSONObject jsonObject) {
                try {
                    Log.d("ITWORKED", new JSONObject(jsonObject.toString()).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                Log.wtf("fuckup", "seriously?");
            }
        });
    }
}