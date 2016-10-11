package com.wsy.database.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wsy.database.sqlite.UserAO.Table;
import com.wsy.database.sqlite.UserAO.UserColumn;

/**
 * Created by songyewang on 16/10/10.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "SQLITE_TEST";
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + Table.c_user + "("
                + UserColumn.userId + " TEXT PRIMARY KEY,"
                + UserColumn.userName + " TEXT,"
                + UserColumn.userAge + " INTEGER"
                + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
