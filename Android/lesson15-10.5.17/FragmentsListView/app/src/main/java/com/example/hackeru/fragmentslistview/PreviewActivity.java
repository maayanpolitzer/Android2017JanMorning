package com.example.hackeru.fragmentslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PreviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        PreviewFragment fragment = new PreviewFragment();

        fragment.setArguments(getIntent().getExtras());

        getFragmentManager()
                .beginTransaction()
                .add(R.id.activity_preview_container_frame_layout, fragment)
                .commit();

    }
}
