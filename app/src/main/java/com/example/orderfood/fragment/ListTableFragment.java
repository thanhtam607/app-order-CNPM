package com.example.orderfood.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.orderfood.Adapter.TableAdapter;
import com.example.orderfood.MenuActivity;
import com.example.orderfood.Model.Table;
import com.example.orderfood.R;
import com.example.orderfood.entity.TableModify;

import java.util.List;



public class ListTableFragment extends Fragment {



    public static int RESQUEST_CODE_ADD = 111;
    public static int RESQUEST_CODE_EDIT = 16;

    private GridView gridView;
    private List<Table> tableList;
    private TableModify tableModify;

    private int maquyen = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_table, container, false);
        ((MenuActivity)getActivity()).getSupportActionBar().setTitle("Bàn ăn");
        gridView = view.findViewById(R.id.gvHienBanAn);


        tableModify = new TableModify(getActivity());
        tableModify.getListTable();

        getListTable();

        return view;
    }








    private void getListTable(){
        tableList = tableModify.getListTable();
        TableAdapter tableAdapter = new TableAdapter(getActivity(), tableList);
        gridView.setAdapter(tableAdapter);
        tableAdapter.notifyDataSetChanged();
    }


}
