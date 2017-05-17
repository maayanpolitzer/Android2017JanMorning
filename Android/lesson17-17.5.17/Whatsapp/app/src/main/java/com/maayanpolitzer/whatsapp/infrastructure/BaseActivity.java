package com.maayanpolitzer.whatsapp.infrastructure;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.maayanpolitzer.whatsapp.MainActivity;
import com.maayanpolitzer.whatsapp.connections.RequestThread;
import com.maayanpolitzer.whatsapp.login_stuff.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by maayanpolitzer on 16/05/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements RequestThread.Callback {

    private static final String SHARED_PREFS_FILE_NAME = "prefsFile";

    protected static final String USER_ID = "userID";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PASSWORD = "password";
    protected static final int USER_NOT_EXISTS = -1;
    protected static final int EMAIL_ALREADY_EXISTS = -1;

    protected SharedPreferences settings;
    protected SharedPreferences.Editor editor;

    protected String email;
    protected String password;

    private RequestThread.RequestAction action;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences(SHARED_PREFS_FILE_NAME, MODE_PRIVATE);
        editor = settings.edit();
    }

    protected void checkUser(RequestThread.RequestAction action, String email, String password){
        this.action = action;
        if (email != null && password != null) {
            JSONObject obj = new JSONObject();
            try {
                obj.put(USER_EMAIL, email);
                obj.put(USER_PASSWORD, password);
            } catch (JSONException e) {
                onFailure("Error parsing local jsonObject");
                return;
            }
            new RequestThread(
                    this,
                    RequestThread.RequestMethod.POST,
                    action,
                    obj,
                    this
            ).start();
        }
    }

    protected void changeActivity(Class targetActivity, boolean closeCurrentActivity) {
        startActivity(new Intent(this, targetActivity));
        if (closeCurrentActivity){
            finish();
        }
    }

    @Override
    public void onSuccess(JSONObject data) {
        try {
            int returnedID = data.getInt("userID");
            if (returnedID == USER_NOT_EXISTS) {
                onFailure(action == RequestThread.RequestAction.LOGIN ? "User doesn't exists" : "User already exists");
                return;
            } else {
                // save data to shared Prefs.
                editor.putInt(USER_ID, returnedID);
                editor.putString(USER_EMAIL, email);
                editor.putString(USER_PASSWORD, password);
                editor.commit();

                changeActivity(MainActivity.class, true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
