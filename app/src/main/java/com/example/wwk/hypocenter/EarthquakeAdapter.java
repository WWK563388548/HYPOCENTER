package com.example.wwk.hypocenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by wwk on 17/5/8.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        // 检查是否已经有可以重用的列表项视图（称为 convertView），
        // 否则，如果 convertView 为 null，则 inflate 一个新列表项布局。
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent, false);
        }

        // 在地震列表中的给定位置找到地震
        Earthquake currentEarthquake = getItem(position);

        // 找到视图 ID 为 magnitude 的 TextView
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthquake.getmMagnitude());

        // 找到视图 ID 为 location 的 TextView
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        locationView.setText(currentEarthquake.getmLocation());

        // 根据地震时间（以毫秒为单位）创建一个新的 Date 对象
        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

        /**
         * 找到视图 ID 为 date 的 TextView
         * 设置日期字符串的格式（即 "Mar 3, 1984"）
         * 在该 TextView 中显示目前地震的日期
         */
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        /**
         * 找到视图 ID 为 time 的 TextView
         * 设置时间字符串的格式（即 "4:30PM"）
         * 在该 TextView 中显示目前地震的时间
         */
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    /**
     * 从 Date 对象返回格式化的日期字符串（即 "Mar 3, 1984"）。
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * 从 Date 对象返回格式化的时间字符串（即 "4:30 PM"）。
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
