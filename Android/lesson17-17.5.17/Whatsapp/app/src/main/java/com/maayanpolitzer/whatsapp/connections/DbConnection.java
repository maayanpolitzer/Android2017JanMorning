package com.maayanpolitzer.whatsapp.connections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.maayanpolitzer.whatsapp.infrastructure.DBOpenHelper;
import com.maayanpolitzer.whatsapp.infrastructure.Message;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maayanpolitzer on 19/05/2017.
 */

public class DbConnection {

    private static DbConnection instance;
    private SQLiteDatabase db;
    private Context context;

    public static DbConnection getInstance(Context context) {
        if (instance == null){
            instance = new DbConnection(context);
        }
        return instance;
    }

    private DbConnection(Context context){
         this.context = context;
    }

    private void openConnection(){
        if (db == null || !db.isOpen());
        db = new DBOpenHelper(context).getWritableDatabase();
    }

    public void closeConnection(){
        if (db != null && db.isOpen()){
            db.close();
            db = null;
        }
    }

    public Cursor getUsers(){
        openConnection();
        return db.query(
                DBOpenHelper.TABLE_USERS.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public List<Message> getMessages(long userID){
        openConnection();
        Cursor cursor = db.query(
            DBOpenHelper.TABLE_MESSAGES.TABLE_NAME,
                new String[]{DBOpenHelper.TABLE_MESSAGES.COL_INCOMING, DBOpenHelper.TABLE_MESSAGES.COL_MESSAGE},
                DBOpenHelper.TABLE_MESSAGES.COL_RECIPIENT_ID + "=?",
                new String[]{String.valueOf(userID)},
                null,
                null,
                null
        );
        List<Message> messages = new ArrayList<>();
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int incoming = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.TABLE_MESSAGES.COL_INCOMING));
                String message = cursor.getString(cursor.getColumnIndex(DBOpenHelper.TABLE_MESSAGES.COL_MESSAGE));
                messages.add(new Message(incoming == 1, message));
            }while(cursor.moveToNext());
        }
        closeConnection();
        return messages;
    }

    public void deleteUsers(){
        openConnection();
        db.delete(DBOpenHelper.TABLE_USERS.TABLE_NAME, null, null);
        closeConnection();
    }

    public void addMessage(JSONObject object, int incoming) throws JSONException {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.TABLE_MESSAGES.COL_INCOMING, incoming);
        values.put(DBOpenHelper.TABLE_MESSAGES.COL_MESSAGE, object.getString("message"));
        values.put(DBOpenHelper.TABLE_MESSAGES.COL_RECIPIENT_ID, object.getInt("userID"));
        openConnection();
        db.insert(
                DBOpenHelper.TABLE_MESSAGES.TABLE_NAME,
                null,
                values
        );
        closeConnection();
    }

}
