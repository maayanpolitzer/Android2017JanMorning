package com.example.hackeru.changingimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int[] images = {
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.last
    };
    private int counter;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        imageView.setImageResource(images[counter++]);
        if (counter == images.length) {
            counter = 0;
        }
    }

}
