package com.example.patient_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Rating_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.rating_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar8);

        setSupportActionBar(toolbar);

        RatingBar rating = (RatingBar) findViewById(R.id.rating);

        final TextView value = (TextView) findViewById(R.id.value);

        Button send = (Button) findViewById(R.id.send2);

        Button cancel = (Button) findViewById(R.id.cancel2);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("Your value: " + rating);
            }

        });

        final Toast tst = Toast.makeText(this, "Message Sent!", Toast.LENGTH_LONG);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tst.show();
                Intent home = new Intent(Rating_Page.this, Home.class);
                startActivity(home);
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

    @Override
    public void onBackPressed() {

    }

}
