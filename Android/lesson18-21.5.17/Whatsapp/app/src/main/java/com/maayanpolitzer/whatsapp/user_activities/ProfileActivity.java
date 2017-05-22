package com.maayanpolitzer.whatsapp.user_activities;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.maayanpolitzer.whatsapp.R;
import com.maayanpolitzer.whatsapp.infrastructure.BaseActivity;
import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.io.IOException;

public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private static final int GALLERY_REQUEST_CODE = 1;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private TextView changeAvatarTV;
    private View changeAvatarFrameLayout;
    private EditText emailET;
    private ImageView avatarIV;
    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        changeAvatarTV = (TextView) findViewById(R.id.activity_profile_change_avatar_text_view);
        changeAvatarFrameLayout = findViewById(R.id.activity_profile_change_avatar_frame_layout);
        emailET = (EditText) findViewById(R.id.activity_profile_email_edit_text);
        avatarIV = (ImageView) findViewById(R.id.activity_profile_avatar_image_view);

        emailET.setText(settings.getString(USER_EMAIL, ""));

        View changePasswordET = findViewById(R.id.activity_profile_password_edit_text);
        changePasswordET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialog fragment.
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_profile_action_edit:
                if(!editing) {
                    enableEditing();
                }else{
                    disableEditing();
                }
                return true;
        }
        return false;
    }

    private void enableEditing(){
        editing = !editing;
        changeAvatarTV.setVisibility(View.VISIBLE);
        changeAvatarFrameLayout.setOnClickListener(this);
        emailET.setEnabled(true);
    }

    private void disableEditing(){
        editing = !editing;
        changeAvatarTV.setVisibility(View.INVISIBLE);
        changeAvatarFrameLayout.setOnClickListener(null);
        emailET.setEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }else{
            launchGallery();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                launchGallery();
            }else{
                Snackbar.make(
                        findViewById(R.id.activity_profile_main_relative_layout),
                        "No permission no change image",
                        Snackbar.LENGTH_LONG
                ).show();
            }
        }
    }

    private void launchGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GALLERY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                File f = new File(getFilesDir(), "image.jpg");
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Crop.of(data.getData(), Uri.fromFile(f)).asSquare().start(this);
            }
        }else if(requestCode == Crop.REQUEST_CROP) {
            if(resultCode == RESULT_OK) {
                avatarIV.setImageURI(Crop.getOutput(data));
            }
        }
    }
}
