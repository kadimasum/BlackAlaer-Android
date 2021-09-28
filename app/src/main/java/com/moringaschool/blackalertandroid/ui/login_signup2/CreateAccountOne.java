package com.moringaschool.blackalertandroid.ui.login_signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.blackalertandroid.R;

public class CreateAccountOne extends AppCompatActivity {
    Button next_btn;
    TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_one);

        next_btn = (Button) findViewById(R.id.next_btn);
        loginLink = (TextView) findViewById(R.id.login_link);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccountOne.this, CreateAccountTwo.class));
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccountOne.this, Login.class));
            }
        });
    }
}