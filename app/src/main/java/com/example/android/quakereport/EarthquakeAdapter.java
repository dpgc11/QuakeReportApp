package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Yogesh on 25-11-2016.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    public int getMagnitudeColor(double mag) {
        int magnitudeColorResoureId;
        int magFloor = (int) Math.floor(mag);
        switch (magFloor) {
            case (10): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                return magnitudeColorResoureId;
            }
            case (9): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude9);
                return magnitudeColorResoureId;
            }
            case (8): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude8);
                return magnitudeColorResoureId;
            }
            case (7): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude7);
                return magnitudeColorResoureId;
            }
            case (6): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude6);
                return magnitudeColorResoureId;
            }
            case (5): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude5);
                return magnitudeColorResoureId;
            }
            case (4): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude4);
                return magnitudeColorResoureId;
            }
            case (3): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude3);
                return magnitudeColorResoureId;
            }
            case (2): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude2);
                return magnitudeColorResoureId;
            }
            case (1): {
            }
            case (0): {
                magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude1);
                return magnitudeColorResoureId;
            }
            default: {
                return magnitudeColorResoureId = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            }

        }
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentQuake = getItem(position);

        TextView magTextView = (TextView) rootView.findViewById(R.id.mag_textview);
        TextView offsetLocationTextView = (TextView) rootView.findViewById(R.id.offset_location_textview);
        TextView primaryLocationTextView = (TextView) rootView.findViewById(R.id.primary_location_textview);
        TextView dateTextView = (TextView) rootView.findViewById(R.id.date_textview);
        TextView timeTextView = (TextView) rootView.findViewById(R.id.time_textview);

        Date date = new Date(currentQuake.getTimeInMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");

        DecimalFormat magFormat = new DecimalFormat("0.0");
        String mag = magFormat.format(currentQuake.getMagnitude());

        String primaryLocation;
        String locationOffset;
        int loc = currentQuake.getLocation().indexOf("of");

        if (currentQuake.getLocation().contains("of")) {
            primaryLocation = currentQuake.getLocation().substring(loc + 3, currentQuake.getLocation().length());
            locationOffset = currentQuake.getLocation().substring(0, loc + 2);
        } else {
            primaryLocation = currentQuake.getLocation();
            locationOffset = getContext().getString(R.string.near_the);
        }

        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentQuake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        String dateToDisplay = dateFormat.format(date);
        String timeToDisplay = timeFormat.format(date);

        magTextView.setText(mag);
        primaryLocationTextView.setText(primaryLocation);
        offsetLocationTextView.setText(locationOffset);
        dateTextView.setText(dateToDisplay);
        timeTextView.setText(timeToDisplay);

        return rootView;

    }
}
