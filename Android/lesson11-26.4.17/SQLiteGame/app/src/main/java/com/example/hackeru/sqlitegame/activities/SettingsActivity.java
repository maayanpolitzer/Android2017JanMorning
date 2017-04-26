package com.example.hackeru.sqlitegame.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hackeru.sqlitegame.R;
import com.example.hackeru.sqlitegame.infrastructure.BaseActivity;

public class SettingsActivity extends BaseActivity implements View.OnClickListener {

    private EditText timerET, countET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        timerET = (EditText) findViewById(R.id.activity_settings_timer_edit_text);
        countET = (EditText) findViewById(R.id.activity_settings_hall_of_fmae_count_edit_text);
        findViewById(R.id.activity_settings_save_button).setOnClickListener(this);

        // get & display data from shared prefs...
        int timer = settings.getInt(SHARED_PREFS_TIMER, 5);
        int count = settings.getInt(SHARED_PREFS_COUNT, 5);
        timerET.setText(String.valueOf(timer));
        countET.setText(String.valueOf(count));

    }

    @Override
    public void onClick(View v) {
        String timerAsString = timerET.getText().toString();
        String countAsString = countET.getText().toString();
        int timer = 0,count = 0;
        try {
            timer = Integer.parseInt(timerAsString);
        }catch (NumberFormatException e) {
            timerET.setError("Cannot be empty");
            return;
        }
        if (timer <= 0 || timer > 7){
            timerET.setError("Please enter a number between 1-7");
            return;
        }
        try{
            count = Integer.parseInt(countAsString);
        }catch(NumberFormatException e) {
            countET.setError("Cannot be empty");
            return;
        }
        if (count <= 0 || count > 5){
            countET.setError("Please enter a number between 1-5");
            return;
        }

        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(SHARED_PREFS_TIMER, timer);
        editor.putInt(SHARED_PREFS_COUNT, count);
        editor.commit();
        finish();
    }
}
