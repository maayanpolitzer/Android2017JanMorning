package com.example.hackeru.complexlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Person[] people = {
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Maayan", "000-0000000"),
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Maayan", "000-0000000"),
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Maayan", "000-0000000"),
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Maayan", "000-0000000"),
            new Person("Irit", "011-1111111"),
            new Person("Itay", "022-2222222"),
            new Person("Bree", "033-3333333")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);
        NamesAdapter adapter = new NamesAdapter(this, people);
        listView.setAdapter(adapter);

    }
}
