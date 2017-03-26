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

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Handler handler;

    private Level[] levels = {
            new Level(3,2),
            new Level(4,3),
            new Level(6,4)
    };

    private int clicks;
    private int firstCardTag;
    private ImageView firstCard;

    private int[] images = {
            R.drawable.one, // 0
            R.drawable.one, // 1
            R.drawable.two, // 2
            R.drawable.two, // 3
            R.drawable.three,// 4
            R.drawable.three // 5
    };

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

    @Override
    public void onClick(View view){
        clicks++;
        final ImageView card = (ImageView) view;
        int cardTag = (int) card.getTag();
        card.setImageResource(images[cardTag]);
        if (clicks % 2 == 0){
            // need the check the cards.
            if (images[firstCardTag] == images[cardTag]) {
                //Toast.makeText(this, "WIIIII", Toast.LENGTH_SHORT).show();
                firstCard.setOnClickListener(null); // cancel the click listener.
                card.setOnClickListener(null);  // cancel the click listener.
            }else{
                //Toast.makeText(this, "Not the same", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstCard.setImageResource(R.drawable.card);
                        card.setImageResource(R.drawable.card);
                    }
                }, 1000);
            }
        }else {
            // first card click.
            firstCard = card;
            firstCardTag = cardTag;
        }
    }
}
