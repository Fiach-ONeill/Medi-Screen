/* Author: Mantvydas Luksas
Student ID: R00150390
 */


/*This class provides the main navigation page for the patient when logged in. It consists of
four buttons and a settings button at the top-right corner of the toolbar.
 */

package com.example.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);

        // Setting custom toolbar.
        Toolbar toolbar = findViewById(R.id.app_bar3);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("");

        actionBar.setCustomView(R.layout.app_bar2);

        final Button medicalHistoryButton = findViewById(R.id.medicalHistory);

        final Button AiButton = findViewById(R.id.media_Ai);

        final Button supportButton = findViewById(R.id.support);

        final Button call = findViewById(R.id.requestProfessional);


        medicalHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the medical history button is clicked the patient will be directed to the medical history page.
                Intent medicalHistory = new Intent(Home.this, Medical_History.class);

                startActivity(medicalHistory);
            }

        });

        AiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When the AI button is clicked the patient will be directed to the AI page.
                Intent mediAi = new Intent(Home.this, Medi_Ai.class);

                startActivity(mediAi);
            }
        });

        supportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // When the support button is clicked the patient will be directed to the contact page.
                Intent support = new Intent(Home.this, Contact_Page.class);

                startActivity(support);

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the call button is clicked the patient will be directed to the call page.
                Intent requestProfessional = new Intent(Home.this, Call_Page.class);

                startActivity(requestProfessional);
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

                Intent settings = new Intent(Home.this, SettingsActivity.class);

                startActivity(settings);

                break;

            default:

                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    // Disables the back button so that the user won't go back to the login page as the user is already logged in.
    @Override
    public void onBackPressed() {

    }




}
