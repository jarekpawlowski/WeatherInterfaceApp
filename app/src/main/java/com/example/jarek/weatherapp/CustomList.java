package com.example.jarek.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jarek on 02.01.2017.
 */

public class CustomList extends ArrayAdapter<String> {
    private final Context context;
    private final String[] web;

    public CustomList(Context context,
                      String[] web) {
        super(context, R.layout.list_single_row, web);
        this.context = context;
        this.web = web;


    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView= inflater.inflate(R.layout.list_single_row, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);

        imageView.setImageResource(R.drawable.photoweather);
        return rowView;
    }
}
