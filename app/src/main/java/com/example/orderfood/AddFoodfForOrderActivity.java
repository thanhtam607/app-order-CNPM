package com.example.orderfood;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orderfood.Model.Food;
import com.example.orderfood.entity.FoodModify;
import com.example.orderfood.entity.OrderModify;
import com.example.orderfood.entity.TableModify;

public class AddFoodfForOrderActivity extends AppCompatActivity implements View.OnClickListener{

    int tableId, foodId;
    Button addOrder;
    EditText quantity;
    OrderModify orderModify;
    ImageView img;
    TextView name, price;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food_for_order);

        addOrder = findViewById(R.id.add_order);
        quantity = findViewById(R.id.quantity);
        img = findViewById(R.id.image);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);

        orderModify = new OrderModify(this);

        Intent intent = getIntent();
        tableId = intent.getIntExtra("tableId", 0);
        foodId = intent.getIntExtra("foodId", 0);
        FoodModify foodModify = new FoodModify(this);
        Food food = foodModify.findFoodById(foodId);
        if(food.getImage().equals("123")){
            img.setImageResource(R.drawable.f001);
        }else{
            img.setImageURI(Uri.parse(food.getImage()));
        }
        name.setText(food.getName());
        price.setText("Giá: "+ food.getPrice());


        addOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int orderId =  orderModify.findOrderIdbytable(tableId, "Chưa thanh toán");

        boolean check = orderModify.checkExist(orderId, foodId);
        if (check){
            //tiến hành cập nhật món đã tồn tại
            int oldQuan = orderModify.getOldQuantity(orderId, foodId);
            int newQuan = Integer.parseInt(quantity.getText().toString());

            int sum = oldQuan + newQuan;
             boolean checkAdd= orderModify.updateQuantity(orderId, foodId, sum);
             if(checkAdd){
                 Toast.makeText(this,"Thêm món ăn vào danh sách đặt món thành công", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(this,"Thêm món ăn vào danh sách đặt món không thành công", Toast.LENGTH_SHORT).show();
             }
             }
        else {
            int quan = Integer.parseInt(quantity.getText().toString());
           boolean check1 =  orderModify.addOrderDetail(orderId, foodId, quan);
           if(check1) {
               Toast.makeText(this, "Thêm món ăn vào danh sách đặt món thành công", Toast.LENGTH_SHORT).show();
           }else
               Toast.makeText(this, "Thêm món ăn vào danh sách đặt món thất bại", Toast.LENGTH_SHORT).show();

        }

        finish();
    }
}