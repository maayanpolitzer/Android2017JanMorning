package com.example.hackeru.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences settings = getSharedPreferences(getString(R.string.shared_prefs_file_name), MODE_PRIVATE);

        if(!settings.getBoolean("LOGGED_IN", false)) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        findViewById(R.id.activity_main_logout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("LOGGED_IN", false);
                Log.d("Maayan", editor.commit() + "");
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                return;
            }
        });

        String email = settings.getString("EMAIL", null);
        if (email != null){
            TextView emailTV = (TextView) findViewById(R.id.activity_main_email_text_view);
            emailTV.setText("Hi " + email);
        }

    }


}
