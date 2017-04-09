package com.example.hackeru.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity implements UpdateListListener {

    private static final String SEARCH_MOVIE_LINK = "http://www.omdbapi.com/?s=";
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String search = getIntent().getStringExtra(MainActivity.SEARCH);
        if (search == null) {
            // problem...
            // TODO: 4/9/2017 hide the progress bar...
            // TODO: 4/9/2017 tell the user about the problem.
            return;
        }

        new SearchMoviesThread(this, SEARCH_MOVIE_LINK + search).start();

        // TODO: 4/9/2017 get listView pointer.
        listview = (ListView) findViewById(R.id.activity_results_list_view);
    }

    @Override
    public void updateList(ArrayList<Movie> movies) {
            // TODO: 4/9/2017 hide the progress bar.

            // TODO: 4/9/2017 create adapter
            //MoviesAdapter adapter = new MoviesAdapter(this, movies);
            ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(
                    this,
                    android.R.layout.simple_list_item_1,
                    movies
            );
            // TODO: 4/9/2017 display
            listview.setAdapter(adapter);
    }

}
