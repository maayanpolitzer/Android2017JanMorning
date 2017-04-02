package com.example.hackeru.listview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Contact[] contacts = {
            new Contact("Maayan", "050", R.drawable.five),
            new Contact("Irit", "051", R.drawable.four),
            new Contact("Itay", "052", R.drawable.nine),
            new Contact("Bree", "053", R.drawable.twelve)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);
        ContactsAdapter adapter = new ContactsAdapter(this, contacts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this, "hi " + contacts[position].getName(), Toast.LENGTH_SHORT).show();
        view.setBackgroundColor(Color.parseColor("#0000ff"));
        contacts[position].setWhiteBackgound(false);
    }
}
