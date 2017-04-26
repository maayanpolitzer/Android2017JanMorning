package com.example.hackeru.sqlitegame.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hackeru.sqlitegame.R;
import com.example.hackeru.sqlitegame.infrastructure.BaseActivity;

public class EndActivity extends BaseActivity implements View.OnClickListener {

    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView resultTV = (TextView) findViewById(R.id.activity_end_result_text_viwe);
        nameET = (EditText) findViewById(R.id.activity_end_name_edit_text);
        findViewById(R.id.activity_end_save_button).setOnClickListener(this);

        int result = getIntent().getIntExtra(EXTRA_RESULT, -1);
        int timer = settings.getInt(SHARED_PREFS_TIMER, -1);

        resultTV.setText("Your result is\n" + result + "\nin " + timer + " seconds.");

    }

    @Override
    public void onClick(View v) {
        String name = nameET.getText().toString().trim();
        if (name == null || name.isEmpty()) {
            nameET.setError("cannot be empty");
            return;
        }

    }
}
