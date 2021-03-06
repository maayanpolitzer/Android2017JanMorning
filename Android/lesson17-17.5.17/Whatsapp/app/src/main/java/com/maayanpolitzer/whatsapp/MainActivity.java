package com.maayanpolitzer.whatsapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.maayanpolitzer.whatsapp.connections.DbConnection;
import com.maayanpolitzer.whatsapp.connections.RequestThread;
import com.maayanpolitzer.whatsapp.infrastructure.BaseActivity;
import com.maayanpolitzer.whatsapp.login_stuff.LoginActivity;
import com.maayanpolitzer.whatsapp.main_screen_stuff.ChatsFragment;
import com.maayanpolitzer.whatsapp.main_screen_stuff.UsersFragments;
import com.maayanpolitzer.whatsapp.main_screen_stuff.ViewPagerAdapter;
import com.maayanpolitzer.whatsapp.main_screen_stuff.profile.ProfileActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements RequestThread.Callback {

    private int userID;
    private Bundle saveInstanceState;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private UsersFragments usersFragments;

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
        tabLayout = (TabLayout) findViewById(R.id.activity_main_tab_layout);
        toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        viewPager = (ViewPager) findViewById(R.id.activity_main_view_pager);

        setSupportActionBar(toolbar);
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);

    }



    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new UsersFragments(), "Users");
        adapter.addFragment(new ChatsFragment(), "Chats");
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DbConnection dbConnection = DbConnection.getInstance(this);
        dbConnection.closeConnection();
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

            case R.id.menu_main_action_refresh:
                usersFragments.getUsers();
                return true;
            default:
                return false;
        }
    }
}
