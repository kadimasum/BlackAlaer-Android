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

public class SettingsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    // menu variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // <------- HOOKS -------->
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_3);
        navigationView = (NavigationView) findViewById(R.id.nav_view_3);
        toolbar = (ImageView) findViewById(R.id.menu_icon_3);

        // <---------TOOL BAR --------->

        // <------- NAVIGATION DRAWER MENU --------->
        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.settings);
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
                startActivity(new Intent(SettingsActivity.this, AlertHomeActivity.class));
                break;
            case R.id.my_alerts:
                startActivity(new Intent(SettingsActivity.this, MyAlertsActivity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(SettingsActivity.this, SettingsActivity.class));
                break;
            case R.id.logout:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}