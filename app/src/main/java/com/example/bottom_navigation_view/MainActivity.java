package com.example.bottom_navigation_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bt = findViewById(R.id.btnnavigation);

        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                // isme menu itm's ki id deni he...

                if(id == R.id.nav_home){
                    loadfragment(new Homefragment(),true);
                } else if (id == R.id.nav_setting) {
                    loadfragment(new settingfragment(),false);
                } else if(id == R.id.nav_chait){
                    loadfragment(new chairfragment(),false);
                } else if (id == R.id.nav_tool) {
                    loadfragment(new toolfragment(),false);
                }
                return true;
            }
        });
        bt.setSelectedItemId(R.id.nav_home);
    }

    public void loadfragment(Fragment fragment, Boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag) {
            ft.add(R.id.container, fragment);
        }
        else {
            ft.add(R.id.container, fragment);
            ft.commit();
        }
    }
}