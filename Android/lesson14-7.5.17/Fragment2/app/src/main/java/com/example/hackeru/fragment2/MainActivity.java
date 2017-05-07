package com.example.hackeru.fragment2;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements UpdateTextListener {

    private MyFragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFragment = new MyFragment();

        Bundle bundle = new Bundle();
        bundle.putString("NAME", "Maayan");

        myFragment.setArguments(bundle);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_container_frame_layout, myFragment)
                .commit();

    }

    @Override
    public void updateText(String name) {
        Button btn = (Button) findViewById(R.id.activity_main_button);
        btn.setText(name);
    }

    public void btnClick(View view) {
        myFragment.update("the new moshe");
    }



}
