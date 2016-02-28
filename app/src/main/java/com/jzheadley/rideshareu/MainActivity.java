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
    //                                             http://191.237.45.19/index.php?U0VMRUNUICogRlJPTSBTZWF0Ow==
    private static final String QUERY_URL = "http://191.237.45.19/index.php?query=";
    String qstr = ("SELECT * FROM `Seat';");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//      System.out.println(Base64.encodeToString(("SELECT * FROM Seat;").getBytes()));
    }

    private void queryBooks(String searchString) {

        // Prepare your search string to be put in a URL
        // It might have reserved characters or something
        String urlString = "";
        urlString = Base64.encodeToString(qstr.getBytes(), Base64.URL_SAFE);

        // Create a client to perform networking
        AsyncHttpClient client = new AsyncHttpClient();

        // Have the client get a JSONArray of data
        // and define how to respond
        client.get(QUERY_URL + urlString,
                new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(JSONObject jsonObject) {
                        try {
                            new JSONObject(jsonObject.toString()).toString(2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void rideList(View veiw) {
        Log.d("RideShareU", "Ride list selected");
//        Intent rideListIntent = new Intent(this,RideList.class);
//        startActivity(rideListIntent);
    }

    public void tripCreation(View view) {
        queryBooks(qstr);

        Log.d("RideShareU", "Trip creation selected");
        Intent tripCreationIntent = new Intent(this, DriverForm.class);
        startActivity(tripCreationIntent);
    }
}
