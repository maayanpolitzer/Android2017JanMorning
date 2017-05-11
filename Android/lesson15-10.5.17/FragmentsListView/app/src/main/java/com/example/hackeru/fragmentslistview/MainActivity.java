package com.example.hackeru.fragmentslistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements UpdateViewListener {

    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (FrameLayout) findViewById(R.id.activity_main_contianer_frame_layout);

    }

    @Override
    public void changeDisplay(Bundle bundle){
        if(container == null) {
            // portrait:
            Intent intent = new Intent(this, PreviewActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            // landscape:
            PreviewFragment fragment = new PreviewFragment();
            fragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.activity_main_contianer_frame_layout, fragment)
                    .commit();
        }
    }

}
