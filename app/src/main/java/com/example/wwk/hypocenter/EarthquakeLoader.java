package com.example.wwk.hypocenter;

/**
 * Created by wwk on 17/5/9.
 */

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * 通过使用 AsyncTask 执行
 * 给定 URL 的网络请求，加载地震列表。
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    /** 日志消息标签 */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    /** 查询 URL */
    private String mUrl;
    /**
     * 构建新 {@link EarthquakeLoader}。
     *
     * 活动的 @param context
     * 要从中加载数据的 @param url
     */

    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * 位于后台线程上。
     */
    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // 执行网络请求、解析响应和提取地震列表。
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }

}
