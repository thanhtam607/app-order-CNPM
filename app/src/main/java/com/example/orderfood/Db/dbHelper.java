package com.example.orderfood.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orderfood.entity.FoodModify;

public class dbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private  static final String DB_NAME="orderFood";
    private static dbHelper instance = null;
    public dbHelper( Context context) {
        super(context, DB_NAME, null ,DB_VERSION);
    }
    //create by Thanh Tam
    public synchronized  static dbHelper getInstance(Context context){
        if(instance==null){
        instance = new dbHelper(context);}
        return instance;
    }
    //create by Thanh Tam
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = FoodModify.QUERY_CREATE_TABLE;
        db.execSQL(sql);
        String sql1 = "insert into food (name, image, price) values('món 1', 'res/drawable/f001.jpg', 400000)";
        db.execSQL(sql1);
        String sql2 = "insert into food (name, image, price) values('món 2', 'res/drawable/f002.jpg', 400000)";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
