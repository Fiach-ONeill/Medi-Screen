/* Contact form spinner must have GP email address and the insurance email address
either from the registration editText or the database */

package com.example.patient_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Contact_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.contact_page);
        Spinner emails = (Spinner) findViewById(R.id.spinner1);

        Toolbar toolbar = findViewById(R.id.app_bar6);
        setSupportActionBar(toolbar);

        Button send = (Button) findViewById(R.id.send);
        Button cancel = (Button) findViewById(R.id.cancel1);

        final Toast tst = Toast.makeText(this, "Message Sent!", Toast.LENGTH_LONG);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tst.show();
                finish();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayAdapter<CharSequence> nAdapter2 = ArrayAdapter.createFromResource(this, R.array.Emails, R.layout.spinner_entry);

        emails.setAdapter(nAdapter2);


              super.onCreate(savedInstanceState);

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
                Intent settings = new Intent(Contact_Page.this, SettingsActivity.class);
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
