package com.example.orderfood.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.Model.Food;
import com.example.orderfood.R;

import java.util.List;
//create by thanh tam
public class FoodAdapter extends BaseAdapter {
    private final Context context;
    private final  List<Food> list;
    public FoodAdapter(Context context, List<Food> list){
        this.context =context;
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
        return list.get(position).getId();
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_food, null);

        ImageView img = view.findViewById(R.id.ifo_img);
        TextView name = view.findViewById(R.id.food_name);
        TextView price= view.findViewById(R.id.food_price);

        Food food = list.get(position);
        String s = 123+"";
        name.setText(food.getName());
        price.setText(food.getPrice()+" VND");
        if(food.getImage().equals(s)){
            img.setImageResource(R.drawable.f001);
        }
        else{
            Uri uri = Uri.parse(food.getImage());
            img.setImageURI(uri);
//            price.setText(uri.toString());
        }



        return view;
    }
}
