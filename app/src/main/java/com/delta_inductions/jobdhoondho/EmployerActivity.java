package com.delta_inductions.jobdhoondho;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class EmployerActivity extends AppCompatActivity {
    TextView toolbartext;
private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer);
        toolbartext = findViewById(R.id.toolbartext);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new EmpHome_Fragment()).commit();
       bottomNavigationView = findViewById(R.id.bottom_navigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(navlistner);
    }

private BottomNavigationView.OnNavigationItemSelectedListener navlistner = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedfragment = null;
        switch(item.getItemId())
        {
            case R.id.nav_home: {
                selectedfragment = new EmpHome_Fragment();
                toolbartext.setText("Home");
            }
                break;

            case R.id.nav_chat: {
                selectedfragment = new EmpChat_Fragments();
                toolbartext.setText("Chat");
            }
                break;
            case R.id.nav_profile: {
                selectedfragment = new EmpProfile_Fragment();
                toolbartext.setText("Profile");
            }
                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container,selectedfragment).commit();
        return true;
    }
};
}