package com.jzheadley.rideshareu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by jzheadley on 2/27/2016.
 */
public class JSONAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mInflater;
    org.json.JSONArray mJsonArray;

    public JSONAdapter(Context context, LayoutInflater inflater) {
        mContext = context;
        mInflater = inflater;
        this.mJsonArray = new org.json.JSONArray();
        System.out.println("THIS IS THE JSON " + mJsonArray);
    }

    @Override
    public int getCount() {

        return mJsonArray.length();
    }

    @Override
    public Object getItem(int position) {
        return mJsonArray.optJSONObject(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // check if the view already exists
        // if so, no need to inflate and findViewById again!
        if (convertView == null) {

            // Inflate the custom row layout from your XML.
            convertView = mInflater.inflate(R.layout.ride_row, null);

            // create a new "Holder" with subviews
            holder = new ViewHolder();
            holder.fromTextView = (TextView) convertView.findViewById(R.id.from_et);
            holder.destinationTextView = (TextView) convertView.findViewById(R.id.destination_et);

            // hang onto this holder for future recyclage
            convertView.setTag(holder);
        } else {

            // skip all the expensive inflation/findViewById
            // and just get the holder you already made
            holder = (ViewHolder) convertView.getTag();
        }
        // Get the current book's data in JSON form
        JSONObject jsonObject = (JSONObject) getItem(position);

        // Grab the title and author from the JSON
        String source = "";
        String destination = "";
        System.out.print(jsonObject.toString() + "        THIS IS THE JSON");
        if (jsonObject.has("source")) {
            source = jsonObject.optString("source");
        }

        if (jsonObject.has("destination")) {
            destination = jsonObject.optJSONArray("destination").optString(0);
        }

        // Send these Strings to the TextViews for display
        holder.fromTextView.setText(source);
        holder.destinationTextView.setText(destination);
        return convertView;
    }

    public void updateData(JSONArray jsonArray) {
        // update the adapter's dataset
        mJsonArray = jsonArray;
        notifyDataSetChanged();
    }

    // this is used so you only ever have to do
// inflation and finding by ID once ever per View
    private static class ViewHolder {
        public TextView destinationTextView;
        public TextView fromTextView;
    }
}
