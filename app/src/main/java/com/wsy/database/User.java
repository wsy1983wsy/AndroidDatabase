package com.wsy.database;

import android.database.Cursor;

/**
 * Created by songyewang on 16/10/11.
 */

public class User {
    public String userId;
    public String userName;
    public int UserAge;

    public User() {

    }

    public User(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            return;
        }
        userId = cursor.getString(cursor.getColumnIndex("userId"));
        userName = cursor.getString(cursor.getColumnIndex("userName"));
        UserAge = cursor.getInt(cursor.getColumnIndex("userAge"));
    }

    @Override
    public String toString() {
        return "User{" +
                "UserAge=" + UserAge +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
