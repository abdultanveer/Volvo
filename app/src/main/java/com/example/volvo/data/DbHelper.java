package com.example.volvo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.volvo.data.FeedReaderContract.FeedEntry;

import androidx.annotation.Nullable;
//factory design pattern

public class DbHelper extends SQLiteOpenHelper {

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    //this will create db if it doesnt exist
    public DbHelper(@Nullable Context context) {
        super(context, FeedEntry.DB_NAME, null, 1);
    }

    // we'll create a table
    @Override
    public void onCreate(SQLiteDatabase db) {
       // db.execSQL("create table tablename(id integer primary key, title text, subtitle text)");
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    // add or remove cols from existing db on update of an app
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
