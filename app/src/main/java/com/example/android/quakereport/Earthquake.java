package com.example.android.quakereport;

/**
 * Created by Yogesh on 25-11-2016.
 */

public class Earthquake {

    private double magnitude;
    private String location;
    private long timeInMillis;
    private String url;

    public Earthquake(double magnitude, String location, long timeInMillis, String url) {
        this.magnitude = magnitude;
        this.timeInMillis = timeInMillis;
        this.location = location;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }

    public long getTimeInMillis() {
        return timeInMillis;
    }

    public String getUrl() {
        return url;
    }
}
