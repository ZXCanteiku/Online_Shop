package com.example.online_shop;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.online_shop.ui.home.HomeFragment;
import com.example.online_shop.ui.person.PersonFragment;
import com.example.online_shop.ui.search.SearchFragment;
import com.example.online_shop.ui.shop.ShopFragment;



public class MainActivity extends AppCompatActivity {
    FragmentTransaction ft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        HomeFragment homeFragment = new HomeFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.nav_host_fragment_activity_main2, homeFragment);
                        ft.addToBackStack(null);
                        ft.commit();

                        return true;
                    case R.id.navigation_search:
                        SearchFragment searchFragment = new SearchFragment();

                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.nav_host_fragment_activity_main2, searchFragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        return true;
                    case R.id.navigation_shop:
                        ShopFragment shopFragment = new ShopFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.nav_host_fragment_activity_main2, shopFragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        return true;
                    case R.id.navigation_person:
                        PersonFragment personFragment = new PersonFragment();
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.nav_host_fragment_activity_main2, personFragment);
                        ft.addToBackStack(null);
                        ft.commit();
                        return true;
                }
                return false;
            }
        });


    }
}