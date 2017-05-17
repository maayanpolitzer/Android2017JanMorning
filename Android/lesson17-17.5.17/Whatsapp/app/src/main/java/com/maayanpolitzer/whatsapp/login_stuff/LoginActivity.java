package com.maayanpolitzer.whatsapp.login_stuff;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;

import com.maayanpolitzer.whatsapp.MainActivity;
import com.maayanpolitzer.whatsapp.R;
import com.maayanpolitzer.whatsapp.connections.RequestThread;
import com.maayanpolitzer.whatsapp.infrastructure.BaseActivity;
import com.maayanpolitzer.whatsapp.infrastructure.Validation;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BaseActivity {

    private EditText emailET;
    private EditText passwordET;
    private View wrapperLayout;

    private View.OnClickListener loginButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            email = Validation.validateEmail(LoginActivity.this, emailET);
            password = Validation.validatePassword(LoginActivity.this, passwordET);
            checkUser(RequestThread.RequestAction.LOGIN, email, password);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = (EditText) findViewById(R.id.activity_login_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_login_password_edit_text);
        wrapperLayout = findViewById(R.id.activity_login_coordinator_layout);

        findViewById(R.id.activity_login_button).setOnClickListener(loginButtonClick);

        findViewById(R.id.activity_login_register_link_text_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(RegisterActivity.class, true);
            }
        });

    }

    @Override
    public void onFailure(String error) {
        Snackbar message = Snackbar.make(wrapperLayout, error, Snackbar.LENGTH_LONG);
        if (error.equals("User doesn't exists")){
            message.setAction("Try register", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeActivity(RegisterActivity.class, true);
                }
            });
        }
        message.show();
    }
}
