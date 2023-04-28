package com.example.orderfood.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.orderfood.Db.dbHelper;
import com.example.orderfood.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodModify {
    public static final String QUERY_CREATE_TABLE= "CREATE TABLE food(id INTEGER primary key AUTOINCREMENT," +
            " name varchar(50), image text, price float);";
    static SQLiteDatabase sqLiteDatabase = dbHelper.getInstance(null).getReadableDatabase();
    //create by Thanh Tam
//    Lấy lên danh sách món ăn
    public static List<Food> getData(){
        List<Food> res = new ArrayList<>();
        String sql= "select * from food";
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        cursor.moveToFirst();
        while(!cursor.moveToLast()){
            res.add(new Food(cursor.getInt(0), cursor.getString(1),
                    cursor.getFloat(3), cursor.getString(2)));
        }
        return res;
    }
    //create by Thanh Tam
//    bước 7 trong mô tả use case Thêm món
    public static boolean addNewFood(Food food){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",food.getName());
        contentValues.put("price", food.getPrice());
        contentValues.put("image", food.getImage());

        long kiemtra = sqLiteDatabase.insert("food",null,contentValues);
        return kiemtra != 0;
    }
}
