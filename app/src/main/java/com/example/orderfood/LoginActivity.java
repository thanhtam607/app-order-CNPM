package com.example.orderfood;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.orderfood.Db.dbHelper;
import com.example.orderfood.entity.StaffModify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edUsername, edPass;
    private Button btLogin;
    private StaffModify staffModify;

    private final int STORAGE_PERMISSION_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUsername = findViewById(R.id.username);
        edPass = findViewById(R.id.password);
        btLogin = findViewById(R.id.submit);

        staffModify = new StaffModify(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
            requestStoragePermission();

        btLogin.setOnClickListener(this);
    }
    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Ứng dụng cần được cấp quyền")
                    .setMessage("Ứng dụng cần được cấp quyền truy cập bộ nhớ để có thể sử dụng ứng dụng tốt hơn!")
                    .setPositiveButton("Ok", (dialog, which) -> ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE))
                    .setNegativeButton("Hủy", (dialog, which) -> System.exit(0))
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Đã được cấp quyền!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Ứng dụng bị từ chối cấp quyền!", Toast.LENGTH_SHORT).show();
                requestStoragePermission();
            }
        }
    }

    private void btLogin(){
        String user = edUsername.getText().toString();
        String pass = edPass.getText().toString();
        int check = staffModify.login(user, pass);
        int maquyen = staffModify.getRole(check);

        if (check == 0){
//            SharedPreferences sharedPreferences = getSharedPreferences("luuquyen", Context.MODE_PRIVATE); // chỉ có ứng dụng này đc dùng
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putInt("maquyen", maquyen);
//            editor.apply();
            dbHelper dbHelper= new dbHelper(this);
            dbHelper.open();
            Intent iHome = new Intent(LoginActivity.this, MenuActivity.class);
//            iHome.putExtra("tendn", edUsername.getText().toString());
//            iHome.putExtra("manhanvien", check);
            startActivity(iHome);

            finish();


        } else Toast.makeText(LoginActivity.this, "Đăng nhập thất bại!!", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.submit) btLogin();
    }

}

