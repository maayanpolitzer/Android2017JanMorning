package com.example.hackeru.clientsocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DataBackListener {

    private EditText nameET;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_send_button).setOnClickListener(this);
        nameET = (EditText) findViewById(R.id.activity_main_name_edit_text);

    }

    @Override
    public void onClick(View v) {
        if (validate()){
            // TODO: 5/7/2017 send data to server!
            new SendDataThread(this, name).start();
        }
    }

    private boolean validate(){
        name = nameET.getText().toString().trim();
        if (name == null || name.length() < 2){
            return false;
        }
        return true;
    }

    @Override
    public void displayReturnedData(int data){
        Toast.makeText(this, "Message from server: " + data, Toast.LENGTH_SHORT).show();
    }

}
