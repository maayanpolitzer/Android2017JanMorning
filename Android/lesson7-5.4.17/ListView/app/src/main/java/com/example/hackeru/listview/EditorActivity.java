package com.example.hackeru.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class EditorActivity extends BaseActivity implements View.OnClickListener {

    private EditText nameET, ageET;
    private boolean addNewPerson = true;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Button btn = (Button) findViewById(R.id.activity_editor_save_button);
        nameET = (EditText) findViewById(R.id.activity_editor_name_edit_text);
        ageET = (EditText) findViewById(R.id.activity_editor_age_edit_text);

        btn.setOnClickListener(this);

        person = (Person) getIntent().getSerializableExtra(PERSON);

        if (person != null){
            System.out.println(person);
            addNewPerson = false;
            btn.setText("Update");
            nameET.setText(person.getName());
            ageET.setText(String.valueOf(person.getAge()));
        }

    }

    @Override
    public void onClick(View v) {
        String name = nameET.getText().toString().trim();
        String ageAsString = ageET.getText().toString().trim();
        int age = -1;
        if (name.isEmpty()){
            nameET.setError("Cannot be empty.");
            return;
        }
        if (ageAsString.isEmpty()){
            ageET.setError("Cannot be empty");
            return;
        }
        try {
            age = Integer.parseInt(ageAsString);
        }catch (Exception e){
            ageET.setError("What?????????");
        }
        if (age != -1) {
            Intent intent = new Intent();
            if (!addNewPerson) {
                person.setName(name);
                person.setAge(age);
                intent.putExtra(PERSON, person);
                intent.putExtra(POSITION, getIntent().getIntExtra(POSITION, -1));
            }else{
                intent.putExtra(PERSON, new Person(name, age));
            }
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
