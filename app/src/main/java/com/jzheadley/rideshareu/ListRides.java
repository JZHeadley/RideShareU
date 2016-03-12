package com.jzheadley.rideshareu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;

public class ListRides extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    public String QUERY_URL = "http://jzheadley.com/index.php?query=";
    ListView mainListView;
    JSONAdapter mJSONAdapter;
    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rides);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 10. Create a JSONAdapter for the ListView
        mJSONAdapter = new JSONAdapter(this, getLayoutInflater());
        // Set the ListView to use the ArrayAdapter
        mainListView = (ListView) findViewById(R.id.main_listview);
        mainListView.setAdapter(mJSONAdapter);
        // 2. Access the Button defined in layout XML
        // and listen for it here
        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        // 3. Access the EditText defined in layout XML
        mainEditText = (EditText) findViewById(R.id.main_edittext);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void seats(View view) {
        Intent intent = new Intent(this, carSeats.class);
        startActivity(intent);
    }

    private void queryBooks(String searchString) {

        // Prepare your search string to be put in a URL
        // It might have reserved characters or something
        String urlString = "";
        try {
            urlString = URLEncoder.encode(searchString, "UTF-8");
        } catch (IOException e) {
            System.out.println(e);
        }


        System.out.println("RIGHT HERE    " + urlString);

        // Create a client to perform networking
        AsyncHttpClient client = new AsyncHttpClient();
        // Have the client get a JSONArray of data
        // and define how to respond
        client.get(QUERY_URL + urlString,
                new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(JSONObject jsonObject) {
                        mJSONAdapter.updateData(jsonObject.optJSONArray("docs"));
                    }

                    @Override
                    public void onFailure(int statusCode, Throwable throwable, JSONObject error) {
                        // Display a "Toast" message
                        // to announce the failure
                        Toast.makeText(getApplicationContext(), "Error: " + statusCode + " " + throwable.getMessage(), Toast.LENGTH_LONG).show();

                        // Log error message
                        // to help solve any problems
                        Log.e("omg android", statusCode + " " + throwable.getMessage());
                    }
                });
    }

    @Override
    public void onClick(View v) {
        String uri = mainEditText.toString();
        queryBooks(uri);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
