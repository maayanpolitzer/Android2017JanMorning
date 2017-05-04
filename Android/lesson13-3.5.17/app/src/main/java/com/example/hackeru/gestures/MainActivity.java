package com.example.hackeru.gestures;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private static final int BALL_SIZE = 250;
    private ImageView ball;
    private boolean isPressed;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(BALL_SIZE, BALL_SIZE);

        ball = new ImageView(this);
        ball.setImageResource(R.drawable.ball);
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        mainLayout.addView(ball, params);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(
                        ball.getX() <= event.getX() &&
                        (ball.getX() + BALL_SIZE) >= event.getX() &&
                        ball.getY() <= event.getY() &&
                        (ball.getY() + BALL_SIZE) >= event.getY()){
                    isPressed = true;
                }

                break;
            case MotionEvent.ACTION_MOVE:
                    if(isPressed){
                        ball.setX(event.getX());
                        ball.setY(event.getY());
                    }
                break;
            case MotionEvent.ACTION_UP:
                    if (isPressed){
                        isPressed = false;
                        goToPosition(0,0);
                    }

                break;
        }
        return true;
    }

    private void goToPosition(final float x, final float y) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(ball.getX() > x + 1 || ball.getY() > y + 1){
                    final float tempX = ball.getX() * 0.9f;
                    final float tempY = ball.getY() * 0.9f;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ball.setX(tempX);
                            ball.setY(tempY);
                        }
                    });


                    try {
                        Thread.sleep(16);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
