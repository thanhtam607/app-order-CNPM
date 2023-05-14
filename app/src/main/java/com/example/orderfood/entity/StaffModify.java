package com.example.orderfood.entity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.Db.dbHelper;

public class StaffModify {
    private final SQLiteDatabase database;

    public StaffModify(Context context) {
        dbHelper dbHelper = new dbHelper(context);
        database = dbHelper.open();
    }
    @SuppressLint("Recycle")
    public boolean checkStaff(){
        String sql = "SELECT * FROM NHANVIEN";
        Cursor cursor = database.rawQuery(sql, null);
        return cursor.getCount() != 0;
    }

    @SuppressLint({"Recycle", "Range"})
    public int login(String name, String pass){
        String sql = "SELECT * FROM NHANVIEN WHERE TENDN = '" + name
                + "' AND MATKHAU = '" + pass + "'";

        int idStaff = 0;
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            idStaff = cursor.getInt(cursor.getColumnIndex("MANV"));
            cursor.moveToNext();
        }

        return idStaff;
    }
    @SuppressLint({"Recycle", "Range"})
    public int getRole(int id){
        int role = 0;
        String truyvan = "SELECT * FROM NHANVIEN  WHERE MANV = " + id;
        Cursor cursor = database.rawQuery(truyvan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
           role = cursor.getInt(cursor.getColumnIndex("QUYEN"));
            cursor.moveToNext();
        }

        return role;
    }


}
