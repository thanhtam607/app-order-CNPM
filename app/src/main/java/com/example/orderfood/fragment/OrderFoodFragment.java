package com.example.orderfood.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.orderfood.Adapter.OrderDetailAdapter;
import com.example.orderfood.MainActivity;
import com.example.orderfood.Model.Food;
import com.example.orderfood.Model.OrderDetail;
import com.example.orderfood.R;
import com.example.orderfood.entity.FoodModify;
import com.example.orderfood.entity.OrderModify;
import com.example.orderfood.entity.TableModify;

import java.util.List;

public class OrderFoodFragment extends Fragment implements View.OnClickListener {
    List<OrderDetail> listdata;
    Button button;
    ListView listView ;
    OrderModify orderModify;
    OrderDetailAdapter adapter;
    FragmentManager fragmentManager;
    int tableId;
    TextView total;
    int totalO = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_order_food, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Danh sách đặt món");

       button = view.findViewById(R.id.submit);
       listView= view.findViewById(R.id.listOrder);
       total = view.findViewById(R.id.total);

        Bundle bundle = getArguments();
        if(bundle != null) {
            tableId = bundle.getInt("tableId");
            orderModify = new OrderModify(getActivity());

            int orderId = orderModify.findOrderIdbytable(tableId, "Chưa thanh toán");


            listdata = orderModify.getListOrderDetailById(orderId);
            FoodModify foodModify = new FoodModify(getActivity());
            for(OrderDetail detail : listdata){
                Food food = foodModify.findFoodById(detail.getFoodId());
                totalO += food.getPrice()* detail.getQuantity();
            }
            total.setText(totalO+" VND");
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