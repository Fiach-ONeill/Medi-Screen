/* Author: Mantvydas Luksas
Student ID: R00150390
*/


/* This class allows the patient to contact the GP or insurance by email. */

package com.example.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class Contact_Page extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference ref;
    private List<CharSequence> optionList;
    private String gpEmail;
    private String insuranceEmail;
    private String emailSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.contact_page);
        Spinner emails = findViewById(R.id.spinner1);

        // Setting custom toolbar.
        Toolbar toolbar = findViewById(R.id.app_bar6);
        setSupportActionBar(toolbar);

        Button send = findViewById(R.id.send);
        Button cancel = findViewById(R.id.cancel1);

        final EditText form = findViewById(R.id.form);

        // Creating a reference to the database of the app.
        ref = FirebaseDatabase.getInstance().getReference();
        // Getting the currently logged in user instance.
        auth = FirebaseAuth.getInstance();

        optionList = new ArrayList<>();

        optionList.add("Select recipient");

        // Getting logged in patient id.
        String userId = auth.getUid();

        final Toast tst = Toast.makeText(this, "Message Sent!", Toast.LENGTH_LONG);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast message shown when clicked.
                tst.show();
                finish();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Returning to the home page.
                finish();
            }
        });


        // If the user truly exists then do the following.
        if (userId != null) {

            // Calling the database and adding a listener to a particular area of the database to listen for changes in that field.
            // The field we are looking for changes in is the medicEmail field of the user.
            // We locate the current user by finding the child of the database with that userID.
            // Once that user ID is found we look at the patient's medic email details.
            ref.child("Patients").child(userId).child("medicEmail").addValueEventListener(new ValueEventListener() {

                // When new data exists that hasn't been captured yet and stored in a variable the method onDataChange is called.
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.getValue(String.class) != null) {
                        gpEmail = (dataSnapshot.getValue(String.class));
                        optionList.add(gpEmail);
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
            // The field we are looking for changes in is the insuranceEmail field of the user.
            // We locate the current user by finding the child of the database with that userID.
            // Once that user ID is found we look at the patient's insurance email details.
            ref.child("Patients").child(userId).child("insuranceEmail").addValueEventListener(new ValueEventListener() {

                // When new data exists that hasn't been captured yet and stored in a variable the method onDataChange is called.
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.getValue(String.class) != null) {
                        insuranceEmail = (dataSnapshot.getValue(String.class));
                        optionList.add(insuranceEmail);
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        ArrayAdapter<CharSequence> nAdapter2 = new ArrayAdapter<>(this, R.layout.spinner_entry, optionList);

        emails.setAdapter(nAdapter2);

        super.onCreate(savedInstanceState);

        // The method listens to what was selected as a recipient from the recipient list.
        emails.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // If it was the first option, the emailSelection variable is set to the gpEmail variable which stores the GP email fetched from the database.
                if (position == 1){

                    emailSelection = gpEmail;
                }
                // If it was the second option, the emailSelection variable is set to the insuranceEmail variable which stores the insurance email fetched from the database.
                if(position == 2){

                    emailSelection = insuranceEmail;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // When the send button is clicked the following actions will occur.
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to = emailSelection;
                String subject = "Patient Message";
                String message = form.getText().toString();

                // Calling a new intent to open the email client.
                Intent email = new Intent(Intent.ACTION_SEND);
                // In the email client placing the recipient email address in the TO section.
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                // In the email client placing the subject in the subject field.
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                // In the email client placing the message of the patient in the body field.
                email.putExtra(Intent.EXTRA_TEXT, message);

                //need this to prompt email client only
                email.setType("message/rfc822");

                // Starting the activity.
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

    }

    // Creating the menu.
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
                Intent settings = new Intent(Contact_Page.this, SettingsActivity.class);
                startActivity(settings);

                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    // Disables the back button so that the user can only go back by clicking the cancel button.
    @Override
    public void onBackPressed() {

    }


}
