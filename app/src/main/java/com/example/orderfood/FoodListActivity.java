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
//Danh sach mon an tam thoidataList.add(new Food(R.drawable.f001, "Vịt nướng Nha Trang" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f002, "Nem cua bể Hải Phòng" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f003, "Cá chẽm sốt chua ngọt" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f004, "Gỏi cuốn" , 10000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f005, "Chả cá lã vọng" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));
        dataList.add(new Food(R.drawable.f006, "Gà tần" , 250000,"Từ bàn tay lành nghề lâu năm của các đầu bếp chuyên nghiệp, vịt nướng Nha Trang Dũng Linh mang đến một hương vị đặc biệt khó đâu sánh bằng. Thịt vịt được ướp bằng công thức riêng béo ngậy chấm cùng nước chấm cay cay ngọt ngọt ăn một lần là ghiền."));

//        dbHelper.getInstance(this);

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
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create_new_food:
//                newGame();
                Intent intent = new Intent(this, AddFoodActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
//    public void saveFile(){
//        ObjectOutputStream oos = null;
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(getFileStreamPath("food.dat"));
//            oos= new ObjectOutputStream(fos);
//
//            oos.writeObject(dataList);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            if(fos!=null){
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(oos !=null){
//                try {
//                    oos.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }

//    public void readFile(){
//        ObjectInputStream ois = null;
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(getFileStreamPath("food.dat"));
//            ois= new ObjectInputStream(fis);
//
//           dataList = (List<Food>) ois.readObject();
//
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            if(fis!=null){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            if(ois !=null){
//                try {
//                    ois.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//
//
//    }
}