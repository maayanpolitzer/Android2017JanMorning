package com.example.hackeru.moviesapp;

/**
 * Created by hackeru on 4/9/2017.
 */

public class Movie {

    private String title, poster, imdbId;
    private int year;

    public Movie(String title, int year, String poster, String imdbId) {
        this.title = title;
        this.poster = poster;
        this.imdbId = imdbId;
        this.year = year;
    }

    @Override
    public String toString() {
        return title;
    }
}
