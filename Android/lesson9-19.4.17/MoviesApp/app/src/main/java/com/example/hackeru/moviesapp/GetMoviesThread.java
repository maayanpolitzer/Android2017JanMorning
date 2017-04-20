package com.example.hackeru.moviesapp;

import android.os.Handler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by hackeru on 4/19/2017.
 */

public class GetMoviesThread extends Thread {

    private ResultActivity activity;
    private String link;
    private Handler handler;

    public GetMoviesThread(ResultActivity activity, String link) {
        this.activity = activity;
        this.link = link;
        handler = new Handler();
    }

    @Override
    public void run() {
        String data = getDataFromTheInternet();
        if (data != null){
            extractListFromString(data);
        }
    }

    private void extractListFromString(String data) {
        final ArrayList<Movie> movies = new ArrayList<>();
        try {
            JSONObject mainObject = new JSONObject(data);
            if(mainObject.getBoolean("Response")){
                JSONArray arr = mainObject.getJSONArray("Search");
                for (int i = 0; i < arr.length(); i++) {
                    movies.add(new Movie(arr.getJSONObject(i)));
                }
            }else{
                // no results...
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                activity.updateList(movies);
            }
        });

    }

    private String getDataFromTheInternet() {
        HttpURLConnection con = null;
        try {
            URL url = new URL(link);
            con = (HttpURLConnection) url.openConnection();
            InputStream in = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(con != null){
                con.disconnect();
            }
        }
        return null;
    }
}
