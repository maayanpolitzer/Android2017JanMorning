package com.example.hackeru.moviesapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 4/19/2017.
 */

public class DownloadImageThread extends Thread {

    private ImageView imageView;
    private String link;
    private Handler handler;

    public DownloadImageThread(ImageView imageView, String link, Handler handler) {
        this.imageView = imageView;
        this.link = link;
        this.handler = handler;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(link);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream in = con.getInputStream();
            final Bitmap bitmap = BitmapFactory.decodeStream(in);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(bitmap);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}












