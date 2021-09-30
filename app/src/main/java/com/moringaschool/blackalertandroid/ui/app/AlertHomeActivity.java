package com.moringaschool.blackalertandroid.ui.app;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.blackalertandroid.R;


import java.time.LocalDate;
import java.util.HashMap;

public class AlertHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // menu variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView toolbar;
    Button createAlertAlertHome_btn;

    int alertCount ;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("alerts");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_home);

        // <------- HOOKS -------->
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        toolbar = (ImageView) findViewById(R.id.menu_icon);
        createAlertAlertHome_btn = (Button) findViewById(R.id.createAlertButton);

        alertCount = 0;

        createAlertAlertHome_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                alertCount++;
                String blackoutAlert = Integer.toString(alertCount);
                String blackoutLocation = "Nairobi";

                LocalDate localDate = LocalDate.now();
                String timeOfBlackout = localDate.toString();

                HashMap<String, String> alert = new HashMap<>();
                alert.put("blackoutAlert", blackoutAlert);
                alert.put("blackoutLocation", blackoutLocation);
                alert.put("blackoutTime", timeOfBlackout);

                root.push().setValue(alert).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(AlertHomeActivity.this, "Alert created successfully!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

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