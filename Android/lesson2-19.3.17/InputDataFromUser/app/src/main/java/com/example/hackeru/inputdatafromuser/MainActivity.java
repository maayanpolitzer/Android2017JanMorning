package com.example.hackeru.inputdatafromuser;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hackeru on 19/03/2017.
 */

public class MainActivity extends AppCompatActivity {

    private EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.et);

    }

    public void display(View view) {
        String content = et.getText().toString();
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        et.setText("");

    }
}
