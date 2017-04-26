package com.example.hackeru.sqlitegame.infrastructure;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 4/26/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected SharedPreferences settings;
    private static final String PREFS_NAME = "myPrefsFile";
    protected static final String SHARED_PREFS_TIMER = "timer";
    protected static final String SHARED_PREFS_COUNT = "count";
    protected static final String EXTRA_RESULT = "result";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

    }

    protected void changeActivity(Class targetActivity, boolean closeCurrentActivity){
        Intent intent = new Intent(this, targetActivity);
        startActivity(intent);
        if (closeCurrentActivity){
            finish();
        }
    }

}
