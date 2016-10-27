package com.wsy.database.realm;

import android.text.TextUtils;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by songyewang on 16/10/11.
 */

public class RealmUser extends RealmObject {
    public String userName;
    private int userAge;
    @PrimaryKey
    private String userId;

    @Ignore
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean hasLongName() {
        return TextUtils.isEmpty(userName) ? false : userName.length() > 10;
    }

    @Override
    public String toString() {
        return "RealmUser{" +
                "userAge=" + userAge +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
