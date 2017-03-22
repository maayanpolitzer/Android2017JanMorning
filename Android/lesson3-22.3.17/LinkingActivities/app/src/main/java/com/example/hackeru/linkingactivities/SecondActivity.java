package com.example.hackeru.linkingactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private int counter;
    private TextView counterTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");    // null
        int age = intent.getIntExtra("numOfChildren", -1);

        TextView nameTV = (TextView) findViewById(R.id.activity_second_name_text_view);
        Button btn = (Button) findViewById(R.id.activity_second_back_button);
        counterTV = (TextView) findViewById(R.id.activity_second_counter_text_view);

        nameTV.setText(name);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra(MainActivity.COUNTER, counter);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void increment(View view) {
        //counter++;
        counterTV.setText(++counter + "");
    }
}
