package com.example.databasesdemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

        db.execSQL("INSERT INTO users(name, age) VALUES ('Nick', 28)");
        db.execSQL("INSERT INTO users(name, age) VALUES ('Bryan', 37)");

        Cursor c = db.rawQuery("SELECT * FROM users", null);
        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");

        c.moveToFirst();
        while(c != null){
            Log.i("name", c.getString(nameIndex));
            Log.i("age", Integer.toString(c.getInt(ageIndex)));
            c.moveToNext();
        }
    }
}