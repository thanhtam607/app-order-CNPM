package com.example.orderfood.entity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orderfood.Db.dbHelper;

public class FoodModify {
    public static final String QUERY_CREATE_TABLE= "create table food (id int primary " +
            "key autoincrement, name varchar(50), " +
            "description text, price float);";

    public static Cursor getData(){
        String sql= "select id, name, description, price from food";
        SQLiteDatabase sqLiteDatabase = dbHelper.getInstance(null).getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        return cursor;
    }
}
