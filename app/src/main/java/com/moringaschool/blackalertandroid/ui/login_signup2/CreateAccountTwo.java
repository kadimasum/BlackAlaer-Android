package com.moringaschool.blackalertandroid.ui.login_signup2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.moringaschool.blackalertandroid.R;
import com.moringaschool.blackalertandroid.ui.app.AlertHomeActivity;
import com.moringaschool.blackalertandroid.ui.app.MapsActivity;

import java.util.Arrays;
import java.util.List;

public class CreateAccountTwo extends AppCompatActivity {
    Button finish_btn;
    TextView login_link;
    EditText age, location;
    RadioButton gender_male, gender_female;
    String Male, Female;

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

        // initialize places
        Places.initialize(getApplicationContext(), "AIzaSyCRwGJ26TisTv2RFwYrjGhrU6nv4SgWX8Q");

        // sets location non focusable
        location.setFocusable(false);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // initialize place field list
                List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS, Place.Field.LAT_LNG, Place.Field.NAME);

                // create intent
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fieldList).build(CreateAccountTwo.this);

                // start activity result
                startActivityForResult(intent, 100);

            }
        });


        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Age = age.getText().toString().trim();
                String Location = location.getText().toString().trim();

                if(gender_female.isChecked()){
                    Female = "Female";
                }else if(gender_male.isChecked()){
                    Male = "Male";
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
                }else {
                    startActivity(new Intent(CreateAccountTwo.this, Login.class));
                }
            }
        });
        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccountTwo.this, Login.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            // Initializes places when successful
            assert data != null;
            Place place = Autocomplete.getPlaceFromIntent(data);

            // set address on location
            location.setText(place.getAddress());
        } else if (resultCode == AutocompleteActivity.RESULT_ERROR){
            // initialize status when there is an error
            assert data != null;
            Status status = Autocomplete.getStatusFromIntent(data);

            //Display Toast
            Toast.makeText(getApplicationContext(), status.getStatusMessage(), Toast.LENGTH_LONG).show();
        }
    }
}