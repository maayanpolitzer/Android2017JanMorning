package com.example.hackeru.moviesapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hackeru on 4/19/2017.
 */

public class ResultActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String LINK = "http://www.omdbapi.com/?type=movie&s=";
    private View progressBar;
    private ListView listView;
    private View emptyView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String search = getIntent().getStringExtra(MainActivity.SEARCH);
        if (search != null) {
            search = search.replace(' ', '+');
            //new GetMoviesThread(this, LINK + search).start();
            new Thread(new GetDataRunnable(this, LINK + search)).start();
        }else{
            finish();
            return;
        }

        listView = (ListView) findViewById(R.id.activity_result_list_view);
        emptyView = findViewById(R.id.activity_result_empty_list_text_view);
        progressBar = findViewById(R.id.activity_result_progress_bar);

    }

    public void updateList(ArrayList<Movie> movies){
        MoviesAdapter adapter = new MoviesAdapter(this, movies);

        if (movies.isEmpty()){
            emptyView.setVisibility(View.VISIBLE);
        }

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("Maayan", "onItemClick() " + position);
    }
}
