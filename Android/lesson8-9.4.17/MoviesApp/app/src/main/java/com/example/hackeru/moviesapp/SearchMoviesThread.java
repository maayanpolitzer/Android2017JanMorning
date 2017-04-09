package com.example.hackeru.moviesapp;

import android.os.Handler;

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
 * Created by hackeru on 4/9/2017.
 */

public class SearchMoviesThread extends Thread {

    // TODO: 4/9/2017 get data from the web.
    // TODO: 4/9/2017 extract String to ArrayList/[].
    // TODO: 4/9/2017 return the arrayList to the activity.

    private String search;
    private UpdateListListener listener;
    private Handler handler;

    public SearchMoviesThread(UpdateListListener listener, String search) {
        this.listener = listener;
        this.search = search;
        handler = new Handler();
    }

    @Override
    public void run() {
        final ArrayList<Movie> movies = new ArrayList<>();
        String data = getDataFromTheWeb();

        extractFromData(movies, data);

        handler.post(new Runnable() {
            @Override
            public void run() {
                listener.updateList(movies);
            }
        });
    }

    private void extractFromData(ArrayList<Movie> movies, String data) {
        try {
            JSONObject mainObject = new JSONObject(data);
            JSONArray arr = mainObject.getJSONArray("Search");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                String title = obj.getString("Title");
                int year = obj.getInt("Year");
                String poster = obj.getString("Poster");
                String imdbID = obj.getString("imdbID");
                movies.add(new Movie(title, year, poster, imdbID));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String getDataFromTheWeb() {
        try {
            URL url = new URL(search);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream in = con.getInputStream();
            StringBuilder sb = new StringBuilder();
            /*
            int actuallyRead;
            byte[] buffer = new byte[1024];
            while((actuallyRead = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, actuallyRead));
            }
            */
            String line;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
