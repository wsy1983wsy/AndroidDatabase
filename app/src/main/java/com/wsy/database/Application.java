package com.wsy.database;


import com.wsy.database.sqlite.DBHelper;
import com.wsy.database.sqlite.DatabaseManager;

/**
 * Created by songyewang on 16/10/11.
 */

public class Application extends android.app.Application {
    private DBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        dbHelper = new DBHelper(this);
        DatabaseManager.initializeInstance(dbHelper);
        //在此处执行一次数据库的初始化或升级操作,由于getWritableDatabase和getReadableDatabase或导致执行onCreate和onUpgrade执行。
        DatabaseManager.getInstance().getWritableDatabase();
        DatabaseManager.getInstance().closeDatabase();
    }

}
