package com.example.hackeru.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String link = "{\"Name\":\"Maayan\", \"age\":65, \"Family\":[" +
            "{\"Name\":\"Irit\"},{\"Name\":\"Itay\"}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject obj = new JSONObject(link);
            //System.out.println(obj.getString("Name"));
            //System.out.println(obj.getInt("age"));
            JSONArray arr = obj.getJSONArray("Family");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                System.out.println(o.getString("Name"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
