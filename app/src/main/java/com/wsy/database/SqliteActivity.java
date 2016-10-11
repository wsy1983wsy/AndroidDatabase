package com.wsy.database;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wsy.database.sqlite.UserAO;

/**
 * Created by songyewang on 16/10/10.
 */

public class SqliteActivity extends Activity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_activity);
        textView = (TextView) findViewById(R.id.textView);
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            String info = (String) msg.obj;
            textView.setText(info);
        }
    };

    public void onSaveUserClicked(View view) {
        saveUser();
    }

    public void saveUser() {
        User user = new User();
        long timestamp = System.currentTimeMillis();
        user.userId = timestamp + "";
        user.userName = "Hello: " + timestamp;
        user.UserAge = 10 + (int) (timestamp / 1000000);

        UserAO userAO = new UserAO();
        userAO.saveUser(user);
    }

    public User getUser() {
        UserAO userAO = new UserAO();
        User user = userAO.getFirstUser();
        Log.d("Sqlite", "user: " + user.toString());
        return user;
    }


    public void onGetUserClicked(View view) {
        getUser();
    }

    public void onMultiThreadClicked(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    saveUser();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    User user = getUser();
                    handler.sendMessage(handler.obtainMessage(1, user.toString()));
                }
            }
        }).start();
    }
}
