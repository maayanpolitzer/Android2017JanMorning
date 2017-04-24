package com.example.hackeru.sharedprefs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET, passET;
    private CheckBox rememberMeCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = (EditText) findViewById(R.id.activity_login_email_edit_text);
        passET = (EditText) findViewById(R.id.activity_login_password_edit_text);
        //rememberMeCB = (CheckBox) findViewById(R.id.activity_login_remember_me_check_box);

        findViewById(R.id.activity_login_register_text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // register textView clicked.
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        findViewById(R.id.activity_login_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // login button clicked.
        String email = emailET.getText().toString().trim();
        String password = passET.getText().toString();
        if (validate(email, password)) {
            SharedPreferences settings = getSharedPreferences(getString(R.string.shared_prefs_file_name), MODE_PRIVATE);
            if (email.equals(settings.getString("EMAIL", null)) && password.equals(settings.getString("PASSWORD", null))) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("LOGGED_IN", true);
                editor.commit();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return;
            }else{
                Toast.makeText(this, "Who are you stranger...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean validate(String email, String password) {
        boolean valid = true;
        if (email == null || email.isEmpty()){
            // validate email using regular expression (regex)!!!
            valid = false;
            emailET.setError("cannot be empty!");
        }
        if (password == null || password.isEmpty()){
            valid = false;
            passET.setError("Cannot be empty");
        }
        return valid;
    }
}
