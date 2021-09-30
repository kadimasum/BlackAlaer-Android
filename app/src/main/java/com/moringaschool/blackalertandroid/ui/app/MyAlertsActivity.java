package com.moringaschool.blackalertandroid.ui.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.moringaschool.blackalertandroid.R;

public class MyAlertsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // menu variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_alerts);

        // <------- HOOKS -------->
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_2);
        navigationView = (NavigationView) findViewById(R.id.nav_view_2);
        toolbar = (ImageView) findViewById(R.id.menu_icon_2);

        // <---------TOOL BAR --------->

        // <------- NAVIGATION DRAWER MENU --------->
        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.my_alerts);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.user:
                startActivity(new Intent(MyAlertsActivity.this, AlertHomeActivity.class));
                break;
            case R.id.my_alerts:
                startActivity(new Intent(MyAlertsActivity.this, MyAlertsActivity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(MyAlertsActivity.this, SettingsActivity.class));
                break;
            case R.id.logout:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}