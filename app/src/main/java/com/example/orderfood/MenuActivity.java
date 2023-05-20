package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.example.orderfood.fragment.ListFoodFragment;
import com.example.orderfood.fragment.ListTableFragment;
import com.example.orderfood.fragment.OrderFoodFragment;


public class MenuActivity extends AppCompatActivity {
    private Button nutgiohang;
    private FragmentManager fragmentManager;
    private DrawerLayout drawerLayout;

    private Toolbar toolbar;
    private final int STORAGE_PERMISSION_CODE = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
//
        drawerLayout= findViewById(R.id.drawerLayout);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        ListTableFragment listTable =  new ListTableFragment();
        trans.replace(R.id.content, listTable);
        trans.commit();
        drawerLayout.closeDrawers();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//           create by Thanh Tam
//    bước 2 trong mô tả use case Thêm món
            case R.id.create_new_food:
                item.setChecked(true);
                Intent intent = new Intent(this, AddFoodActivity.class);
                startActivity(intent);
                break;
            case R.id.list_Food:
                FragmentTransaction tranHienThiThucDon = fragmentManager.beginTransaction();
                ListFoodFragment listFoodFragment = new ListFoodFragment();
                tranHienThiThucDon.replace(R.id.content, listFoodFragment);
                tranHienThiThucDon.commit();
                item.setChecked(true);
                drawerLayout.closeDrawers();
                break;
        }
        return false;

    }

    private void init(){
            Intent iHome = new Intent(MenuActivity.this, OrderFoodFragment.class);
            startActivity(iHome);
            finish();
    }

//    @SuppressLint("NonConstantResourceId")
//        public void onClick(@NonNull View view) {
//            int id = view.getId();
//            if (id == R.id.nutgiohang) init();
//    }


//        Button nutgiohang =findViewById(R.id.nutgiohang);
//        nutgiohang.setOnClickListener(new  View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent giohang= new Intent(MenuActivity.this,CartFoodActivity.class);
//                startActivity(giohang);
//
//            }
//        });
//    }
}