/* Author: Mantvydas Luksas
Student ID: R00150390
 */

/*This class creates the page where the patient can view their medical information or
update their medical information. The medical information details are then stored in the database
for the particular patient.
 */

package com.example.patientapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Medical_History extends AppCompatActivity {

FirebaseAuth auth;
private DatabaseReference ref;
private FirebaseDatabase db;
private Toast tst;
private EditText age;
private EditText gender;
private EditText cp;
private EditText trestbps;
private EditText cholesterol;
private EditText fbs;
private EditText thalach;
private EditText exang;
private EditText oldpeak;
private EditText slope;
private EditText ca;
private EditText pregnancies;
private EditText glucose;
private EditText bloodPressure;
private EditText skinThickness;
private EditText insulin;
private EditText bmi;
private EditText diabetesPedigree;
private EditText restecg;

int errorCheck = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.medical_history);

        // Setting the custom toolbar.
        Toolbar toolbar = findViewById(R.id.app_bar4);

        setSupportActionBar(toolbar);

        // Getting the currently logged in user.
        auth = FirebaseAuth.getInstance();

        final String userId = auth.getUid();

        // Getting the reference to the database.
        ref = FirebaseDatabase.getInstance().getReference();

        final Toast tst = Toast.makeText(this, "Details saved!", Toast.LENGTH_LONG);

        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        cp = findViewById(R.id.cp);
        trestbps = findViewById(R.id.trestbps);
        cholesterol = findViewById(R.id.cholesterol);
        fbs = findViewById(R.id.fbs);
        thalach = findViewById(R.id.thalach);
        exang = findViewById(R.id.exang);
        oldpeak = findViewById(R.id.oldPeak);
        slope =  findViewById(R.id.slope);
        ca =  findViewById(R.id.ca);
        pregnancies =  findViewById(R.id.pregnancies);
        glucose = findViewById(R.id.glucose);
        bloodPressure = findViewById(R.id.bloodPressure);
        skinThickness = findViewById(R.id.skinThickness);
        insulin = findViewById(R.id.insulin);
        bmi = findViewById(R.id.bmi);
        diabetesPedigree = findViewById(R.id.diabetesPedigree);
        restecg = findViewById(R.id.restecg);

        // For the logged in user the medical history is shown on record by the following actions.
        if (userId != null) {
            ref.child("Patients").child(userId).child("age").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    age.setText("age: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("gender").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(String.class) != null)
                    gender.setText("gender: " + dataSnapshot.getValue(String.class));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("cp").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    cp.setText("cp: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("trestbps").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    trestbps.setText("trestbps: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("cholesterol").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    cholesterol.setText("cholesterol: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("fbs").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    fbs.setText("fbs: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("thalach").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    thalach.setText("thalach: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("exang").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    exang.setText("exang: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("oldpeak").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    oldpeak.setText("old peak: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("slope").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    slope.setText("slope: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("ca").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    ca.setText("Your ca: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("noPregnancies").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    pregnancies.setText("pregnancies: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("glucose").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    glucose.setText("glucose: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("bloodPressure").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    bloodPressure.setText("bPressure: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("skinThickness").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    skinThickness.setText("skin thickness: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("insulin").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    insulin.setText("insulin: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("bmi").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(long.class) != null)
                    bmi.setText("bmi: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("diabetesPedigree").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.getValue(long.class) != null)
                    diabetesPedigree.setText("diabetes: " + Long.toString(dataSnapshot.getValue(long.class)));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        if (userId != null) {
            ref.child("Patients").child(userId).child("restecg").addValueEventListener(new ValueEventListener() {


                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    if (dataSnapshot.getValue(long.class) != null) {
                        restecg.setText("restecg: " + Long.toString(dataSnapshot.getValue(long.class)));
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }


        // When the user clicks on the box the already displayed data is cleared.
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age.getText().clear();
            }
        });

        gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender.getText().clear();
            }
        });

        cp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cp.getText().clear();
            }
        });

        trestbps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trestbps.getText().clear();
            }
        });

        cholesterol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cholesterol.getText().clear();
            }
        });

        fbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fbs.getText().clear();
            }
        });

        thalach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thalach.getText().clear();
            }
        });

        exang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exang.getText().clear();
            }
        });

        oldpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oldpeak.getText().clear();
            }
        });

        slope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slope.getText().clear();
            }
        });

        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ca.getText().clear();
            }
        });

        pregnancies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pregnancies.getText().clear();
            }
        });

        glucose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                glucose.getText().clear();
            }
        });

        bloodPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bloodPressure.getText().clear();
            }
        });

        skinThickness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skinThickness.getText().clear();
            }
        });

        insulin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insulin.getText().clear();
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bmi.getText().clear();
            }
        });

        diabetesPedigree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diabetesPedigree.getText().clear();
            }
        });

        restecg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restecg.getText().clear();
            }
        });

        final Patient patient = new Patient();

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("");

        actionBar.setCustomView(R.layout.app_bar3);

        super.onCreate(savedInstanceState);

        Button save = findViewById(R.id.save);

        Button cancel = findViewById(R.id.cancel);

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

                // If no errors exist the patient class is used to set the new information to the new patient object.
                // This patient object will be sent to the database holding all the values.
                if(errorCheck == 0) {

                    try{
                        patient.setAge(Integer.parseInt(age.getText().toString()));
                        patient.setGender(gender.getText().toString());
                        patient.setCp(Integer.parseInt(cp.getText().toString()));
                        patient.setTrestbps(Integer.parseInt(trestbps.getText().toString()));
                        patient.setCholesterol(Integer.parseInt(cholesterol.getText().toString()));
                        patient.setFbs(Integer.parseInt(fbs.getText().toString()));
                        patient.setThalach(Integer.parseInt(thalach.getText().toString()));
                        patient.setExang(Integer.parseInt(exang.getText().toString()));
                        patient.setOldpeak(Integer.parseInt(oldpeak.getText().toString()));
                        patient.setSlope(Integer.parseInt(slope.getText().toString()));
                        patient.setCa(Integer.parseInt(ca.getText().toString()));
                        patient.setNoPregnancies(Integer.parseInt(pregnancies.getText().toString()));
                        patient.setGlucose(Integer.parseInt(glucose.getText().toString()));
                        patient.setBloodPressure(Integer.parseInt(bloodPressure.getText().toString()));
                        patient.setSkinThickness((Integer.parseInt(skinThickness.getText().toString())));
                        patient.setInsulin(Integer.parseInt(insulin.getText().toString()));
                        patient.setBmi(Integer.parseInt(bmi.getText().toString()));
                        patient.setDiabetesPedigree(Integer.parseInt(diabetesPedigree.getText().toString()));
                        patient.setRestecg(Integer.parseInt(restecg.getText().toString()));

                        // The patient object values are sent to the database.
                        ref.child("Patients").child(userId).child("age").setValue(patient.getAge());
                        ref.child("Patients").child(userId).child("gender").setValue(patient.getGender());
                        ref.child("Patients").child(userId).child("cp").setValue(patient.getCp());
                        ref.child("Patients").child(userId).child("trestbps").setValue(patient.getTrestbps());
                        ref.child("Patients").child(userId).child("cholesterol").setValue(patient.getCholesterol());
                        ref.child("Patients").child(userId).child("fbs").setValue(patient.getFbs());
                        ref.child("Patients").child(userId).child("thalach").setValue(patient.getThalach());
                        ref.child("Patients").child(userId).child("exang").setValue(patient.getExang());
                        ref.child("Patients").child(userId).child("oldpeak").setValue(patient.getOldpeak());
                        ref.child("Patients").child(userId).child("slope").setValue(patient.getSlope());
                        ref.child("Patients").child(userId).child("ca").setValue(patient.getCa());
                        ref.child("Patients").child(userId).child("noPregnancies").setValue(patient.getNoPregnancies());
                        ref.child("Patients").child(userId).child("glucose").setValue(patient.getGlucose());
                        ref.child("Patients").child(userId).child("bloodPressure").setValue(patient.getBloodPressure());
                        ref.child("Patients").child(userId).child("skinThickness").setValue(patient.getSkinThickness());
                        ref.child("Patients").child(userId).child("insulin").setValue(patient.getInsulin());
                        ref.child("Patients").child(userId).child("bmi").setValue(patient.getBmi());
                        ref.child("Patients").child(userId).child("diabetesPedigree").setValue(patient.getDiabetesPedigree());
                        ref.child("Patients").child(userId).child("restecg").setValue(patient.getRestecg());

                        tst.show();
                        finish();
                    }catch(Exception e){

                        age.getText().clear();
                        gender.getText().clear();
                        cp.getText().clear();
                        trestbps.getText().clear();
                        cholesterol.getText().clear();
                        fbs.getText().clear();
                        thalach.getText().clear();
                        exang.getText().clear();
                        oldpeak.getText().clear();
                        slope.getText().clear();
                        ca.getText().clear();
                        pregnancies.getText().clear();
                        glucose.getText().clear();
                        bloodPressure.getText().clear();
                        skinThickness.getText().clear();
                        insulin.getText().clear();
                        bmi.getText().clear();
                        diabetesPedigree.getText().clear();
                        restecg.getText().clear();
                        Toast.makeText(Medical_History.this, "Data not saved, please edit values", Toast.LENGTH_SHORT).show();

                    }
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

    // Creating the menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // This method determines what events occur when a certain option is selected from a menu.
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

    // Disables the back button so that the user can only go back by clicking the cancel button.
    @Override
    public void onBackPressed() {

    }


}
