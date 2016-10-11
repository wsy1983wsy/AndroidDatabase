package com.wsy.database.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wsy.database.User;

/**
 * Created by songyewang on 16/10/10.
 */

public class UserAO extends BasicAO {
    public enum Table {
        c_user
    }

    public enum UserColumn {
        userId, userName, userAge
    }


    public void saveUser(User user) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(UserColumn.userId.toString(), user.userId);
        cv.put(UserColumn.userName.toString(), user.userName);
        cv.put(UserColumn.userAge.toString(), user.UserAge);
        db.replace(Table.c_user.toString(), null, cv);
        closeDatabase();
    }

    public User getFirstUser() {
        SQLiteDatabase db = getReadableDatabase();
        User user = null;
        String sql = "select * from " + Table.c_user + " order by userAge desc limit 1";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor != null && cursor.moveToFirst()) {
            user = new User(cursor);
            cursor.close();
        }
        return user;
    }
}
