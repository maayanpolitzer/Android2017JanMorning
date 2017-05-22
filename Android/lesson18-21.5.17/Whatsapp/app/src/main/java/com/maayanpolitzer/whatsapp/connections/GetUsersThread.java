package com.maayanpolitzer.whatsapp.connections;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.maayanpolitzer.whatsapp.infrastructure.BaseThread;
import com.maayanpolitzer.whatsapp.infrastructure.DBOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Hackeru on 5/21/2017.
 */

public class GetUsersThread extends BaseThread {

    private int userID;
    private SQLiteDatabase db;
    private Context context;

    public GetUsersThread(Context context, int userID){
        this.context = context;
        this.userID = userID;

        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    @Override
    public void run() {
        HttpURLConnection connection = null;
        try {
            JSONObject data = new JSONObject();
            data.put("action", "GET_USERS");
            data.put("userID", userID);
            URL url = new URL(SERVER_IP);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);

            OutputStream out = connection.getOutputStream();
            out.write(data.toString().getBytes());

            InputStream in = connection.getInputStream();
            StringBuilder sb = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }

            JSONObject object = new JSONObject(sb.toString());

            saveData(object);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void saveData(JSONObject json) throws JSONException {
        JSONArray users = json.getJSONArray("users");
        for (int i = 0; i < users.length(); i++){
            JSONObject user = users.getJSONObject(i);
            String email = user.getString("email");
            int id = user.getInt("userID");
            saveUserToDB(email, id);
        }
        Intent intent = new Intent("99fm");
        context.sendBroadcast(intent);

    }

    private void saveUserToDB(String email, int id){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.UsersTable.COL_ID, id);
        values.put(DBOpenHelper.UsersTable.COL_EMAIL, email);
        db.insert(
                DBOpenHelper.UsersTable.TABLE_NAME,
                null,
                values
        );

    }
}
