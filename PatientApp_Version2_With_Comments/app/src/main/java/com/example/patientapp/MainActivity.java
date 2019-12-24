/* Author: Mantvydas Luksas
Student ID: R00150390
 */

/* This class is the main page when the app is started by the user, if not logged in. */
package com.example.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

DatabaseReference reff;
private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Sets the custom toolbar.
        Toolbar toolbar = findViewById(R.id.app_bar);

        setSupportActionBar(toolbar);

        Button login = findViewById(R.id.login_button);

        Button register = findViewById(R.id.register_button);

        ActionBar actionbar = getSupportActionBar();

        actionbar.setTitle("");

        actionbar.setCustomView(R.layout.app_bar);

        // Getting a reference to the currently logged in user.
        mAuth = FirebaseAuth.getInstance();

        // Getting a reference to the database.
        reff = FirebaseDatabase.getInstance().getReference();

        login.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                startPage();
            }
        });

        register.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                startSignUpPage();
            }
        });
    }
    // If the log in button is clicked, the user is directed to the login page.
    private void startPage(){

        Intent launchStartPage = new Intent(MainActivity.this, Login_Form.class);
        startActivity(launchStartPage);
    }

    // If the sign up button is clicked, the user is directed to the sign up page.
    private void startSignUpPage(){

        Intent launchSignUpPage = new Intent(MainActivity.this, SignUp_Form.class);
        startActivity(launchSignUpPage);

    }

    @Override
    public void onBackPressed() {

    }

}
