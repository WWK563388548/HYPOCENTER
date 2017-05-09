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
    private double mMagnitude;
    private String mLocation;
    private long mTimeInMilliseconds;
    private String mUrl;


    /**
     * 构造一个新的 {@link Earthquake} 对象。
     *
     * @param magnitude 表示地震的震级（大小）
     * @param location 表示地震的城市位置
     * @param timeInMilliseconds 表示地震发生时以毫秒（根据 Epoch）计的时间
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
    }

    // Return the magnitude of earthquake
    public double getmMagnitude() {
        return mMagnitude;
    }

    // Return the location of earthquake
    public String getmLocation() {
        return mLocation;
    }

    // Return the date of earthquake
    public long getmTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    public String getmUrl() {
        return mUrl;
    }
}
