package com.example.orderfood.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.orderfood.Adapter.FoodAdapter;
import com.example.orderfood.MainActivity;
import com.example.orderfood.Model.Food;
import com.example.orderfood.R;
import com.example.orderfood.entity.FoodModify;

import java.util.ArrayList;
import java.util.List;


public class ListFoodFragment extends Fragment {

    ListView listView ;
    List<Food> dataList =  new ArrayList<>();
    FoodAdapter foodAdapter;
    private FragmentManager fragmentManager;
    private SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view  = inflater.inflate(R.layout.fragment_list_food, container,false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Thực đơn");

        listView = view.findViewById(R.id.list);
        fragmentManager = getActivity().getSupportFragmentManager();
        FoodModify foodModify = new FoodModify(getActivity());

        dataList = foodModify.getData();

            foodAdapter = new FoodAdapter(getActivity(), dataList);
            listView.setAdapter(foodAdapter);
            foodAdapter.notifyDataSetChanged();

        return view;
    }
}