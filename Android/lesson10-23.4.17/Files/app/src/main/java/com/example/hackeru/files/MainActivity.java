package com.example.hackeru.files;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeFile("wow2.txt", "this is my great text...");
        readFromFile("wow2.txt");
    }

    private void readFromFile(String fileName) {
        try {
            FileInputStream in = openFileInput(fileName);
            StringBuilder sb = new StringBuilder();
            byte[] buffer = new byte[1024];
            int length;
            while((length = in.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, length));
            }
            Toast.makeText(this, "The text is: " + sb.toString(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(String fileName, String content) {
        try {
            FileOutputStream myFile = openFileOutput(fileName, MODE_PRIVATE);
            myFile.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
