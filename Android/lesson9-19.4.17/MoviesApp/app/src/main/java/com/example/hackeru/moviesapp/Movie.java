package com.example.hackeru.moviesapp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 4/19/2017.
 */

public class Movie {

    private String title, imdbID, poster;
    private int year;

    public Movie(JSONObject obj) throws JSONException {
        title = obj.getString("Title");
        imdbID = obj.getString("imdbID");
        poster = obj.getString("Poster");
        year = obj.getInt("Year");
    }

    public String getTitle() {
        return title;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getPoster() {
        return poster;
    }

    public int getYear() {
        return year;
    }
}
