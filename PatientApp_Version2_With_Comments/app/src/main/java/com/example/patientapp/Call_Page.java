/* Author: Mantvydas Luksas
Student ID: R00150390
 */

/* This class allows the patient to call the GP or the insurance company. The numbers are fetched from the database.
This details re specific to the patient currently using the app. The registered GP and insurance number of a patient is
fetched and a call can be made.
 */

package com.example.patientapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Call_Page extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseDatabase ref;
    private String gpNumber;
    private String insuranceNumber;
    private static final int REQUEST_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.call_page);

        // Setting custom toolbar
        Toolbar toolbar = findViewById(R.id.app_bar7);
        setSupportActionBar(toolbar);

        // Getting the current instance of the user currently using the app.
        auth = FirebaseAuth.getInstance();

        // Getting a reference to the database.
        ref = FirebaseDatabase.getInstance();

        // Setting the variable userID to the ID number of the currently logged in user.
        // The currently logged in user ID is fetched with the method getUid().
        String userId = auth.getUid();

        // If the user truly exists then we do the following.
        if (userId != null) {
            // Calling the database and adding a listener to a particular area of the database to listen for changes in that field.
            // The field we are looking for changes in is the medicPhone field of the user.
            // We locate the current user by finding the child of the database with that userID.
            // Once that user ID is found we look at the patient's medic phone details.
            ref.getReference().child("Patients").child(userId).child("medicPhone").addValueEventListener(new ValueEventListener() {


                // When new data exists that hasn't been captured yet and stored in a variable the method onDataChange is called.
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    // We get the current gpNumber provided by the patient. We retrieve this number from the database.
                    if (dataSnapshot.getValue(String.class) != null) {
                        gpNumber = (dataSnapshot.getValue(String.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        // If the user truly exists then we do the following.
        if (userId != null) {

            // Calling the database and adding a listener to a particular area of the database to listen for changes in that field.
            // The field we are looking for changes in is the insurancePhone field of the user.
            // We locate the current user by finding the child of the database with that userID.
            // Once that user ID is found we look at the patient's insurance phone details.
            ref.getReference().child("Patients").child(userId).child("insurancePhone").addValueEventListener(new ValueEventListener() {


                // When new data exists that hasn't been captured yet and stored in a variable the method onDataChange is called.
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    // We get the current insuranceNumber provided by the patient. We retrieve this number from the database.
                    if (dataSnapshot.getValue(String.class) != null) {
                        insuranceNumber = (dataSnapshot.getValue(String.class));
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        // Creating new buttons and setting a particular layout for them.
        Button callGp = findViewById(R.id.callGP);
        Button callInsurance = findViewById(R.id.callInsurance);
        Button cancel1 = findViewById(R.id.returnHome1);

        // When the button to call the GP is clicked, the method phoneCall1 will be called.
        callGp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                phoneCall1();}
        });

        // When the button to call the insurance company is clicked, the method phoneCall2 will be called.
        callInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phoneCall2();
            }

        });

        // If the cancel button is clicked, the patient will return to the home page of the app.
        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    // These methods create the menu which is displayed from the toolbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // This method determines what events occur when a certain option is selected from a menu.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_settings:
                Intent settings = new Intent(Call_Page.this, SettingsActivity.class);
                startActivity(settings);


                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    // This method is called when the GP call button is clicked.
    public void phoneCall1(){

        // Checks if the user has granted permission to make phone calls from the app.
        if(ContextCompat.checkSelfPermission(Call_Page.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){


            ActivityCompat.requestPermissions(Call_Page.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL );

        }
        else{

            // Calls the number by calling the ACTION_CALL intent with the number details.
            String dial = "tel:" + gpNumber;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }

    }

    // This method is called when the insurance company call button is clicked.
    public void phoneCall2(){

        // Checks if the user has granted permission to make phone calls from the app.
        if(ContextCompat.checkSelfPermission(Call_Page.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){


            ActivityCompat.requestPermissions(Call_Page.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL );

        }
        else{

            // Calls the number by calling the ACTION_CALL intent with the number details.
            String dial = "tel:" + insuranceNumber;
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }


    }

    // Checks the result of the permission.
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){



            }
            else{

                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }

        }
    }

    // Disables the back button so that the user can only go back by clicking the cancel button.
    @Override
    public void onBackPressed() {

    }


}
