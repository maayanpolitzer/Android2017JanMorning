package com.maayanpolitzer.whatsapp.infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by maayanpolitzer on 19/05/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "database.db";
    private static final int DB_VERSION = 1;

    public static class TABLE_USERS {
        public static final String TABLE_NAME = "users";
        public static final String COL_ID = "_id";
        public static final String COL_EMAIL = "email";

        private static final String CREATE_COMMAND = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY, " +
                COL_EMAIL + " TEXT)";
    }

    public static class TABLE_MESSAGES {
        public static final String TABLE_NAME = "messages";
        public static final String COL_ID = "_id";
        public static final String COL_INCOMING = "incoming";
        public static final String COL_MESSAGE = "message";
        public static final String COL_RECIPIENT_ID = "recipient_id";

        private static final String CREATE_COMMAND = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_INCOMING + " INTEGER, " +
                COL_MESSAGE + " + TEXT, " +
                COL_RECIPIENT_ID + " INTEGER)";
    }


    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USERS.CREATE_COMMAND);
        db.execSQL(TABLE_MESSAGES.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
