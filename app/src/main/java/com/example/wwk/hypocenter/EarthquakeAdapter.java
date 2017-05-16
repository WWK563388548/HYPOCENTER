package com.example.wwk.hypocenter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wwk on 17/5/8.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @Nullable ViewGroup parent) {

            // 检查是否已经有可以重用的列表项视图（称为 convertView），
            // 否则，如果 convertView 为 null，则 inflate 一个新列表项布局。
            String primaryLocation;
            String locationOffset;

            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            }

            // Get the {@link Earthquakeclass} object located at this position in the list
            // 在地震列表中的给定位置找到地震
            Earthquake currentEarthquake = getItem(position);

            String originalLocation = currentEarthquake.getmLocation();

            if (originalLocation.contains(LOCATION_SEPARATOR)) {
                String[] parts = originalLocation.split(LOCATION_SEPARATOR);
                locationOffset = parts[0] +LOCATION_SEPARATOR;
                primaryLocation = parts[1];
            } else {
                locationOffset = getContext().getString(R.string.near_the);
                primaryLocation = originalLocation;
            }


            // 找到视图 ID 为 magnitude 的 TextView
            TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);

            // 格式化震级使其显示一位小数
            String formattedMagnitude = formatMagnitude(currentEarthquake.getmMagnitude());

            // 为震级圆圈设置正确的背景颜色。
            // 从 TextView 获取背景，该背景是一个 GradientDrawable。
            GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();
            // 根据当前的地震震级获取相应的背景颜色
            int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
            // 设置震级圆圈的颜色
            magnitudeCircle.setColor(magnitudeColor);

            // 在该 TextView 中显示目前地震的震级
            magTextView.setText(formattedMagnitude);

            TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
            locationOffsetView.setText(locationOffset);

            TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
            primaryLocationView.setText(primaryLocation);

            // 根据地震时间（以毫秒为单位）创建一个新的 Date 对象
            Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

            // 找到视图 ID 为 date 的 TextView
            TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
            // 设置日期字符串的格式（即 "Mar 3, 1984"）
            String formattedDate = formatDate(dateObject);
            // 在该 TextView 中显示目前地震的日期
            dateTextView.setText(formattedDate);

            // 找到视图 ID 为 time 的 TextView
            TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
            // 设置时间字符串的格式（即 "4:30PM"）
            String formattedTime = formatTime(dateObject);
            // 在该 TextView 中显示目前地震的时间
            timeTextView.setText(formattedTime);

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

    /**
     * 返回格式化后仅显示一位小数的震级字符串
     * （如“3.2”）。
     */

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Get right color for display magnitude of earthquake
     *
     * @param magnitude magnitude is the magnitude of earthquake
     * @return Return colors that is matching magnitude
     */

    private int getMagnitudeColor(double magnitude) {

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
