package com.example.hackeru.finalprojectclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.activitylogin_login_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final String email = "maayanp163@gmail.com";
        final String password = "123";

        final JSONObject object = new JSONObject();
        try {
            object.put("action", "login");
            object.put("email", email);
            object.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                //String obj = "action=login&email=" + email + "&password=" + password;
                String obj = "action=login&email=" + email + "&password=" + password;
                //String obj = "action=register&email=" + email + "&password=" + password;
                System.out.println(obj);
                try {
                    //URL url = new URL("http://10.0.7.49:8083/Whatsapp_war/");
                    URL url = new URL("http://104.199.43.149/Whatsapp_war/"); // must be a SLASH!! (/)
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);
                    con.setDoInput(true);
                    OutputStream out = con.getOutputStream();
                    out.write(obj.getBytes());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while((line = reader.readLine()) != null) {
                        sb.append(line);
                    }
                    Log.d("TAG", sb.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                /*
                try {
                    URL url = new URL("http://104.199.43.149/Whatsapp_war/?name=maayan");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    while((line = reader.readLine()) != null){
                        sb.append(line);
                    }
                    Log.d("TAG", sb.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
            }
        }).start();

    }
}
