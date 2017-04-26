package com.example.hackeru.sqlitegame.activities;

import android.os.Bundle;
import android.view.View;

import com.example.hackeru.sqlitegame.R;
import com.example.hackeru.sqlitegame.infrastructure.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_settings_image_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                changeActivity(SettingsActivity.class, false);
            }
        });

        findViewById(R.id.activity_main_start_game_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(GameActivity.class, false);
            }
        });

        findViewById(R.id.activity_main_hall_of_fame_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(HallOfFameActivity.class, false);
            }
        });

    }
}
