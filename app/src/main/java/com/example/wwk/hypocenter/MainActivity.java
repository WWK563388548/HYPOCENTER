package com.example.wwk.hypocenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        earthquakes.add(new Earthquake("7.2", "Peking", "Feb 07, 2017"));
        earthquakes.add(new Earthquake("7.2", "Tokyo", "Feb 07, 2017"));
        earthquakes.add(new Earthquake("7.2", "Paris", "Feb 07, 2017"));
        earthquakes.add(new Earthquake("7.2", "London", "Feb 07, 2017"));
        earthquakes.add(new Earthquake("7.2", "San Francisco", "Feb 07, 2017"));
        earthquakes.add(new Earthquake("7.2", "Mexico City", "Feb 07, 2017"));
        earthquakes.add(new Earthquake("7.2", "Rio de Janeiro", "Feb 07, 2017"));
        earthquakes.add(new Earthquake("7.2", "Moscow", "Feb 07, 2017"));

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

    }
}
