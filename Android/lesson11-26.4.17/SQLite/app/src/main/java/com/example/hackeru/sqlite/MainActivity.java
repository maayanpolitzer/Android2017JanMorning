package com.example.hackeru.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBOpenHelper helper = new DBOpenHelper(this);

        db = helper.getWritableDatabase();

        Cursor cursor = db.query(
                DBOpenHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if(cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COL_NAME));
                int age = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COL_AGE));
                double height = cursor.getDouble(cursor.getColumnIndex(DBOpenHelper.COL_HEIGHT));
                Log.d("Maayan", name + ", " + age + ", " + height);
            } while (cursor.moveToNext());
        }
    }

    private void getAge(int id){
        Cursor cursor = db.query(
                DBOpenHelper.TABLE_NAME,
                //new String[]{DBOpenHelper.COL_AGE},
                null,
                DBOpenHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );
        Log.d("Maayan", cursor.getCount() + "");
    }

    private void updateNameAndHeight(int id, String name, double height) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COL_NAME, name);
        values.put(DBOpenHelper.COL_HEIGHT, height);
        db.update(
                DBOpenHelper.TABLE_NAME,
                values,
                DBOpenHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)}
        );
    }

    private void insertData(String name, int age, double height){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COL_NAME, name);
        values.put(DBOpenHelper.COL_AGE, age);
        values.put(DBOpenHelper.COL_HEIGHT, height);
        db.insert(
                DBOpenHelper.TABLE_NAME,
                null,
                values
                );
    }
}
