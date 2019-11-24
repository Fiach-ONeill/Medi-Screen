package com.example.patient_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        Button login = findViewById(R.id.login_button);
        Button register = findViewById(R.id.register_button);

        ActionBar actionbar = getSupportActionBar();

        actionbar.setTitle("");
        actionbar.setCustomView(R.layout.app_bar);

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
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_settings:

                break;

        }
        return super.onOptionsItemSelected(item);
    }
*/
    private void startPage(){

        Intent launchStartPage = new Intent(MainActivity.this, Login_Form.class);
        startActivity(launchStartPage);
    }

    private void startSignUpPage(){

        Intent launchSignUpPage = new Intent(MainActivity.this, SignUp_Form.class);
        startActivity(launchSignUpPage);

    }

    @Override
    public void onBackPressed() {

    }


}
