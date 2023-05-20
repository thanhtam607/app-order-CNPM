package com.example.orderfood.entity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfood.Db.dbHelper;
import com.example.orderfood.Model.Order;
import com.example.orderfood.Model.OrderDetail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderModify {
    private final SQLiteDatabase database;

    public OrderModify(Context context) {
        dbHelper db = new dbHelper(context);
        database = db.open();
    }
    public void addOrder(Order order){
        ContentValues contentValues = new ContentValues();
        contentValues.put("BAN", order.getTable());
        contentValues.put("TONGTIEN", order.getPrice());
        contentValues.put("TINHTRANG", "Chưa thanh toán");

     database.insert("DATMON", null, contentValues);

    }
    public boolean addOrderDetail(int madm, int mamon, int soluong){
        ContentValues contentValues = new ContentValues();
        contentValues.put("MADM", madm);
        contentValues.put("MAMON", mamon);
        contentValues.put("SOLUONG", soluong);

       long check =  database.insert("CHITIETDM", null, contentValues);
        return check != 0;
    }
    public boolean updateQuantity(int madm, int mamon, int soluong){
        ContentValues contentValues = new ContentValues();
        contentValues.put("SOLUONG", soluong);

        long check = database.update("CHITIETDM", contentValues ,"MADM = " +madm + " AND "
                + "MAMON = " + mamon, null);
        return check != 0;
    }
    @SuppressLint("Recycle")
    public int findOrderIdbytable(int maban, String tinhtrang){
        String sql = "SELECT * FROM DATMON WHERE BAN = " + maban + " AND TINHTRANG = '" + tinhtrang + "'";

        int magoimon = 0;
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            magoimon = cursor.getInt(0);
            cursor.moveToNext();
        }
        return magoimon;
    }
    @SuppressLint("Recycle")
    public List<OrderDetail> getListOrderDetailById(int orderId){
        String sql = "SELECT * FROM CHITIETDM WHERE MADM= '"+ orderId+"'";
        List<OrderDetail> list = new ArrayList<>();
        Cursor cursor = database.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            list.add(new OrderDetail(cursor.getInt(1), cursor.getInt(2)));
            cursor.moveToNext();
        }
        return list;

    }

    @SuppressLint("Recycle")
    public boolean checkExist(int magoimon, int mamonan){
        String sql = "SELECT * FROM CHITIETDM WHERE MAMON = " + mamonan + " AND MADM = " + magoimon;

        Cursor cursor = database.rawQuery(sql, null);
        return cursor.getCount() != 0;
    }
    @SuppressLint("Recycle")
    public int getOldQuantity(int magoimon, int mamonan){
        int quan = 0;
        String truyvan = "SELECT * FROM CHITIETDM WHERE MAMON = " + mamonan + " AND MADM = " + magoimon;

        Cursor cursor = database.rawQuery(truyvan, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            quan = cursor.getInt(2);
            cursor.moveToNext();
        }
        return quan;
    }
    public boolean updateStatus(int maban, String tinhtrang){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TINHTRANG", tinhtrang);

        long kiemtra = database.update("DATMON", contentValues, "BAN= " + maban, null);
        return kiemtra != 0;
    }

}
