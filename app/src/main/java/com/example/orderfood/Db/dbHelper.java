package com.example.orderfood.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.example.orderfood.entity.FoodModify;

import java.io.File;

public class dbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private  static final String DB_NAME="orderFood";

    public dbHelper( Context context) {
        super(context, DB_NAME, null ,DB_VERSION);
    }


    //create by Thanh Tam
    @Override
    public void onCreate(SQLiteDatabase db) {
        String tb_NhanVien = "CREATE TABLE NHANVIEN (MANV INTEGER PRIMARY KEY AUTOINCREMENT, TENDN TEXT, MATKHAU TEXT, GIOITINH TEXT, NGAYSINH TEXT, QUYEN INTEGER)";
        String tb_BanAn = "CREATE TABLE BANAN(MABAN INTEGER PRIMARY KEY AUTOINCREMENT, TENBAN TEXT, TINHTRANG TEXT)";
        String tb_MonAn = "CREATE TABLE MONAN(MAMON INTEGER PRIMARY KEY AUTOINCREMENT, TENMON TEXT, GIATIEN INTEGER, HINHANH TEXT)";
        String tb_Quyen = "CREATE TABLE QUYEN(MAQUYEN INTEGER PRIMARY KEY AUTOINCREMENT, TENQUYEN TEXT)";
        String tb_HoaDon = "CREATE TABLE HOADON(MAHD INTEGER PRIMARY KEY AUTOINCREMENT, MAMON INTEGER, SOLUONG INTEGER)";
        String tb_ChiTietHD="CREATE TABLE CHITIETHD(MAHD INTEGER , MAMON INTEGER, SOLUONG INTEGER, PRIMARY KEY(MAHD, MAMON))";

        String insert1 = "INSERT INTO MONAN VALUES(1, 'Vịt quay Nha Trang', 250000, 123 )";
        String insert = "INSERT INTO MONAN VALUES(15, 'Vịt quay', 50000, 123)";
        String insert2 = "INSERT INTO NHANVIEN VALUES(1, 'admin', '1234','Nữ', '12/1/2002', 1)";
       db.execSQL(tb_NhanVien);
        db.execSQL(tb_BanAn);
        db.execSQL(tb_MonAn);
        db.execSQL(tb_Quyen);
        db.execSQL(tb_HoaDon);
        db.execSQL(tb_ChiTietHD);
        db.execSQL(insert);
        db.execSQL(insert1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
