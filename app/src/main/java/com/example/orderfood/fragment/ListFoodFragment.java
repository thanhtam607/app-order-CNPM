package com.example.orderfood.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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
import com.example.orderfood.MainActivity;
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

    // 20130348 20130348 bước 2 và 2.1 Xóa món ăn
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
//    20130348 bước 3 và 3.1 Xóa món ăn
//    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.delete:
                // Xóa món ăn được chọn
                // Thêm code xử lý xóa món ăn ở đây
                int id = dataList.get(info.position).getId();    // Lấy ID của món ăn được chọn từ danh sách dataList bằng cách sử dụng vị trí của item được chọn trên AdapterView
                foodAdapter.remove(FoodModify.findFoodById(id)); // Sử dụng ID của món ăn để tìm món ăn trong danh sách FoodModify và xóa món ăn khỏi danh sách  foodAdapter
                FoodModify.remove_food(id);                     // Xóa món ăn khỏi danh sách FoodModify
                foodAdapter.notifyDataSetChanged();// bước 5 Xóa món ăn(Cập nhật lại giao diện người dùng)
                reloadFragment(); // Tải lại trang
                return true;
            case R.id.details:
                // Xem chi tiết món ăn được chọn
                // Thêm code xử lý xem chi tiết món ăn ở đây
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void reloadFragment() {
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             Bundle savedInstanceState) {
       View view  = inflater.inflate(R.layout.fragment_list_food, container,false);
//        View view2  = inflater.inflate(R.layout.fragment_delete_food, container,false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Thực đơn");
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