package com.moringaschool.blackalertandroid.ui.login_signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.moringaschool.blackalertandroid.R;

public class Login extends AppCompatActivity {

    TextView sign_up_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign_up_link = (TextView) findViewById(R.id.sign_up_link);

        sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, CreateAccountOne.class));
            }
        });
    }
}