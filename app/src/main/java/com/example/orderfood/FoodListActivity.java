package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.orderfood.Adapter.FoodAdapter;
import com.example.orderfood.Model.Food;

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
//Danh sach mon an tam thoi
        dataList.add(new Food(R.drawable.f001, "Vịt nướng Nha Trang" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f002, "Nem cua bể Hải Phòng" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f003, "Cá chẽm sốt chua ngọt" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f004, "Gỏi cuốn" , 10000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f005, "Chả cá lã vọng" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f006, "Gà tần" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));

        foodAdapter = new FoodAdapter(this, dataList);
        listView.setAdapter(foodAdapter);
    }
}