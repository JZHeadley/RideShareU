package com.jzheadley.rideshareu;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class rideSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_search);
    }

    public void rideList(View view) {
        //Intent intent = new Intent(this, rideList.class);
        //startActivity(intent);
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
                if (editText.getText().length() != 0) {
                    editText = ((EditText) findViewById(R.id.returnDate_et));
                }
                editText.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

            }
        }, mYear, mMonth, mDay);
        dpd.show();
    }
}
