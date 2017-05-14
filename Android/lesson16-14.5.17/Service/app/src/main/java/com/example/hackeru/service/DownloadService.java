package com.example.hackeru.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 5/10/2017.
 */

public class DownloadService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

    final String link = intent.getStringExtra("LINK");
    final Handler handler = new Handler();

        new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                URL url = new URL(link);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                InputStream in = con.getInputStream();
                File imageFile = new File(getFilesDir(), "image.jpg");
                FileOutputStream out = new FileOutputStream(imageFile);
                byte[] buffer = new byte[1024];
                int length;
                while((length = in.read(buffer)) != -1){
                    out.write(buffer, 0, length);
                }
                // download ended!!!
                Intent i = new Intent("99fm");
                sendBroadcast(i);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }).start();

        return START_REDELIVER_INTENT;
}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
