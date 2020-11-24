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

        SQLiteDatabase db = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS events (event_name VARCHAR, date INT(4))");

        db.execSQL("INSERT INTO events(event_name, date) VALUES ('Chernobyl', 1986)");
        db.execSQL("INSERT INTO events(event_name, date) VALUES ('Lincoln Assasination', 1865)");
        db.execSQL("INSERT INTO events(event_name, date) VALUES ('Woodstock', 1969)");

        Cursor c = db.rawQuery("SELECT * FROM events", null);
        int eventNameIndex = c.getColumnIndex("event_name");
        int dateIndex = c.getColumnIndex("date");

        c.moveToFirst();
        while(c != null){
            Log.i("event_name123", c.getString(eventNameIndex));
            Log.i("date123", c.getString(dateIndex));
            c.moveToNext();
        }
    }
}