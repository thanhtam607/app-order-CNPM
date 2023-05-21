package com.example.orderfood.entity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.Db.dbHelper;
import com.example.orderfood.Model.Table;

import java.util.ArrayList;
import java.util.List;

public class TableModify {
    private static SQLiteDatabase database = null;
    public TableModify(Context context){
        dbHelper dbHelper = new dbHelper(context);
        database = dbHelper.open();
    }

    @SuppressLint("Recycle")
    public List<Table> getListTable(){
        List<Table> tableList = new ArrayList<>();
        String truyvan= "SELECT * FROM BANAN";
        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Table table = new Table();
            table.setId(cursor.getInt(0));
            table.setName(cursor.getString(1));
            table.setStatus(cursor.getString(2));
            tableList.add(table);
            cursor.moveToNext();
        }
        return tableList;
    }
    public void updateStatus(int tableId, String status){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TINHTRANG", status);
       database.update("BANAN", contentValues,  "MABAN = '" + tableId + "'", null);
    }

}
