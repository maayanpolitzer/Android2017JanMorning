package com.example.hackeru.moviesapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

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

public class GetDataRunnable implements Runnable {

    private ResultActivity activity;
    private String link;
    private ImageView imageView;
    private Handler handler;
    private Bitmap bitmap;
    private ArrayList<Movie> movies = new ArrayList<>();

    public GetDataRunnable(ResultActivity activity, String link){
        this.activity = activity;
        this.link = link;
        handler = new Handler();

    }

    public GetDataRunnable(ImageView imageView, String link, Handler handler) {
        this.imageView = imageView;
        this.link = link;
        this.handler = handler;
    }

    private InputStream connect() throws IOException {
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        return con.getInputStream();
    }

    private void downloadData(InputStream in) throws IOException {
        if (imageView == null){
            downloadAndExtractText(in);
        }else{
            downloadImage(in);
        }
    }

    private void downloadImage(InputStream in) {
        bitmap = BitmapFactory.decodeStream(in);
    }

    private void downloadAndExtractText(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        try {
            JSONObject mainObject = new JSONObject(sb.toString());
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
    }

    private void useData(){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (imageView == null){
                    activity.updateList(movies);
                }else{
                    imageView.setImageBitmap(bitmap);
                }
            }
        });

    }

    @Override
    public void run() {
        try {
            InputStream in = connect();
            downloadData(in);
            useData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
