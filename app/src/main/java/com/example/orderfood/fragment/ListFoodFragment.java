package com.example.orderfood.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.orderfood.Adapter.FoodAdapter;
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

        return view;
    }
}