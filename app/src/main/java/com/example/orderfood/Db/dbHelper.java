package com.example.orderfood.Db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        String tb_DatMon = "CREATE TABLE DATMON(MADM INTEGER PRIMARY KEY AUTOINCREMENT, BAN INTEGER, TONGTIEN INTERGER, TINHTRANG TEXT)";
        String tb_ChiTietHD="CREATE TABLE CHITIETDM(MADM INTEGER , MAMON INTEGER, SOLUONG INTEGER, PRIMARY KEY(MADM, MAMON))";

        String insert1 = "INSERT INTO MONAN VALUES(1, 'Vịt quay Nha Trang', 250000, 123 )";
        String insert = "INSERT INTO MONAN VALUES(15, 'Vịt quay', 50000, 123)";
        String insert2 = "INSERT INTO NHANVIEN VALUES(1, 'admin', '1234','Nữ', '12/1/2002', 1)";
        String insert3 = "INSERT INTO BANAN VALUES(1, 'Bàn 1', 'Trống')";
        String insert4 = "INSERT INTO BANAN VALUES(2, 'Bàn 2', 'Trống')";
        String insert7 = "INSERT INTO BANAN VALUES(3, 'Bàn 3', 'Trống')";
        String insert8 = "INSERT INTO BANAN VALUES(4, 'Bàn 4', 'Trống')";
        String insert9 = "INSERT INTO BANAN VALUES(5, 'Bàn 5', 'Trống')";
        String insert10 = "INSERT INTO BANAN VALUES(6, 'Bàn 6', 'Trống')";
        String insert11 = "INSERT INTO BANAN VALUES(7, 'Bàn 7', 'Trống')";
        String insert13= "INSERT INTO BANAN VALUES(8, 'Bàn 8', 'Trống')";
        String insert12= "INSERT INTO BANAN VALUES(9, 'Bàn 9', 'Trống')";

       db.execSQL(tb_NhanVien);
        db.execSQL(tb_BanAn);
        db.execSQL(tb_MonAn);
        db.execSQL(tb_Quyen);
        db.execSQL(tb_DatMon);
        db.execSQL(tb_ChiTietHD);
        db.execSQL(insert);
        db.execSQL(insert1);
        db.execSQL(insert2);
        db.execSQL(insert3);
        db.execSQL(insert4);
        db.execSQL(insert7); db.execSQL(insert11);
        db.execSQL(insert8);
        db.execSQL(insert9); db.execSQL(insert12); db.execSQL(insert13);
        db.execSQL(insert10);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}
