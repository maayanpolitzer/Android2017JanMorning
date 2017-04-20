package com.example.hackeru.sharedprefs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText emailET, passET;
    private CheckBox rememberMeCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = (EditText) findViewById(R.id.activity_login_email_edit_text);
        passET = (EditText) findViewById(R.id.activity_login_password_edit_text);
        rememberMeCB = (CheckBox) findViewById(R.id.activity_login_remember_me_check_box);

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

    }
}
