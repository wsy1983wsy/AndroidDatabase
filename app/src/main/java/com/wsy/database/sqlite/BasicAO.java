package com.wsy.database.sqlite;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by songyewang on 16/10/11.
 */

public class BasicAO {
    public SQLiteDatabase getWritableDatabase() {
        return DatabaseManager.getInstance().getWritableDatabase();
    }

    public SQLiteDatabase getReadableDatabase() {
        return DatabaseManager.getInstance().getReadableDatabase();
    }

    public void closeDatabase() {
        DatabaseManager.getInstance().closeDatabase();
    }
}
