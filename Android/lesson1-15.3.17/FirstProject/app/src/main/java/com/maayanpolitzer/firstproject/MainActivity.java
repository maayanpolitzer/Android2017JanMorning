package com.maayanpolitzer.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private int counterA, counterB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        int id = view.getId();
        Button btn = (Button) view;
        if (id == R.id.main_btn) {
            btn.setText("Click me " + ++counterA);
        }else{
            btn.setText("Click me " + ++counterB);
        }
    }

}
