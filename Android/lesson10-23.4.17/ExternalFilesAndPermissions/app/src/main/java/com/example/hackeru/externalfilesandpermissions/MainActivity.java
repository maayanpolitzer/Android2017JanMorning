package com.example.hackeru.externalfilesandpermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String WRITE_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, WRITE_PERMISSION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{WRITE_PERMISSION},
                    1
            );
        } else {
            // permission already granted.
            writeToFile("wow.txt", "this is a text :)");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                writeToFile("wow.txt", "this is a text :)");
            }
        }
    }

    private void writeToFile(String fileName, String content){
        File externalFolder = Environment.getExternalStorageDirectory();
        File myFile = new File(externalFolder, fileName);
        try {
            FileOutputStream out = new FileOutputStream(myFile, true);
            out.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
