package com.maayanpolitzer.whatsapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.maayanpolitzer.whatsapp.connections.RequestThread;
import com.maayanpolitzer.whatsapp.infrastructure.BaseActivity;
import com.maayanpolitzer.whatsapp.login_stuff.LoginActivity;
import com.maayanpolitzer.whatsapp.user_activities.ProfileActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements RequestThread.Callback {

    private int userID;
    private Bundle saveInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.saveInstanceState = savedInstanceState;

        userID = settings.getInt(USER_ID, -1);
        if(userID == -1){
            changeActivity(LoginActivity.class, true);
            return;
        }

        String email = settings.getString(USER_EMAIL, null);
        String password = settings.getString(USER_PASSWORD, null);
        checkUser(RequestThread.RequestAction.LOGIN, email, password);

        // DON'T WRITE HERE MORE STUFF!!! - do it inside onAutoLoginCompleted();


    }

    private void onAutoLoginCompleted(Bundle saveInstanceState) {

    }

    @Override
    public void onSuccess(JSONObject data) {
        try {
            if (userID == data.getInt(USER_ID)){
                onAutoLoginCompleted(saveInstanceState);
            }else {
                changeActivity(LoginActivity.class, true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(String error) {
        changeActivity(LoginActivity.class, true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_main_action_profile:
                changeActivity(ProfileActivity.class, false);
                return true;

            case R.id.menu_main_action_logout:
                editor.clear();
                editor.commit();
                changeActivity(LoginActivity.class, true);
                return true;

            default:
                return false;
        }
    }
}
