package com.jzheadley.rideshareu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
            ((Button) findViewById(R.id.seat_2nd_row2)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row1)).setVisibility(View.INVISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row2)).setVisibility(View.INVISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row3)).setVisibility(View.INVISIBLE);
        }
        else if(seats == 7)
        {
            ((Button) findViewById(R.id.seat_2nd_row2)).setVisibility(View.INVISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row1)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row2)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row3)).setVisibility(View.VISIBLE);
        }
        else if (seats == 8)
        {
            ((Button) findViewById(R.id.seat_2nd_row2)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row1)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row2)).setVisibility(View.VISIBLE);
            ((Button) findViewById(R.id.seat_3rd_row3)).setVisibility(View.VISIBLE);
        }
        else
            Toast.makeText(getApplicationContext(), "Get a less shitty car", Toast.LENGTH_LONG).show();
    }
}
