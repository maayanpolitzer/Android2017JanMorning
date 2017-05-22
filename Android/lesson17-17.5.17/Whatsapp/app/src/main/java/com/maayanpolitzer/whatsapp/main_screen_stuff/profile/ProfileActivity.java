package com.maayanpolitzer.whatsapp.main_screen_stuff.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.maayanpolitzer.whatsapp.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        EditText changePasswordET = (EditText) findViewById(R.id.activity_profile_password_edit_text);



        changePasswordET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialog fragment.
            }
        });

    }
}
