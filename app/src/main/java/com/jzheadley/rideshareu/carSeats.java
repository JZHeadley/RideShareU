package com.jzheadley.rideshareu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class carSeats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_seats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void numSeats(int seats)
    {
        if(seats == 5)
        {
            findViewById(R.id.seat_2nd_row2).setVisibility(View.VISIBLE);
            findViewById(R.id.seat_3rd_row1).setVisibility(View.INVISIBLE);
            findViewById(R.id.seat_3rd_row2).setVisibility(View.INVISIBLE);
            findViewById(R.id.seat_3rd_row3).setVisibility(View.INVISIBLE);
        }
        else if(seats == 7)
        {
            findViewById(R.id.seat_2nd_row2).setVisibility(View.INVISIBLE);
            findViewById(R.id.seat_3rd_row1).setVisibility(View.VISIBLE);
            findViewById(R.id.seat_3rd_row2).setVisibility(View.VISIBLE);
            findViewById(R.id.seat_3rd_row3).setVisibility(View.VISIBLE);
        }
        else if (seats == 8)
        {
            findViewById(R.id.seat_2nd_row2).setVisibility(View.VISIBLE);
            findViewById(R.id.seat_3rd_row1).setVisibility(View.VISIBLE);
            findViewById(R.id.seat_3rd_row2).setVisibility(View.VISIBLE);
            findViewById(R.id.seat_3rd_row3).setVisibility(View.VISIBLE);
        }
        else
            Toast.makeText(getApplicationContext(), "Get a less shitty car", Toast.LENGTH_LONG).show();
    }
}
