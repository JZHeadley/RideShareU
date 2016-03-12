package com.jzheadley.rideshareu;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by zephy on 2/28/2016.
 */
public class DetailActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tell the activity which XML layout is right
        // setContentView(R.layout.activity_detail);

        // Enable the "Up" button for more navigation options
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
