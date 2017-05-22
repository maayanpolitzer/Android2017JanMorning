package com.maayanpolitzer.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.maayanpolitzer.whatsapp.connections.GetUsersThread;
import com.maayanpolitzer.whatsapp.connections.RequestThread;
import com.maayanpolitzer.whatsapp.connections.UsersAdapter;
import com.maayanpolitzer.whatsapp.infrastructure.BaseActivity;
import com.maayanpolitzer.whatsapp.infrastructure.DBOpenHelper;
import com.maayanpolitzer.whatsapp.login_stuff.LoginActivity;
import com.maayanpolitzer.whatsapp.user_activities.ProfileActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity implements RequestThread.Callback, AdapterView.OnItemClickListener {

    private int userID;
    private Bundle saveInstanceState;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            displayUsers();
        }
    };
    private ListView listView;
    private UsersAdapter adapter;
    private SQLiteDatabase db;

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
        new GetUsersThread(this, userID).start();
        listView = (ListView) findViewById(R.id.activity_main_list_view);
        adapter = new UsersAdapter(this, null);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        DBOpenHelper helper = new DBOpenHelper(this);
        db = helper.getReadableDatabase();
        /*
        GetUsersThread t = new GetUsersThread(this, userID);
        t.start();
        try {
            t.join();   // waits until the run() to end!
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("99fm"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    private void displayUsers(){
        adapter.changeCursor(db.query(DBOpenHelper.UsersTable.TABLE_NAME, null,null,null,null,null,null));  // SELECT * FROM users
        //adapter.changeCursor(db.rawQuery("SELECT * FROM " + DBOpenHelper.UsersTable.TABLE_NAME, null));
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("TAG", "position: " + position + ", id: " + id);
    }
}
