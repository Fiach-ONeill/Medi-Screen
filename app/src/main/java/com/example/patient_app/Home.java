package com.example.patient_app;

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

        Toolbar toolbar = findViewById(R.id.app_bar3);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("");

        actionBar.setCustomView(R.layout.app_bar2);

        final Button medicalHistoryButton = (Button) findViewById(R.id.medicalHistory);
        final Button AiButton = (Button) findViewById(R.id.media_Ai);
        final Button supportButton = (Button) findViewById(R.id.support);
        final Button call = (Button) findViewById(R.id.requestProfessional);

        medicalHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent medicalHistory = new Intent(Home.this, Medical_History.class);
                startActivity(medicalHistory);
            }

        });

        AiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mediAi = new Intent(Home.this, Medi_Ai.class);
                startActivity(mediAi);
            }
        });

        supportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent support = new Intent(Home.this, Contact_Page.class);
                startActivity(support);

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent requestProfessional = new Intent(Home.this, Call_Page.class);
                startActivity(requestProfessional);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

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

    @Override
    public void onBackPressed() {

    }




}
