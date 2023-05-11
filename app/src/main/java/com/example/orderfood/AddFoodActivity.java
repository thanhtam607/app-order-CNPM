package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orderfood.Model.Food;
import com.example.orderfood.entity.FoodModify;
import com.google.android.material.textfield.TextInputEditText;
// create bt Thanh Tam
public class AddFoodActivity extends AppCompatActivity implements View.OnClickListener {
    private Button selectImg;
    private ImageView image;
    private String imgUri;
    private TextInputEditText name, price;
    FoodModify foodModify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_add_food);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        image = findViewById(R.id.imageView);
        foodModify= new FoodModify(this);

        image.setOnClickListener(this);
    }
    //        Bước 3 trong mô tả use case Thêm món
    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.imageView:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent,"Chọn hình thực đơn"),0);
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
                   

                    boolean check = foodModify.addNewFood(food);//bước 8
                    if (check )
                        //bước 9
                        Toast.makeText(this, getResources().getString(R.string.themthanhcong), Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(this, getResources().getString(R.string.themthatbai), Toast.LENGTH_SHORT).show();
                }else
                    // bước 7.1
                    Toast.makeText(this, getResources().getString(R.string.themthatbai), Toast.LENGTH_SHORT).show();

                break;
            case R.id.exit:
                finish();
                break;


        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (resultCode == Activity.RESULT_OK && data != null){
               imgUri = data.getData().toString();
               image.setImageURI(data.getData());
               name.setText(FoodModify.getData().size()+"");
            }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
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