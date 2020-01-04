package com.example.th_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {
    BottomNavigationView navView;
    boolean status=false;
    MenuItem menuItem;
    EditText searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        DBHelper dbHelper= new DBHelper(getApplicationContext());
//        dbHelper.createTable();
//
//        if(dbHelper.getALLFurniture().size()==0)
//        {
//            dbHelper.insertFurniture();
//        }
//        if(dbHelper.getALLCategories().size()==0)
//        {
//            dbHelper.insertCategories();
//        }

        navView = findViewById(R.id.nav_view);
        loadFragment(new AccountFragment());
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_dashboard);
        searchView=findViewById(R.id.search_vew);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }
    private BottomNavigationView.OnNavigationItemSelectedListener
    mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.navigation_dashboard:
                    getSupportActionBar().hide();
                    fragment=new DashboardFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_home:
                    getSupportActionBar().hide();
                    fragment=new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_notifications:
                    getSupportActionBar().hide();
                    fragment=new NotifcationFagment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_account:
                    getSupportActionBar().hide();
                    fragment=new AccountFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
