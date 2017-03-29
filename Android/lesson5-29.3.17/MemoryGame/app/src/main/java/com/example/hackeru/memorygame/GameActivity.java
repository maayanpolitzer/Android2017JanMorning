package com.example.hackeru.memorygame;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler handler;

    private Level[] levels = {
            new Level(3,2),
            new Level(4,3),
            new Level(6,4)
    };

    private int clicks;
    private int firstCardTag = -1;
    private ImageView firstCard;
    private boolean working;

    private int[] cards = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten,
            R.drawable.eleven,
            R.drawable.twelve
    };

    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        handler = new Handler();

        getSupportActionBar().hide();   // hides the action bar.
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // hides the status bar.

        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_game_layout);

        LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
        LinearLayout.LayoutParams colParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);

        int level = getIntent().getIntExtra(MainActivity.LEVEL, -1);

        initImages(level);

        int counter = 0;

        // create views programmatically.
        for (int i = 0; i < levels[level].getRows(); i++) {
            LinearLayout row = new LinearLayout(this);
            //row.setOrientation(LinearLayout.HORIZONTAL);  // default value...
            for (int j = 0; j < levels[level].getCols(); j++) {
                ImageView image = new ImageView(this);
                image.setTag(counter++);
                image.setOnClickListener(this);
                image.setImageResource(R.drawable.card);
                row.addView(image, colParams);
            }
            layout.addView(row, rowParams);
        }
    }

    private void initImages(int level){
        images = new int[levels[level].getNumberOfCards()];
        /*
        ArrayList<Integer> images2 = new ArrayList<>();
        for (int i = 0; i < levels[level].getNumberOfCards() / 2; i++){
            images2.add(cards[i]);
            images2.add(cards[i]);
        }
        Collections.shuffle(images2);
        */
        int counter = 0;
        for (int i = 0; i < images.length; i += 2){
            images[i] = cards[counter];
            images[i+1] = cards[counter++];
        }
        int temp;
        Random r = new Random();
        for (int i = 0; i < images.length; i++){
            int random = r.nextInt(images.length);
            temp = images[i];
            images[i] = images[random];
            images[random] = temp;
        }
    }

    @Override
    public void onClick(View view){
        if (!working) {
            final ImageView card = (ImageView) view;
            int cardTag = (int) card.getTag();
            if (firstCardTag != cardTag) {
                clicks++;
                card.setImageResource(images[cardTag]);
                if (clicks % 2 == 0) {
                    // need the check the cards.
                    if (images[firstCardTag] == images[cardTag]) {
                        //Toast.makeText(this, "WIIIII", Toast.LENGTH_SHORT).show();
                        firstCard.setOnClickListener(null); // cancel the click listener.
                        card.setOnClickListener(null);  // cancel the click listener.
                    } else {
                        //Toast.makeText(this, "Not the same", Toast.LENGTH_SHORT).show();
                        working = true;
                        firstCardTag = -1;
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                firstCard.setImageResource(R.drawable.card);
                                card.setImageResource(R.drawable.card);
                                working = false;
                            }
                        }, 1000);
                    }
                } else {
                    // first card click.
                    firstCard = card;
                    firstCardTag = cardTag;
                }
            }
        }
    }
}
