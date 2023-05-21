package com.example.orderfood.entity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.Db.dbHelper;
import com.example.orderfood.Model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodModify {
    private static SQLiteDatabase database = null;
    public FoodModify(Context context){
        dbHelper  dbHelper = new dbHelper(context);
        database = dbHelper.open();
    }
    //create by Thanh Tam
//    Lấy lên danh sách món ăn
    @SuppressLint("Recycle")
    public static List<Food> getData(){
        List<Food> res = new ArrayList<>();
        String sql= "SELECT * FROM MONAN";
        Cursor cursor =database.rawQuery(sql,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Food food = new Food(cursor.getInt(0), cursor.getString(1), cursor.getInt(2), cursor.getString(3));
            res.add(food);
            cursor.moveToNext();
            }
        return res;
    }
    //create by Thanh Tam
//    bước 7 trong mô tả use case Thêm món
    public void addNewFood(Food food) {
        ContentValues values = new ContentValues();
        values.put("TENMON", food.getName());
        values.put("GIATIEN", food.getPrice());
        values.put("HINHANH", food.getImage());

        database.insert("MONAN", null, values);
        database.close();
    }


    public static Food findFoodById(int id) {
        Food food = new Food();
        String sql = "SELECT * FROM MONAN WHERE MAMON = '"+ id+ "'";
        Cursor cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            food.setId(cursor.getInt(0));
            food.setName(cursor.getString(1));
            food.setPrice(cursor.getInt(2));
            food.setImage(cursor.getString(3));
            cursor.moveToNext();
        }

        return food;

    }
    // 20130348 bước 4.1 Xóa món ăn
    public static void remove_food(int id) {
        database.delete("MONAN", "MAMON = "+ id, null);
    }






}
