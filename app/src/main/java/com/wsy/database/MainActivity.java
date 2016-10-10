package com.wsy.database;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSqliteClicked(View view) {
        Intent intent = new Intent(this,SqliteActivity.class);
        startActivity(intent);
    }

    public void onRealmClicked(View view) {
        Intent intent = new Intent(this,RealmActivity.class);
        startActivity(intent);
    }
}
