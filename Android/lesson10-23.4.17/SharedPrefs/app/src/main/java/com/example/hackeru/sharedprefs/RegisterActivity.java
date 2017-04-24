package com.example.hackeru.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET, passET, conPassET;
    private String email, password;

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        emailET = (EditText) findViewById(R.id.activity_register_email_edit_text);
        passET = (EditText) findViewById(R.id.activity_register_password_edit_text);
        conPassET = (EditText) findViewById(R.id.activity_register_con_password_edit_text);

        findViewById(R.id.activity_register_button).setOnClickListener(this);

        settings = getSharedPreferences(getString(R.string.shared_prefs_file_name), MODE_PRIVATE);
        editor = settings.edit();



    }

    @Override
    public void onClick(View v) {
        // register button clicked.
        if(validate()) {
            // save user and password to shared prefs.
            editor.putString("EMAIL", email);
            editor.putString("PASSWORD", password);
            editor.putBoolean("LOGGED_IN", true);
            editor.commit();
            // move to mainActivity
            startActivity(new Intent(this, MainActivity.class));
            // finish
            finish();
        }
    }

    private boolean validate(){
        boolean valid = true;
        email = emailET.getText().toString().trim();
        password = passET.getText().toString();
        String confirmPassword = conPassET.getText().toString();
        if (email == null || email.isEmpty()){
            // validate email using regular expression (regex)!!!
            valid = false;
            emailET.setError("cannot be empty!");
        }
        if (password == null || password.isEmpty()){
            valid = false;
            passET.setError("Cannot be empty");
        }
        if (!confirmPassword.equals(password)){
            valid = false;
            conPassET.setError("Must be the same as password field");
        }
        return valid;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            default:

        }
        return false;
    }
}
