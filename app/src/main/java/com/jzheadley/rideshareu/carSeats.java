package com.jzheadley.rideshareu;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.Button;

public class carSeats extends AppCompatActivity implements OnClickListener {
    int myVariable;

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

    public carSeats(int myLovelyVariable) {
        this.myVariable = myLovelyVariable;
    }
    public carSeats(){}

    @Override
    public void onClick(View v)
    {
        Button button = (Button)v;
        button.setText("taken");
        Toast.makeText(getApplicationContext(), "Seat reserved", Toast.LENGTH_LONG).show();
        findViewById(R.id.seat_passenger).setClickable(false);
        findViewById(R.id.seat_2nd_row1).setClickable(false);
        findViewById(R.id.seat_2nd_row2).setClickable(false);
        findViewById(R.id.seat_2nd_row3).setClickable(false);
        findViewById(R.id.seat_3rd_row1).setClickable(false);
        findViewById(R.id.seat_3rd_row2).setClickable(false);
        findViewById(R.id.seat_3rd_row3).setClickable(false);
    }
}
