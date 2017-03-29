package com.example.hackeru.buttonsediting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameET;
    private Button btn;
    private boolean add = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        nameET = (EditText) findViewById(R.id.activity_editor_name_edit_text);
        btn = (Button) findViewById(R.id.activity_editor_button);
        btn.setOnClickListener(this);

        String name = getIntent().getStringExtra(MainActivity.NAME);
        if (name != null) {
            add = false;
            nameET.setText(name);
            btn.setText("update");
        }

    }



    @Override
    public void onClick(View view) {
        String name = nameET.getText().toString();
        if (!name.isEmpty()) {
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NAME, name);
            int tag = getIntent().getIntExtra(MainActivity.BUTTON_TAG, -1);
            intent.putExtra(MainActivity.BUTTON_TAG, tag);
            /*
            if (add){
                // add
                setResult(RESULT_OK, intent);
            }else{
                //update
                setResult(MainActivity.RESULT_UPDATE, intent);
            }
            */
            setResult(add ? RESULT_OK : MainActivity.RESULT_UPDATE, intent);
            finish();
        } else {
            nameET.setError("Cannot be empty!");
        }

    }
}
