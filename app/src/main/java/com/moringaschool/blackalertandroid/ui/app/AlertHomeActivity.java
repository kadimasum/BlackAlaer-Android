package com.moringaschool.blackalertandroid.ui.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.moringaschool.blackalertandroid.R;

public class AlertHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // menu variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_home);

        // <------- HOOKS -------->
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (ImageView) findViewById(R.id.menu_icon);

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
                break;
            case R.id.my_alerts:
                startActivity(new Intent(AlertHomeActivity.this, MyAlertsActivity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(AlertHomeActivity.this, SettingsActivity.class));
                break;
            case R.id.logout:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}