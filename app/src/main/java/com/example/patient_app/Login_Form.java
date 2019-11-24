package com.example.patient_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login_Form extends AppCompatActivity {

    int checkError = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);



        final EditText email = (EditText)findViewById(R.id.email);
        final EditText password = (EditText)findViewById(R.id.pass);
        final Button login = (Button)findViewById(R.id.loginButton);
        final Button forgotPassword = (Button) findViewById(R.id.button2);

        password.setTransformationMethod(new PasswordTransformationMethod());


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkError = 0;
                if(email.getText().toString().length() == 0){
                    checkError = 1;
                    email.setError("Please enter email address");

                }

                if(password.getText().toString().length() == 0){
                    checkError = 1;
                    password.setError("Please enter password");

                }

                if(checkError == 0){

                   Intent homeScreen = new Intent(Login_Form.this, Home.class);
                   startActivity(homeScreen);
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });

    }

    public void forgotPassword() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        LayoutInflater inflater= this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.forgot_password,null);
        builder.setView(dialogView);
        final EditText edit =(EditText)dialogView.findViewById(R.id.email);
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


}
