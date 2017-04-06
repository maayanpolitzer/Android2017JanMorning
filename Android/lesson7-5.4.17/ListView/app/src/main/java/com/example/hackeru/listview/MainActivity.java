package com.example.hackeru.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private static final int EDITOR_ACTIVITY_ADD_REQUEST_CODE = 1;
    private static final int EDITOR_ACTIVITY_UPDATE_REQUEST_CODE = 2;
    private ArrayList<Person> people;
    private NamesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        people = new ArrayList<>();
        people.add(new Person("A", 31));
        people.add(new Person("B", 30));
        people.add(new Person("C", 3));
        people.add(new Person("D", 3));
        people.add(new Person("E", 3));
        people.add(new Person("F", 3));
        people.add(new Person("G", 3));
        people.add(new Person("H", 3));
        people.add(new Person("I", 3));


        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);

        adapter = new NamesAdapter(
                this,
                people
        );
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void add(View view) {
        Intent intent = new Intent(this, EditorActivity.class);
        startActivityForResult(intent, EDITOR_ACTIVITY_ADD_REQUEST_CODE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        System.out.println(people.get(position));
        Intent intent = new Intent(this, EditorActivity.class);
        intent.putExtra(PERSON, people.get(position));
        intent.putExtra(POSITION, position);
        startActivityForResult(intent, EDITOR_ACTIVITY_UPDATE_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDITOR_ACTIVITY_UPDATE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Person person = (Person) data.getSerializableExtra(PERSON);
                int position = data.getIntExtra(POSITION, -1);
                if (position != -1){
                    people.set(position, person);
                    adapter.notifyDataSetChanged();
                }
            }
        } else if (requestCode == EDITOR_ACTIVITY_ADD_REQUEST_CODE) {
            if (resultCode == RESULT_OK){
                Person person = (Person) data.getSerializableExtra(PERSON);
                people.add(person);
                adapter.notifyDataSetChanged();
            }
        }
    }


}
