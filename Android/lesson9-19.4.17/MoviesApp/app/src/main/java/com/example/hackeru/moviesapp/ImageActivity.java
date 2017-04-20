package com.example.hackeru.moviesapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();

        ImageView imageView = new ImageView(this);

        String imageLink = getIntent().getStringExtra("IMAGE");
        if (imageLink == null){
            finish();
            return;
        }

        new Thread(new GetDataRunnable(imageView, imageLink, new Handler())).start();

        setContentView(imageView);


    }
}
