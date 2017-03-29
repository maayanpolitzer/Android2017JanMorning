package com.example.hackeru.buttonsediting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int EDITOR_ACTIVITY_REQUEST_CODE = 1;

    static final int RESULT_UPDATE = 2;
    static final String NAME = "name";
    static final String BUTTON_TAG = "tag";

    private LinearLayout mainLayout;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.main_layout);

    }

    public void add(View view) {
        Intent intent = new Intent(this, EditorActivity.class);
        startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDITOR_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_CANCELED){
                return;
            }
            String newText = data.getStringExtra(NAME);
            if (resultCode == RESULT_OK) {
                Button btn = new Button(this);
                btn.setTag(++counter);
                btn.setOnClickListener(this);
                btn.setText(newText);
                mainLayout.addView(btn);
            }else if(resultCode == RESULT_UPDATE) {

                int tag = data.getIntExtra(BUTTON_TAG, -1);
                if (tag != -1){
                    Button btn = (Button) mainLayout.findViewWithTag(tag);
                    btn.setText(newText);
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        String text = btn.getText().toString();
        Intent intent = new Intent(this, EditorActivity.class);
        intent.putExtra(BUTTON_TAG, (int) btn.getTag());
        intent.putExtra(NAME, text);
        startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST_CODE);
    }


}
