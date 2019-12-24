/* Author: Mantvydas Luksas
Student ID: R00150390
 */

/*This class allows the user to sign up as a patient. All the details are stored in the database,
using the Patient object created from the patient class.
 */
package com.example.patientapp;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SignUp_Form extends AppCompatActivity {

    int selection = 0;
    int errorCheck = 0;
    String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
    private FirebaseAuth auth;
    private FirebaseDatabase ref;
    private Patient patient;
    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__form);

        auth = FirebaseAuth.getInstance();
        final Spinner gender = findViewById(R.id.spinner);

        ref = FirebaseDatabase.getInstance();

        progress = findViewById(R.id.progressBar);

        patient = new Patient();
        final EditText firstName = findViewById(R.id.firstName);
        final EditText lastName = findViewById(R.id.lastName);
        final EditText dob = findViewById(R.id.dob);
        final EditText medicCode = findViewById(R.id.medicCode);
        final EditText gp = findViewById(R.id.gp);
        final EditText gpNumber = findViewById(R.id.gpNumber);
        final EditText gpEmail = findViewById(R.id.gpEmail);
        final EditText insuranceName = findViewById(R.id.insuranceName);
        final EditText insuranceNumber = findViewById(R.id.insuranceNumber);
        final EditText insuranceEmail = findViewById(R.id.insuranceEmail);
        final EditText emailAddress = findViewById(R.id.email_address);
        final EditText emailAddressConfirm = findViewById(R.id.email_address_confirm);
        final EditText password = findViewById(R.id.password);
        final EditText passwordConfirm = findViewById(R.id.passwordConfirm);


        TextWatcher tw = new TextWatcher() {

            private String current = "";
            final String ddmmyyyy = "DDMMYYYY";
            final Calendar cal = Calendar.getInstance();

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    //Fix for pressing delete next to a forward slash
                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    }else{
                        //This part makes sure that when we finish entering numbers
                        //the date is correct, fixing it otherwise
                        int day  = Integer.parseInt(clean.substring(0,2));
                        int mon  = Integer.parseInt(clean.substring(2,4));
                        int year = Integer.parseInt(clean.substring(4,8));

                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon-1);
                        year = (year<1900)?1900:(year>2100)?2100:year;
                        cal.set(Calendar.YEAR, year);
                        // ^ first set year for the line below to work correctly
                        //with leap years - otherwise, date e.g. 29/02/2012
                        //would be automatically corrected to 28/02/2012

                        day = (day > cal.getActualMaximum(Calendar.DATE))? cal.getActualMaximum(Calendar.DATE):day;
                        clean = String.format("%02d%02d%02d",day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    dob.setText(current);
                    dob.setSelection(sel < current.length() ? sel : current.length());



                }



            }

            @Override
            public void afterTextChanged(Editable s) {

            }


        };

        dob.addTextChangedListener(tw);

        password.setTransformationMethod(new PasswordTransformationMethod());

        passwordConfirm.setTransformationMethod(new PasswordTransformationMethod());

        ArrayAdapter<CharSequence> nAdapter = ArrayAdapter.createFromResource(this, R.array.Genders, R.layout.spinner_entry);

        nAdapter.setDropDownViewResource(R.layout.spinner_entry);
        gender.setAdapter(nAdapter);

        final Button signUp = findViewById(R.id.sign_up_button);

        final Toast tst = Toast.makeText(this, "You have successfully signed up!", Toast.LENGTH_LONG);

        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selection = position;



                signUp.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {


                            errorCheck = 0;
                            if (firstName.getText().toString().length() == 0) {
                                errorCheck = 1;
                                firstName.setError("First name is required");
                            }

                            if (lastName.getText().toString().length() == 0) {
                                errorCheck = 1;
                                lastName.setError("Last name is required");
                            }

                        if(!dob.getText().toString().matches(regex)){

                            errorCheck = 1;
                            dob.setError("Invalid date entered");
                        }
                        if (medicCode.getText().toString().length() == 0) {
                            errorCheck = 1;
                            medicCode.setError("Medic code is required");
                        }

                        if (gp.getText().toString().length() == 0) {
                            errorCheck = 1;
                            gp.setError("GP name is required");
                        }

                        if (gpNumber.getText().toString().length() == 0) {
                            errorCheck = 1;
                            gpNumber.setError("GP number is required");
                        }

                        if (gpEmail.getText().toString().length() == 0) {
                            errorCheck = 1;
                            gpEmail.setError("GP email is required");
                        }

                        if (insuranceName.getText().toString().length() == 0) {
                            errorCheck = 1;
                            insuranceName.setError("Insurance name is required");
                        }

                        if (insuranceNumber.getText().toString().length() == 0) {
                            errorCheck = 1;
                            insuranceNumber.setError("Insurance number is required");
                        }

                        if (insuranceEmail.getText().toString().length() == 0) {
                            errorCheck = 1;
                            insuranceEmail.setError("Insurance email is required");
                        }

                        if (emailAddress.getText().toString().length() == 0) {
                            errorCheck = 1;
                            emailAddress.setError("Email address is required");
                        }

                        if (!emailAddressConfirm.getText().toString().equalsIgnoreCase(emailAddress.getText().toString())) {

                            errorCheck = 1;
                            emailAddressConfirm.setError("Email address is not the same");
                        }


                        if (password.getText().toString().length() == 0) {
                            errorCheck = 1;
                            password.setError("Password is required");
                        }

                        if (!passwordConfirm.getText().toString().equalsIgnoreCase(password.getText().toString())) {
                            errorCheck = 1;
                            passwordConfirm.setError("Password is not the same");

                        }

                        if (selection == 0) {
                            errorCheck = 1;
                            TextView errorText = (TextView) gender.getSelectedView();
                            errorText.setError("Please select Gender");
                            errorText.setTextColor(Color.RED);//just to highlight that this is an error
                            errorText.setText("Please select Gender");//changes the selected item text to this

                        }

                        if(errorCheck == 0){

                            progress.setVisibility(View.VISIBLE);
                            auth.createUserWithEmailAndPassword(emailAddressConfirm.getText().toString(), passwordConfirm.getText().toString()).addOnCompleteListener(SignUp_Form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(SignUp_Form.this, "Sign Up is unsuccessful! Please try again!", Toast.LENGTH_SHORT).show();

                                        progress.setVisibility(View.GONE);
                                    }else{

                                        String userId = auth.getUid();
                                        System.out.println(userId);

                                        patient.setFirstName(firstName.getText().toString());
                                        patient.setLastName(lastName.getText().toString());
                                        patient.setDateOfBirth(dob.getText().toString());
                                        patient.setMedicCode(medicCode.getText().toString());
                                        patient.setMedicName(gp.getText().toString());
                                        patient.setMedicPhone(gpNumber.getText().toString());
                                        patient.setMedicEmail(gpEmail.getText().toString());
                                        patient.setInsuranceName(insuranceName.getText().toString());
                                        patient.setInsurancePhone(insuranceNumber.getText().toString());
                                        patient.setInsuranceEmail(insuranceEmail.getText().toString());
                                        patient.setEmail(emailAddressConfirm.getText().toString());
                                        patient.setPassword(passwordConfirm.getText().toString());
                                        patient.setGender(gender.getSelectedItem().toString());



                                        if (userId != null) {
                                            ref.getReference().child("Patients").child(userId).setValue(patient);


                                        }

                                        progress.setVisibility(View.GONE);

                                        tst.show();
                                        finish();

                                    }
                                }
                            });

                        }
                    }

                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
    }



}
