package com.example.wwk.hypocenter;

/**
 * Created by wwk on 17/5/8.
 *
 * An {@link Earthquake} object contains information about a single earthquake
 */

public class Earthquake {

    /**
     * magnitude is the magnitude of earthquake
     * location is the city location of earthquake
     * date is the date the earthquake happened
     */
    private String mMagnitude;
    private String mLocation;
    private String mDate;


    /**
     * Constructs a new {@link Earthquake} object
     *
     * @param magnitude is the magnitude of earthquake
     * @param location is the city location of earthquake
     * @param date is the date the earthquake happened
     */
    public Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    // Return the magnitude of earthquake
    public String getmMagnitude() {
        return mMagnitude;
    }

    // Return the location of earthquake
    public String getmLocation() {
        return mLocation;
    }

    // Return the date of earthquake
    public String getmDate() {
        return mDate;
    }
}
