package com.moringaschool.blackalertandroid.ui.login_signup2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.blackalertandroid.R;
import com.moringaschool.blackalertandroid.ui.app.AlertHomeActivity;
import com.moringaschool.blackalertandroid.ui.app.MapsActivity;

import java.util.HashMap;

public class CreateAccountTwo extends AppCompatActivity {
    Button finish_btn;
    TextView login_link;
    EditText age, location;
    RadioButton gender_male, gender_female;
    String Gender;

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference().child("users");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_two);

        finish_btn =(Button) findViewById(R.id.finish_btn);
        login_link = (TextView) findViewById(R.id.login_link);
        age = (EditText) findViewById(R.id.Create_account_age);
        location = (EditText) findViewById(R.id.Create_account_location);
        gender_female = (RadioButton) findViewById(R.id.create_account_radio_female);
        gender_male = (RadioButton) findViewById(R.id.create_account_radio_male);

        Intent intent2 = getIntent();
        String firstName = intent2.getStringExtra("firstName");
        String lastName = intent2.getStringExtra("lastName");
        String Email = intent2.getStringExtra("Email");
        String Password = intent2.getStringExtra("Password");

        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveDataToDatabase();
                startActivity(new Intent(CreateAccountTwo.this, Login.class));

            }

            private void saveDataToDatabase() {
                String Age = age.getText().toString().trim();
                String Location = location.getText().toString().trim();

                if(gender_female.isChecked()){
                    Gender = "Female";
                }else if(gender_male.isChecked()){
                    Gender = "Male";
                }

                if(Age.isEmpty() && Location.isEmpty() && (!(gender_female.isChecked()) || !(gender_male.isChecked()))){
                    Toast.makeText(CreateAccountTwo.this, "Fill all form inputs and try again!", Toast.LENGTH_SHORT).show();
                }
                else if(Age.isEmpty()){
                    age.setError("Age required!");
                    age.requestFocus();
                }else if(Location.isEmpty()){
                    location.setError("Location required!");
                    location.requestFocus();
                }

                HashMap<String, String> user = new HashMap<>();
                user.put("firstName", firstName);
                user.put("lastName", lastName);
                user.put("Email", Email);
                user.put("Password", Password);
                user.put("Gender", Gender);
                user.put("Age", Age);
                user.put("Location", Location);

                root.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(CreateAccountTwo.this, "Input saved successfully!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccountTwo.this, Login.class));
            }
        });
    }
}