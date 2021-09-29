package com.moringaschool.blackalertandroid.ui.login_signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.moringaschool.blackalertandroid.R;
import com.moringaschool.blackalertandroid.ui.app.MapsActivity;

public class Login extends AppCompatActivity {

    TextView sign_up_link;
    Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign_up_link = (TextView) findViewById(R.id.sign_up_link);
        login_btn = (Button) findViewById(R.id.login_btn);

        sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, CreateAccountOne.class));
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, MapsActivity.class));
            }
        });
    }
}