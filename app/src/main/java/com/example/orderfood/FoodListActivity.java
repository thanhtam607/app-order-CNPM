package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.orderfood.Adapter.FoodAdapter;
import com.example.orderfood.Db.dbHelper;
import com.example.orderfood.Model.Food;
import com.example.orderfood.entity.FoodModify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {
    ListView listView ;
    List<Food> dataList =  new ArrayList<>();
    FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodlist);
        listView = findViewById(R.id.list);

        dbHelper.getInstance(this);
        dataList = FoodModify.getData();
        //Danh sach mon an tam thoidataList.add(new Food(R.drawable.f001, "Vịt nướng Nha Trang" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
//        dataList.add(new Food(R.drawable.f002, "Nem cua bể Hải Phòng" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
//        dataList.add(new Food(R.drawable.f003, "Cá chẽm sốt chua ngọt" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
//        dataList.add(new Food(R.drawable.f004, "Gỏi cuốn" , 10000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
//        dataList.add(new Food(R.drawable.f005, "Chả cá lã vọng" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
//        dataList.add(new Food(R.drawable.f006, "Gà tần" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));


        foodAdapter = new FoodAdapter(this, dataList);
        listView.setAdapter(foodAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//           create by Thanh Tam
//    bước 2 trong mô tả use case Thêm món
            case R.id.create_new_food:
                Intent intent = new Intent(this, AddFoodActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}