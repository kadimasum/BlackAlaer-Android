package com.moringaschool.blackalertandroid.ui.login_signup2;

import static com.moringaschool.blackalertandroid.ui.constants.constants.USER_EMAIL;
import static com.moringaschool.blackalertandroid.ui.constants.constants.USER_PASSWORD;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.blackalertandroid.R;
import com.moringaschool.blackalertandroid.ui.app.AlertHomeActivity;
import com.moringaschool.blackalertandroid.ui.app.MapsActivity;

public class Login extends AppCompatActivity {

    TextView sign_up_link;
    Button login_btn;
    EditText login_email, login_password;

    FirebaseAuth mAuth;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sign_up_link = (TextView) findViewById(R.id.sign_up_link);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_email = (EditText) findViewById(R.id.login_email);
        login_password = (EditText) findViewById(R.id.login_password);

        mAuth = FirebaseAuth.getInstance();

//        Shared preferences
        sharedPreferences = getSharedPreferences("login_ref", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        login_email.setText(sharedPreferences.getString("login_email", null));
        login_password.setText(sharedPreferences.getString("login_password", null));

        sign_up_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, CreateAccountOne.class));
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = login_email.getText().toString().trim();
                String Password = login_password.getText().toString().trim();

                editor.putString(USER_EMAIL, Email).apply();
                editor.putString(USER_PASSWORD, Password).apply();

                if(Email.isEmpty() && Password.isEmpty()){
                    Toast.makeText(Login.this, "Email and password required!", Toast.LENGTH_LONG).show();
                } else  if(Email.isEmpty()){
                    login_email.setError("Email required!");
                    login_email.requestFocus();
                }else if(Password.isEmpty()){
                    login_password.setError("Password required!");
                    login_password.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    login_email.setError("Use the correct email format");
                    login_email.requestFocus();
                }else if(Password.length() < 6){
                    login_password.setError("Password must be a minimum of 6 values");
                }

                else {

                    startActivity(new Intent(Login.this, AlertHomeActivity.class));

//                    mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                startActivity(new Intent(Login.this, AlertHomeActivity.class));
//                            } else {
//                                Toast.makeText(Login.this, "Failed to login! Please check your credentials.", Toast.LENGTH_SHORT).show();
//
//                            }
//                        }
//                    });
                }

            }

        });

    }
}