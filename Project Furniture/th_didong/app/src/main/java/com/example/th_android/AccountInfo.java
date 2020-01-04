package com.example.th_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class AccountInfo extends AppCompatActivity {
    EditText txtInfo,txtEmail,txtUser,txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        txtInfo=findViewById(R.id.info);
        txtEmail=findViewById(R.id.email);
        txtUser=findViewById(R.id.user);
        txtPass=findViewById(R.id.pass);
        getSupportActionBar().setTitle("Account Info");
        Intent intent = getIntent();
        txtInfo.setText(intent.getStringExtra("Username"));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.save) {
        }
        return super.onOptionsItemSelected(item);
    }
    }
