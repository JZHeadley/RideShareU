package com.jzheadley.rideshareu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.json.JSONArray;

/**
 * Created by jzheadley on 2/27/2016.
 */
public class SQLQueryAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater mInflater;
    JSONArray mJsonArray;

    public SQLQueryAdapter(Context context, LayoutInflater inflater) {
        mContext = context;
        mInflater = inflater;

    }

    @Override
    public int getCount() {
        // Return number of elements from SELECT statement
        return 0;
    }

    @Override
    public Object getItem(int position) {
        //Returns the nth element.
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
