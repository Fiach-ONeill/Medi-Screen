/* Author: Mantvydas Luksas
Student ID: R00150390
 */
package com.example.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Rating_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.rating_page);

        // Setting the custom toolbar.
        Toolbar toolbar = findViewById(R.id.app_bar8);

        setSupportActionBar(toolbar);

        final EditText form = findViewById(R.id.form);

        RatingBar rating = findViewById(R.id.rating);

        final TextView value = findViewById(R.id.value);

        Button send = findViewById(R.id.send2);

        Button cancel = findViewById(R.id.cancel2);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("Your rating: " + rating);
            }

        });

        final Toast tst = Toast.makeText(this, "Message Sent!", Toast.LENGTH_LONG);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Sending message with the email client.
                String to = "mantvydas.luksas@gmail.com";
                String subject = "Patient app feedback";
                String message = form.getText().toString();

                Intent email1 = new Intent(Intent.ACTION_SEND);
                email1.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email1.putExtra(Intent.EXTRA_SUBJECT, subject);
                email1.putExtra(Intent.EXTRA_TEXT, message + "\n\n"+ value.getText().toString());
                email1.setType("message/rfc822");
                startActivity(Intent.createChooser(email1, "Choose an Email client :"));



            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        super.onCreate(savedInstanceState);
    }

    // Disables the back button so that the user can only go back by clicking the cancel button.
    @Override
    public void onBackPressed() {

    }

}
