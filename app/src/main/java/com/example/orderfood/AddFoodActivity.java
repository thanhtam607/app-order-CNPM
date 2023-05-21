package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orderfood.Model.Food;
import com.example.orderfood.entity.FoodModify;

// create bt Thanh Tam
public class AddFoodActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addFood, exit;
    private ImageView image;
    private String imgUri;
    private EditText name, price;
    FoodModify foodModify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_add_food);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        image = findViewById(R.id.imageView);
        exit = findViewById(R.id.exit);
        addFood = findViewById(R.id.add_food_btn);

        foodModify= new FoodModify(this);

        image.setOnClickListener(this);
        addFood.setOnClickListener(this);
        exit.setOnClickListener(this);
    }
    //        Bước 3 trong mô tả use case Thêm món
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.imageView:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent,"Chọn hình món ăn"), 1);
                break;
            case R.id.add_food_btn:
                String foodName = name.getText().toString();
                int foodprice = 0;
//                    bước 5 trong mô tả use case
                if (foodName != null && price.getText().toString()!= null && !foodName.equals("") && !price.getText().toString().equals(" ")){
                    Food food = null;
                    if (!isExist(foodName))// bước 6
                    {
                        food = new Food();//bước 7
                        foodprice=Integer.parseInt(price.getText().toString());
                        food.setName(foodName);
                        food.setPrice(foodprice);
                        food.setImage(imgUri);
                    }
                    foodModify.addNewFood(food);//bước 8

                    Toast.makeText(this, "Thêm món ăn thành công", Toast.LENGTH_SHORT).show();
                }else
                    // bước 7.1
                    Toast.makeText(this,"Món ăn đã tồn tại", Toast.LENGTH_SHORT).show();
                break;
            case R.id.exit:
                Intent intent1 = new Intent(this, MenuActivity.class);
                startActivity(intent1);
                finish();
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null){
               imgUri = data.getData().toString();
               image.setImageURI(data.getData());
               name.setText(data.getData().toString());
            }
    }


    public boolean isExist(String name){
        for(Food f: FoodModify.getData()){
            if(f.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}