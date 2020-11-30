package com.example.volvo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.volvo.data.FeedReaderContract.FeedEntry;

/**
 * Database access object
 * CRUD methods
 */
public class Dao {
    DbHelper helper;
    SQLiteDatabase database;

    public Dao(Context context) {
        helper = new DbHelper(context);
    }

    public void openDb(){
        database = helper.getWritableDatabase();
    }
    public void closeDb(){
        database.close();
    }


    public void createRow(String name, String pwd){
        ContentValues values = new ContentValues();
        values.put(FeedEntry.COLUMN_NAME_TITLE,name);
        values.put(FeedEntry.COLUMN_NAME_SUBTITLE,pwd);
        database.insert(FeedEntry.TABLE_NAME,null,values);
    }
    public Cursor readRow(){
      //Cursor cursor = database.rawQuery("select * from entry",null);
        Cursor cursor = database.query(FeedEntry.TABLE_NAME, null,null,null,null,null,null);
        return cursor;
    }
    public void updateRow(){}
    public void deleteRow(){}


}
