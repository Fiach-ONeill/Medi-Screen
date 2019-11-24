package com.example.patient_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Medical_History extends AppCompatActivity {


int errorCheck = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.medical_history);

        Toolbar toolbar = findViewById(R.id.app_bar4);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("");

        actionBar.setCustomView(R.layout.app_bar3);

        super.onCreate(savedInstanceState);

        Button save = (Button) findViewById(R.id.save);

        Button cancel = (Button) findViewById(R.id.cancel);

        final Toast tst = Toast.makeText(this, "Details saved!", Toast.LENGTH_LONG);
        final EditText age = (EditText) findViewById(R.id.age);
        final EditText gender = (EditText) findViewById(R.id.gender);
        final EditText cp = (EditText) findViewById(R.id.cp);
        final EditText trestbps = (EditText) findViewById(R.id.trestbps);
        final EditText cholesterol = (EditText) findViewById(R.id.cholesterol);
        final EditText fbs = (EditText) findViewById(R.id.fbs);
        final EditText thalach = (EditText) findViewById(R.id.thalach);
        final EditText exang = (EditText) findViewById(R.id.exang);
        final EditText oldpeak = (EditText) findViewById(R.id.oldPeak);
        final EditText slope = (EditText) findViewById(R.id.slope);
        final EditText ca = (EditText) findViewById(R.id.ca);
        final EditText pregnancies = (EditText) findViewById(R.id.pregnancies);
        final EditText glucose = (EditText) findViewById(R.id.glucose);
        final EditText bloodPressure = (EditText) findViewById(R.id.bloodPressure);
        final EditText skinThickness = (EditText) findViewById(R.id.skinThickness);
        final EditText insulin = (EditText) findViewById(R.id.insulin);
        final EditText bmi = (EditText) findViewById(R.id.bmi);
        final EditText diabetesPedigree = (EditText) findViewById(R.id.diabetesPedigree);
        final EditText restecg = (EditText) findViewById(R.id.restecg);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorCheck = 0;
                if (age.getText().toString().length() == 0) {
                    errorCheck = 1;
                    age.setError("No value entered");
                }

                if (gender.getText().toString().length() == 0) {
                    errorCheck = 1;
                    gender.setError("No value entered");
                }

                if (cp.getText().toString().length() == 0) {
                    errorCheck = 1;
                    cp.setError("No value entered");
                }

                if (trestbps.getText().toString().length() == 0) {
                    errorCheck = 1;
                    trestbps.setError("No value entered");
                }

                if (cholesterol.getText().toString().length() == 0) {
                    errorCheck = 1;
                    cholesterol.setError("No value entered");
                }

                if (fbs.getText().toString().length() == 0) {
                    errorCheck = 1;
                    fbs.setError("No value entered");
                }

                if (thalach.getText().toString().length() == 0) {
                    errorCheck = 1;
                    thalach.setError("No value entered");
                }

                if (exang.getText().toString().length() == 0) {
                    errorCheck = 1;
                    exang.setError("No value entered");
                }



                if (oldpeak.getText().toString().length() == 0) {
                    errorCheck = 1;
                    oldpeak.setError("No value entered");
                }

                if (slope.getText().toString().length() == 0) {
                    errorCheck = 1;
                    slope.setError("No value entered");
                }

                if (ca.getText().toString().length() == 0) {
                    errorCheck = 1;
                    ca.setError("No value entered");
                }

                if (pregnancies.getText().toString().length() == 0) {
                    errorCheck = 1;
                    pregnancies.setError("No value entered");
                }

                if (glucose.getText().toString().length() == 0) {
                    errorCheck = 1;
                    glucose.setError("No value entered");
                }

                if (bloodPressure.getText().toString().length() == 0) {
                    errorCheck = 1;
                    bloodPressure.setError("No value entered");
                }

                if (skinThickness.getText().toString().length() == 0) {
                    errorCheck = 1;
                    skinThickness.setError("No value entered");
                }

                if (insulin.getText().toString().length() == 0) {
                    errorCheck = 1;
                    insulin.setError("No value entered");
                }

                if (bmi.getText().toString().length() == 0) {
                    errorCheck = 1;
                    bmi.setError("No value entered");
                }

                if (diabetesPedigree.getText().toString().length() == 0) {
                    errorCheck = 1;
                    diabetesPedigree.setError("No value entered");
                }

                if (restecg.getText().toString().length() == 0) {
                    errorCheck = 1;
                    restecg.setError("No value entered");
                }

                if(errorCheck == 0){

                    tst.show();
                    finish();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
                Intent settings = new Intent(Medical_History.this, SettingsActivity.class);
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
