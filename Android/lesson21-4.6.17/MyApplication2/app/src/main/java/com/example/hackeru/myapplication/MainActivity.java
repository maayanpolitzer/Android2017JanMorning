package com.example.hackeru.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String COUNTER = "counter";
    private TextView tv;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        if (savedInstanceState != null){
            onRestoreInstanceState(savedInstanceState);
        }
        */

        Log.d("TAG", "onCreate");
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save!!!
        Log.d("TAG", "onSave");
        outState.putInt(COUNTER, counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // retrieve!!!
        Log.d("TAG", "onRestore");

        counter = savedInstanceState.getInt(COUNTER);
        tv.setText(counter + "");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG", "onRestart");
    }

    @Override
    public void onClick(View v) {
        tv.setText(++counter + "");
    }
}
