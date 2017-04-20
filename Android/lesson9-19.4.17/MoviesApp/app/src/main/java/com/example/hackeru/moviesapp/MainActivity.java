package com.example.hackeru.moviesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {


    static final String SEARCH = "agknjdlkgndlfn dln dlh sdnfln";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText searchET = (EditText) findViewById(R.id.activity_main_search_edit_text);
        findViewById(R.id.activity_main_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = searchET.getText().toString().trim();
                if(validate(search)) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra(SEARCH, search);
                    startActivity(intent);
                }else{
                    searchET.setError("WTF???");
                }
            }
        });

    }

    private boolean validate(String str) {
        if (str == null || str.isEmpty()){
            return false;
        }
        return true;
    }

}
