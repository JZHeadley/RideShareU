package com.jzheadley.rideshareu;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
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

/*
public void tripCreation(View view) {
        String queryString = "INSERT INTO Trip(`id`, `vehicle`, `driver`, `departureTime`, `returnTime`, `source`, `destination`, `value`) " +
                "VALUES ([value-1],[value-2],[value-3]," + findViewById(R.id.time_et) + "," + findViewById(R.id.returnTime_et) + "," + findViewById(R.id.from_et) +
                "," + findViewById(R.id.destination_et) + "," + findViewById(R.id.money) + "";


        // Create a client to perform networking
        AsyncHttpClient client = new AsyncHttpClient();

        // Have the client get a JSONAdapter of data and define how to respond
        client.post(("http://jzheadley.com/index.php?query=" + urlString.substring(0, urlString.length()) + urlString.substring(urlString.length())), new JsonHttpResponseHandler() {

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
        Log.d("RideShareU", ((EditText) findViewById(R.id.date_et)).getText().toString());
        Log.d("RideShareU", ((EditText) findViewById(R.id.returnDate_et)).getText().toString());
        Log.d("RideShareU", ((EditText) findViewById(R.id.time_et)).getText().toString());
        Log.d("RideShareU", ((EditText) findViewById(R.id.returnTime_et)).getText().toString());
        Log.d("RideShareU", String.valueOf(Integer.parseInt(((EditText) findViewById(R.id.totalSeats)).getText().toString())));
        Log.d("RideShareU", findViewById(R.id.from_et).toString());
        Log.d("RideShareU", findViewById(R.id.destination_et).toString());
    }
    }
    */

    public void tripCreation(View view) throws JSONException {
        String url = "http://191.237.45.19/trip/create/";
        AsyncHttpClient client = new AsyncHttpClient();
        JSONObject jsonParams = new JSONObject();
        StringEntity entity = null;
        jsonParams.put("vehicleId", 99);
        jsonParams.put("driverId", 99);
        jsonParams.put("departureTime", ((EditText) findViewById(R.id.date_et)).getText().toString() + ((EditText) findViewById(R.id.time_et)).getText().toString());
        jsonParams.put("returnTime", ((EditText) findViewById(R.id.returnTime_et)).getText().toString() + ((EditText) findViewById(R.id.returnTime_et)).getText().toString());
        jsonParams.put("source", ((EditText) findViewById(R.id.from_et)).getText().toString());
        jsonParams.put("destination", ((EditText) findViewById(R.id.destination_et)).getText().toString());
        jsonParams.put("value", 99);
        try {
            entity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ResponseHandlerInterface responseHandler = new JsonHttpResponseHandler();
        client.post(getApplicationContext(), url, entity, "application/json", responseHandler);

    }
}