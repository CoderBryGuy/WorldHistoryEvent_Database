package com.example.worldhistoryevent_database;

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
        db.execSQL("CREATE TABLE IF NOT EXISTS theNewUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");

        db.execSQL("INSERT INTO theNewUsers(name, age) VALUES ('Nick', 28)");
        db.execSQL("INSERT INTO theNewUsers(name, age) VALUES ('Bryan', 37)");
        db.execSQL("INSERT INTO theNewUsers(name, age) VALUES ('Bryan', 27)");
        db.execSQL("INSERT INTO theNewUsers(name, age) VALUES ('Omer', 18)");
        db.execSQL("INSERT INTO theNewUsers(name, age) VALUES ('uval', 16)");

        db.execSQL("DELETE FROM theNewUsers WHERE id = 10");

//        Cursor c = db.rawQuery("SELECT * FROM users where name = 'Bryan' AND age = 37", null);
//        Cursor c = db.rawQuery("SELECT * FROM users WHERE name LIKE '%a%' LIMIT 1", null);
        Cursor c = db.rawQuery("SELECT * FROM theNewUsers", null);
        int nameIndex = c.getColumnIndex("name");
        int ageIndex = c.getColumnIndex("age");
        int primeKeyIndex = c.getColumnIndex("id");

        c.moveToFirst();
        while(!c.isAfterLast()){
            Log.i("name123", " " + c.getInt(primeKeyIndex)+ ": " + c.getString(nameIndex) + " aged: " + Integer.toString(c.getInt(ageIndex)));

            c.moveToNext();
        }
    }
}
