package com.example.hackeru.sqlitegame.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hackeru.sqlitegame.R;
import com.example.hackeru.sqlitegame.infrastructure.BaseActivity;

public class GameActivity extends BaseActivity implements View.OnClickListener {

    private boolean working;
    private Button startBtn;
    private int counter;
    private TextView timeTV;
    private int timer;
    private Handler handler;
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        handler = new Handler();

        startBtn = (Button) findViewById(R.id.activity_game_start_button);
        startBtn.setOnClickListener(this);

        timeTV = (TextView) findViewById(R.id.activity_game_timer_text_view);
        timer = settings.getInt(SHARED_PREFS_TIMER, 5);
        changeTimerText(timer);

    }

    private void changeTimerText(int t){
        if (t > 0) {
            timeTV.setText(String.valueOf(t));
        }else{
            // gameOver...
            Intent intent = new Intent(this, EndActivity.class);
            intent.putExtra(EXTRA_RESULT, counter);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        if (!working){  // the same as: if(working == false){
            working = true;
            startBtn.setText("Click");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    /*
                    for (i = timer; i >= 0; i--){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                changeTimerText(i);
                            }
                        });
                    }
                    */
                    while(timer >= 0){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                changeTimerText(timer);
                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        timer--;
                    }
                }
            }).start();
        }else{
            counter++;
        }
    }
}
