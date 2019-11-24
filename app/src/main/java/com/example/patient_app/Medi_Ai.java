package com.example.patient_app;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Medi_Ai extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.medi_ai);

        Toolbar toolbar = findViewById(R.id.app_bar5);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("");

        actionBar.setCustomView(R.layout.app_bar4);
        super.onCreate(savedInstanceState);

        Button diagnostic = (Button) findViewById(R.id.diagnostic);

        Button returnHome = (Button) findViewById(R.id.returnHome);


        diagnostic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                diagnostic();

            }
        });

        returnHome.setOnClickListener(new View.OnClickListener() {
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
                Intent settings = new Intent(Medi_Ai.this, SettingsActivity.class);
                startActivity(settings);

                break;

            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    private void diagnostic(){


        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        LayoutInflater inflater= this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.diagnostic,null);
        String diagnosis = "Diagnostic message is displayed here";
        builder.setView(dialogView);

        // Setting the diagnostic message to the dialog
        builder.setMessage(diagnosis);


        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Cancel", new     DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog b = builder.create();
        b.show();

    }

    @Override
    public void onBackPressed() {

    }




}

