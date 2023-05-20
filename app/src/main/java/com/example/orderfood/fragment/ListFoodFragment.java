package com.example.orderfood.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.orderfood.Adapter.FoodAdapter;
import com.example.orderfood.AddFoodfForOrderActivity;
import com.example.orderfood.MenuActivity;
import com.example.orderfood.Model.Food;
import com.example.orderfood.R;
import com.example.orderfood.entity.FoodModify;

import java.util.ArrayList;
import java.util.List;


public class ListFoodFragment extends Fragment {

    ListView listView ;
    List<Food> dataList =  new ArrayList<>();
    FoodAdapter foodAdapter;
    int tableId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             Bundle savedInstanceState) {
       View view  = inflater.inflate(R.layout.fragment_list_food, container,false);
        ((MenuActivity) getActivity()).getSupportActionBar().setTitle("Thực đơn");

        listView = view.findViewById(R.id.list);

        FoodModify foodModify = new FoodModify(getActivity());
        dataList = foodModify.getData();
        foodAdapter = new FoodAdapter(getActivity(), dataList);
        listView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();
        Bundle bundle = getArguments();
        if(bundle != null) {
            tableId = bundle.getInt("tableId");

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (tableId != 0) {
                        Intent intent = new Intent(getActivity(), AddFoodfForOrderActivity.class);
                        intent.putExtra("tableId", tableId);
                        intent.putExtra("foodId", dataList.get(position).getId());
                        startActivity(intent);
                    }
                }
            });
        }
        return view;
    }
}