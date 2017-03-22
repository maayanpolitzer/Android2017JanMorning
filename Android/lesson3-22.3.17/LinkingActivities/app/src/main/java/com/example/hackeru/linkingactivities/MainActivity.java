package com.example.hackeru.linkingactivities;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String COUNTER = "counter";
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 1;

    private TextView dataTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("onCreate()");

        final EditText nameET = (EditText) findViewById(R.id.activity_main_name_edit_text);
        dataTV = (TextView) findViewById(R.id.activity_main_data_text_view);
        Button btn = (Button) findViewById(R.id.activity_main_change_activity_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameET.getText().toString();

                // Explicit intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Name", name);
                //startActivity(intent);
                startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);

                // Implicit intent:
                /*
                Uri uri = Uri.parse("http://www.walla.co.il");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                */
                /*
                Uri uri = Uri.parse("tel:051234567890");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
                */
                /*
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
                */
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE){
            // back from SecondActivity
            if (resultCode == RESULT_OK){
                int counter = data.getIntExtra(COUNTER, -1);
                if (counter != -1){
                    dataTV.setText("You clicked " + counter + " times...");
                }else{
                    dataTV.setText("ERROR!!!! counter is -1");
                }
            }else{  // RESUKLT_CANCELED (0)
                dataTV.setText("something starnge... " + resultCode);
            }
        }
    }
}
