package com.example.hackeru.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String LEVEL = "level";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        int level = Integer.parseInt(view.getTag().toString());
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(LEVEL, level);
        startActivity(intent);
    }
}
