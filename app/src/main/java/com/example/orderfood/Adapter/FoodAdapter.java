package com.example.orderfood.Adapter;
import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.Model.Food;
import com.example.orderfood.R;

import java.util.List;
//create by thanh tam
public class FoodAdapter extends BaseAdapter {
    Activity activity;
    List<Food> list;
    public FoodAdapter(Activity activity, List<Food> list){
        this.activity = activity;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_food, null);

        ImageView img = view.findViewById(R.id.ifo_img);
        TextView name = view.findViewById(R.id.food_name);
        TextView price= view.findViewById(R.id.food_price);

        Food food = list.get(position);
        img.setImageURI(Uri.parse(food.getImage()));
        name.setText(food.getName());
       price.setText(food.getPrice()+" VND");
        return view;
    }
}
