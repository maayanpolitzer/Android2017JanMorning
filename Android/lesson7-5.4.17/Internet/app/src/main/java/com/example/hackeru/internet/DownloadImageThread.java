package com.example.hackeru.internet;

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
 * Created by hackeru on 4/5/2017.
 */

class DownloadImageThread extends Thread {

    private Handler handler;
    private ImageView iv;
    private String imageLink;

    public DownloadImageThread(Handler handler, ImageView iv, String imageLink) {
        this.handler = handler;
        this.iv = iv;
        this.imageLink = imageLink;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(imageLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            final Bitmap bitmap = BitmapFactory.decodeStream(in);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    iv.setImageBitmap(bitmap);
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
