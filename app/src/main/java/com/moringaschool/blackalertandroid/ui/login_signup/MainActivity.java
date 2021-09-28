package com.moringaschool.blackalertandroid.ui.login_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.moringaschool.blackalertandroid.R;
import com.moringaschool.blackalertandroid.ui.login_signup2.CreateAccountOne;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

     Button getStarted_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStarted_btn = (Button) findViewById(R.id.textButton);

        getStarted_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccountOne.class));
            }
        });
    }
}