/* Author: Mantvydas Luksas
Student ID: R00150390
 */

/* This class allows the user to login as a patient or to reset the password. */

package com.example.patientapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Form extends AppCompatActivity {
private ProgressBar progressBar;
FirebaseAuth auth;
private FirebaseAuth.AuthStateListener authStateListener;
    int checkError = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login__form);

        final EditText email = findViewById(R.id.email);

        final EditText password = findViewById(R.id.pass);

        final Button login = findViewById(R.id.loginButton);

        final Button forgotPassword = findViewById(R.id.button2);

        progressBar = findViewById(R.id.progressBar);

        // Getting the current user instance using fireBase
        auth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {



            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser theUser = auth.getCurrentUser();

                if(theUser !=null){

                    Toast.makeText(Login_Form.this, "You are logged in", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login_Form.this, Home.class);
                    startActivity(i);

                }
                else{

                    Toast.makeText(Login_Form.this, "Please login", Toast.LENGTH_SHORT).show();
                }
            }
        };

        password.setTransformationMethod(new PasswordTransformationMethod());

        // When the log in button is clicked, the following actions occur.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The variable checkError will be set to 1 if any errors are found.
                // Based on the variable value certain methods will be called.
                checkError = 0;

                // If in the field there is nothing entered, an error will be displayed.
                if(email.getText().toString().length() == 0){
                    checkError = 1;
                    email.setError("Please enter email address");

                }
                // If in the field there is nothing entered, an error will be displayed.
                if(password.getText().toString().length() == 0){
                    checkError = 1;
                    password.setError("Please enter password");

                }

                // If no errors exist, the following actions occur.
                if(checkError == 0){

                    progressBar.setVisibility(View.VISIBLE);

                    // The user is signed in when correct details are typed in that match with the details found for the particular patient trying to log in.
                    auth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            // If the details do not match database records no sign in can occur and an error message will be displayed.
                            if(!task.isSuccessful()){
                                Toast.makeText(Login_Form.this, "Login is unsuccessful! Please try again!", Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);

                            // If all okay the user will be logged in.
                            }else{

                                Toast.makeText(Login_Form.this, "You are logged in", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Login_Form.this, Home.class);
                                startActivity(i);
                                progressBar.setVisibility(View.GONE);

                            }
                        }
                    });

                }
            }
        });

        // If the forgot password button is clicked the forgotPassword method is called.
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });

    }

    // Forgot password method allows opens the dialog box where the user can enter the email address to which a reset password link will be sent.
    public void forgotPassword() {


        final Dialog dialog = new Dialog(Login_Form.this);

        dialog.setContentView(R.layout.forgot_password);

        Button button = dialog.findViewById(R.id.resetPasswordButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = dialog.findViewById(R.id.userEmail);
                if(edit.getText().toString().length() == 0) {
                    Toast.makeText(Login_Form.this, "Please enter email", Toast.LENGTH_SHORT).show();
                }
                else{

                    // Checks if the email entered is valid and if it is then sends the password reset link to the email.
                    auth.sendPasswordResetEmail(edit.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText(Login_Form.this, "Password sent to your email", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                                // If not error message is displayed.
                            } else {

                                Toast.makeText(Login_Form.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });

                }
            }
        });

        // Shows the dialog box to the user.
        dialog.show();

    }

}
