package com.example.orderfood.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.orderfood.Adapter.OrderDetailAdapter;
import com.example.orderfood.AddFoodfForOrderActivity;
import com.example.orderfood.MenuActivity;
import com.example.orderfood.Model.Order;
import com.example.orderfood.Model.OrderDetail;
import com.example.orderfood.R;
import com.example.orderfood.entity.OrderModify;
import com.example.orderfood.entity.TableModify;

import java.util.List;
import java.util.Map;

public class OrderFoodFragment extends Fragment implements View.OnClickListener {
    List<OrderDetail> listdata;
    Button button;
    ListView listView ;
    OrderModify orderModify;
    OrderDetailAdapter adapter;
    FragmentManager fragmentManager;
    int tableId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_order_food, container, false);
        ((MenuActivity)getActivity()).getSupportActionBar().setTitle("Danh sách đặt món");

       button = view.findViewById(R.id.submit);
       listView= view.findViewById(R.id.listOrder);

        Bundle bundle = getArguments();
        if(bundle != null) {
            tableId = bundle.getInt("tableId");
            orderModify = new OrderModify(getActivity());

            int orderId = orderModify.findOrderIdbytable(tableId, "Chưa thanh toán");


            listdata = orderModify.getListOrderDetailById(orderId);

            adapter = new OrderDetailAdapter(getActivity(), listdata);
            listView.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
        button.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.submit:
                orderModify.updateStatus(tableId, "Thanh toán");
                TableModify tableModify = new TableModify(getActivity());
                tableModify.updateStatus(tableId, "Trống");

                Toast.makeText(getContext(),"Xuất hóa đơn thành công", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}