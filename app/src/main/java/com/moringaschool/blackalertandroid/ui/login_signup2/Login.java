package com.moringaschool.blackalertandroid.ui.login_signup2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moringaschool.blackalertandroid.R;
import com.moringaschool.blackalertandroid.ui.app.AlertHomeActivity;
import com.moringaschool.blackalertandroid.ui.app.MapsActivity;

public class Login extends AppCompatActivity {

    TextView sign_up_link;
    Button login_btn;
    EditText login_email, login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign_up_link = (TextView) findViewById(R.id.sign_up_link);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_email = (EditText) findViewById(R.id.login_email);
        login_password = (EditText) findViewById(R.id.login_password);


        sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, CreateAccountOne.class));
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEmail = login_email.getText().toString().trim();
                String loginPassword = login_password.getText().toString();

                if(loginEmail.isEmpty() && loginPassword.isEmpty()){
                    Toast.makeText(Login.this, "Email and password required!", Toast.LENGTH_LONG).show();
                } else  if(loginEmail.isEmpty()){
                    login_email.setError("Email required!");
                    login_email.requestFocus();
                }else if(loginPassword.isEmpty()){
                    login_password.setError("Password required!");
                    login_password.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(loginEmail).matches()){
                    login_email.setError("Use the correct email format");
                    login_email.requestFocus();
                }else if(loginPassword.length() < 6){
                    login_password.setError("Password must be a minimum of 6 values");
                }else {
                    startActivity(new Intent(Login.this, AlertHomeActivity.class));
                }
            }

        });

    }
}