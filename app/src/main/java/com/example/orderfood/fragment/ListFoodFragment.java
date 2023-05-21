package com.example.orderfood.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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

    ListView listView,listView2;
    Button btn;
    List<Food> dataList =  new ArrayList<>();
    FoodAdapter foodAdapter;
    int tableId;
    int idRemove;

    // 20130348
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
//    20130348
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete:
                // Xóa món ăn được chọn
                // Thêm code xử lý xóa món ăn ở đây
                int id = dataList.get(info.position).getId();
                foodAdapter.remove(FoodModify.findFoodById(id));
                FoodModify.remove_food(id);
                foodAdapter.notifyDataSetChanged();
                return true;
            case R.id.details:
                // Xem chi tiết món ăn được chọn
                // Thêm code xử lý xem chi tiết món ăn ở đây
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             Bundle savedInstanceState) {
       View view  = inflater.inflate(R.layout.fragment_list_food, container,false);
//        View view2  = inflater.inflate(R.layout.fragment_delete_food, container,false);
        ((MenuActivity) getActivity()).getSupportActionBar().setTitle("Thực đơn");
        listView = view.findViewById(R.id.list);
//        listView2 = view2.findViewById(R.id.listFoods);
    registerForContextMenu(listView);// 20130348
        FoodModify foodModify = new FoodModify(getActivity());
        dataList = foodModify.getData();
        foodAdapter = new FoodAdapter(getActivity(), dataList);
        listView.setAdapter(foodAdapter);
//        listView2.setAdapter(foodAdapter);
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
//            listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    idRemove = dataList.get(position).getId();
//                    foodAdapter.remove(FoodModify.findFoodById(idRemove));
//                    FoodModify.remove_food(idRemove);
//                    foodAdapter.notifyDataSetChanged();
//                }
//
//            });
//            btn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    foodAdapter.remove(FoodModify.findFoodById(idRemove));
//                    FoodModify.remove_food(idRemove);
//                    foodAdapter.notifyDataSetChanged();
//                }
//            });

        }
        return view;
    }


}