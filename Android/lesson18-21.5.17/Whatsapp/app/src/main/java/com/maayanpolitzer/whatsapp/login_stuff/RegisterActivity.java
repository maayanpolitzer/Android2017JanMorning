package com.maayanpolitzer.whatsapp.login_stuff;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.maayanpolitzer.whatsapp.R;
import com.maayanpolitzer.whatsapp.connections.RequestThread;
import com.maayanpolitzer.whatsapp.infrastructure.BaseActivity;
import com.maayanpolitzer.whatsapp.infrastructure.Validation;

import org.json.JSONObject;

public class RegisterActivity extends BaseActivity {

    private EditText emailET;
    private EditText passwordET;
    private EditText confirmPasswordET;

    private View.OnClickListener registerBtnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            email = Validation.validateEmail(RegisterActivity.this, emailET);
            password = Validation.validatePassword(RegisterActivity.this, passwordET);
            String confirmPassword = confirmPasswordET.getText().toString();
            if (password.equals(confirmPassword)) {
                checkUser(RequestThread.RequestAction.REGISTER, email, password);
            } else {
                confirmPasswordET.setError(getString(R.string.confirm_password_error_message));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailET = (EditText) findViewById(R.id.activity_register_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_register_password_edit_text);
        confirmPasswordET = (EditText) findViewById(R.id.activity_register_confirm_password_edit_text);

        findViewById(R.id.activity_register_button).setOnClickListener(registerBtnClick);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                changeActivity(LoginActivity.class, true);
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onFailure(String error) {

    }
}
