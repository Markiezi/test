package com.example.chattest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2main);

        BottomNavigationView botnav = findViewById(R.id.botnavview);
        botnav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout,
                new home_f()).commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedfragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:{
                            selectedfragment = new home_f();
                            break;
                        }
                        case R.id.nav_forum:{
                            selectedfragment = new chat_f();
                            break;
                        }
                        case R.id.nav_settings:{
                            selectedfragment = new settings_f();
                            break;
                        }
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,
                            selectedfragment).commit();

                    return true;
                }
            };
}
