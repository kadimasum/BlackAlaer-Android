package com.moringaschool.blackalertandroid.ui.login_signup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.blackalertandroid.R;

import java.util.HashMap;

public class CreateAccountOne extends AppCompatActivity {
    Button next_btn;
    TextView loginLink;
    EditText first_name, last_name, email, password, confirm_password;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_one);

        next_btn = (Button) findViewById(R.id.next_btn);
        loginLink = (TextView) findViewById(R.id.login_link);
        first_name = (EditText) findViewById(R.id.Create_account_first_name);
        last_name = (EditText) findViewById(R.id.Create_account_last_name);
        email = (EditText)  findViewById(R.id.Create_account_email);
        password = (EditText) findViewById(R.id.Create_account_password);
        confirm_password = (EditText) findViewById(R.id.Create_account_confirm_password);

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    saveDataToDataBase();
                    startActivity(new Intent(CreateAccountOne.this, CreateAccountTwo.class));

            }

            private void saveDataToDataBase() {
                String firstName = first_name.getText().toString().trim();
                String lastName = last_name.getText().toString().trim();
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                String confirmPassword = confirm_password.getText().toString().trim();


                if(firstName.isEmpty() && lastName.isEmpty() && Email.isEmpty() && Password.isEmpty() && confirmPassword.isEmpty()){
                    Toast.makeText(CreateAccountOne.this, "Fill all inputs to proceed", Toast.LENGTH_LONG).show();
                }
                else if(firstName.isEmpty()){
                    first_name.setError("First name required!");
                    first_name.requestFocus();
                }else if(lastName.isEmpty()){
                    last_name.setError("Last name required!");
                    last_name.requestFocus();
                }else if(Email.isEmpty()){
                    email.setError("Email required!");
                    email.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    email.setError("Use the correct email format!");
                    email.requestFocus();
                }else if(Password.isEmpty()){
                    password.setError("Password required!");
                    password.requestFocus();
                }else if(confirmPassword.isEmpty()){
                    confirm_password.setError("Password required!");
                    confirm_password.requestFocus();

                }else if(Password.length() < 6){
                    password.setError("Password must be a minimum of six characters");
                    password.requestFocus();
                }else if(!(confirmPassword.matches(Password))){
                    confirm_password.setError("Password does not match");
                    confirm_password.requestFocus();
                }


                HashMap<String, String> user = new HashMap<>();
                user.put("firstName", firstName);
                user.put("lastName", lastName);
                user.put("email", Email);
                user.put("Password", Password);

                root.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(CreateAccountOne.this, "Input saved successfully!", Toast.LENGTH_SHORT).show();
                    }
                });
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