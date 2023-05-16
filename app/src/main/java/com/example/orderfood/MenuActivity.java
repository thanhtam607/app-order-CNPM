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
import android.view.View;
import android.widget.Button;

import com.example.orderfood.fragment.ListFoodFragment;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private final int STORAGE_PERMISSION_CODE = 1;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        drawerLayout= findViewById(R.id.drawerLayout);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction trans = fragmentManager.beginTransaction();
        ListFoodFragment listFood =  new ListFoodFragment();
        trans.replace(R.id.content, listFood);
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
                Intent intent = new Intent(this, AddFoodActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private  void initView(){
        Button nutgiohang =findViewById(R.id.nutgiohang);
        nutgiohang.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent giohang= new Intent(getApplicationContext(),CartFoodActivity.class);
                startActivity(giohang);

            }
        });
    }

}