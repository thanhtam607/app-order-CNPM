package com.example.orderfood.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orderfood.entity.FoodModify;

public class dbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 0;
    private  static final String DB_NAME="orderFood";
    private static dbHelper instance = null;
    public synchronized  static dbHelper getInstance(Context context){
        if(instance==null){
        instance = new dbHelper(context);}
        return instance;
    }
    public dbHelper( Context context) {
        super(context, DB_NAME, null ,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = FoodModify.QUERY_CREATE_TABLE;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
