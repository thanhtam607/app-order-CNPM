package com.example.orderfood.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfood.Model.Food;
import com.example.orderfood.Model.OrderDetail;
import com.example.orderfood.R;
import com.example.orderfood.entity.FoodModify;
import com.example.orderfood.entity.OrderModify;

import java.util.List;
import java.util.Map;

public class OrderDetailAdapter extends BaseAdapter {

    List<OrderDetail> listdata;
    FoodModify foodModify;

    private final Context context;

    public OrderDetailAdapter(Context context,List<OrderDetail> listdata) {
        this.context = context;
        this.listdata = listdata;
        this.foodModify = new FoodModify(context);
    }

    @Override
    public int getCount() {
        return listdata.size();
    }

    @Override
    public Object getItem(int position) {
        return listdata.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listdata.get(position).getFoodId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        view =inflater.inflate(R.layout.item_order, parent, false);
         TextView name, price, quan;
         ImageView img;
         name = view.findViewById(R.id.name);
         price = view.findViewById(R.id.price);
         quan = view.findViewById(R.id.quantity);
         img = view.findViewById(R.id.image);
         OrderDetail orderDetail = listdata.get(position);
        Food food = foodModify.findFoodById(orderDetail.getFoodId());
        if(food.getImage().equals("123")){
            img.setImageResource(R.drawable.f001);
        }
        else{
            img.setImageURI(Uri.parse(food.getImage()));
        }
        name.setText(food.getName() +"");
        price.setText("Đơn giá: "+food.getPrice()+" VND");
        quan.setText("Số lượng: "+ orderDetail.getQuantity());

        return view;
    }
}
