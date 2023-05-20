package com.example.orderfood.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.orderfood.MenuActivity;
import com.example.orderfood.Model.Order;
import com.example.orderfood.Model.OrderDetail;
import com.example.orderfood.Model.Table;
import com.example.orderfood.entity.TableModify;
import com.example.orderfood.fragment.OrderFoodFragment;
import com.example.orderfood.R;
import com.example.orderfood.entity.OrderModify;
import com.example.orderfood.fragment.ListFoodFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TableAdapter extends BaseAdapter implements View.OnClickListener, View.OnLongClickListener {
    private final Context context;
    private final List<Table> list;
    private ViewHolder viewHolder;
    private OrderModify orderModify;
    private TableModify tableModify;
    private final FragmentManager fragmentManager ;
    public TableAdapter(Context context, List<Table> tableList) {
        this.context = context;
        this.list = tableList;
        this.orderModify = new OrderModify(context);
        this.tableModify = new TableModify(context);
        fragmentManager = ((MenuActivity)context).getSupportFragmentManager();
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
    public View getView(int position, View  convertView, ViewGroup parent) {
        View view = convertView;



        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_table, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imtable = view.findViewById(R.id.image);
            viewHolder.txtName = view.findViewById(R.id.name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Table table = list.get(position);
        viewHolder.txtName.setText(table.getName());
        if(table.getStatus().equals("Trống")){
            viewHolder.imtable.setImageResource(R.drawable.banan1);
        }else{
            viewHolder.imtable.setImageResource(R.drawable.banan);
            viewHolder.imtable.setOnLongClickListener(this);
        }


        viewHolder.imtable.setTag(table.getId());
        viewHolder.imtable.setOnClickListener(this);




        return view;
    }
    @SuppressLint({"NonConstantResourceId", "SimpleDateFormat"})
    @Override
    public void onClick(View v) {
        int id = v.getId();
        int maban = (int) v.getTag();
        List<OrderDetail> itemOrder = new ArrayList<>();
        viewHolder = (ViewHolder) ((View)v.getParent()).getTag();
        switch (id){
            case R.id.image:
                        // thực hiện code thêm bảng gọi món va cập nhật lại tình trạng bàn
                        Calendar calendar = Calendar.getInstance();


                        Order order = new Order();
                        order.setTable(maban);
                        order.setPrice(10000);
                        order.setItemOrder(itemOrder);

                        orderModify.addOrder(order);

                    tableModify.updateStatus(maban, "Có người");
                    FragmentTransaction tranThucDonTransaction = fragmentManager.beginTransaction();
                    ListFoodFragment listFoodFragment = new ListFoodFragment();
                    Bundle bData = new Bundle();
                    bData.putInt("tableId", maban);

                   listFoodFragment.setArguments(bData);
                    tranThucDonTransaction.replace(R.id.content, listFoodFragment).addToBackStack("hienthibanan");
                    tranThucDonTransaction.commit();
                break;

        }
    }
    @SuppressLint({"NonConstantResourceId", "SimpleDateFormat"})
    @Override
    public boolean onLongClick(View v) {
        int id = v.getId();
        int maban =   (int) v.getTag();;
        viewHolder = (ViewHolder) ((View)v.getParent()).getTag();
        switch (id) {
            case R.id.image:

                    FragmentTransaction tran = fragmentManager.beginTransaction();
                    OrderFoodFragment orderFoodFragment = new OrderFoodFragment();
                    Bundle bData = new Bundle();
                    bData.putInt("tableId", maban);

                   orderFoodFragment.setArguments(bData);
                    tran.replace(R.id.content, orderFoodFragment).addToBackStack("Hiển thị ds đặt món");
                    tran.commit();


                break;
        }
        return true;
    }

    public static class ViewHolder{
        ImageView imtable;
        TextView txtName;

    }
}
