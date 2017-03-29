package com.example.hackeru.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] names = {
            "Maayan", "Irit", "Itay", "Bree",
            "Maayan", "Irit", "Itay", "Bree",
            "Maayan", "Irit", "Itay", "Bree",
            "Maayan", "Irit", "Itay", "Bree"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
        listView.setAdapter(adapter);


    }
}
