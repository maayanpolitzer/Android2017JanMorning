package com.example.hackeru.internet;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    // MUST ADD A PERMISSION IN THE MANIFEST!


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.activity_main_text_view);
        ImageView iv = (ImageView) findViewById(R.id.activity_main_image_view);
        final Handler handler = new Handler();

        String imageLink = "http://i.imgur.com/gcJua4G.jpg";

        new DownloadImageThread(handler, iv, imageLink).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://104.199.43.149/StudentsServer/");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream in = connection.getInputStream();
                    int length;
                    byte[] buffer = new byte[1024];
                    final StringBuilder sb = new StringBuilder();
                    while((length = in.read(buffer)) > 0){
                        sb.append(new String(buffer, 0, length));
                    }
                    //System.out.println(sb);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            tv.setText(sb.toString());
                        }
                    });
                } catch (MalformedURLException e) {
                    System.out.println("MalformedURLException CRASH :" + e);
                } catch (IOException e) {
                    System.out.println("IOException CRASH :" + e);
                }
            }
        }).start();


    }
}
