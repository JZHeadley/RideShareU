package com.jzheadley.rideshareu;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class DriverForm extends AppCompatActivity {
    private boolean roundTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.roundTrip_chk);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    findViewById(R.id.returnTripRow).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.returnTripRow).setVisibility(View.INVISIBLE);
                }
                roundTrip = checkBox.isChecked();
            }
        });
    }

    public void timeSelectionDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void datePickerDialog(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                EditText editText = ((EditText) findViewById(R.id.date_et));
                editText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

            }
        }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void datePickerDialog2(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {
                EditText editText = ((EditText) findViewById(R.id.returnDate_et));
                editText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
            }
        }, mYear, mMonth, mDay);
        dpd.show();
    }

    public void timeSelectionDialog2(View view) {
        DialogFragment newFragment = new TimePickerFragment2();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }


    public void tripCreation(View view) {
/*
        Log.d("RideShareU", ((EditText) findViewById(R.id.date_et)).getText().toString());
        Log.d("RideShareU", ((EditText) findViewById(R.id.returnDate_et)).getText().toString());
        Log.d("RideShareU", ((EditText) findViewById(R.id.time_et)).getText().toString());
        Log.d("RideShareU", ((EditText) findViewById(R.id.returnTime_et)).getText().toString());
        Log.d("RideShareU", String.valueOf(Integer.parseInt(((EditText) findViewById(R.id.totalSeats)).getText().toString())));
        Log.d("RideShareU", findViewById(R.id.from_et).toString());
        Log.d("RideShareU", findViewById(R.id.destination_et).toString());
        new Database().setTrip(
                ((EditText) findViewById(R.id.time_et)).getText().toString(), // Departure Time
                ((EditText) findViewById(R.id.date_et)).getText().toString(), // Departure Date
                ((EditText) findViewById(R.id.returnTime_et)).getText().toString(), // Return Time
                ((EditText) findViewById(R.id.returnDate_et)).getText().toString(), // Return Date
                Integer.parseInt(((EditText) findViewById(R.id.totalSeats)).getText().toString()), // Total seats in car
                findViewById(R.id.from_et).toString(), // Source of travel
                findViewById(R.id.destination_et).toString() // Destination of travel
        );
*/
    }
}
