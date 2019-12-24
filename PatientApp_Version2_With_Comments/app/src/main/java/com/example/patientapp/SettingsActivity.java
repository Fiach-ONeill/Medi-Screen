/* Author: Mantvydas Luksas
Student ID: R00150390
 */

/* This class creates the settings page */
package com.example.patientapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Objects;


public class SettingsActivity extends AppCompatActivity {
static String newEmailAddress;
private SettingsFragment settingsFragment;
public static Context baseContext;
static FirebaseAuth auth;
static FirebaseDatabase ref;
private static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        auth = FirebaseAuth.getInstance();
        baseContext = getBaseContext();
        Toolbar toolbar = findViewById(R.id.app_bar8);

        String userId = auth.getUid();

        ref = FirebaseDatabase.getInstance();

        setSupportActionBar(toolbar);

        settingsFragment = new SettingsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, settingsFragment)
                .commit();


        if (userId != null) {
            ref.getReference().child("Patients").child(userId).child("email").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.getValue(String.class) != null)
                        email = dataSnapshot.getValue(String.class);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            EditTextPreference preference = findPreference("emails");


            preference.setText(email);
        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

            // retrieving value made in settings. The key is used to identify which setting field was changed.
            newEmailAddress = sharedPreferences.getString("emails", "email address");
            Objects.requireNonNull(auth.getCurrentUser()).updateEmail(newEmailAddress);
            System.out.println(newEmailAddress);

        }

        @Override
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

            Preference preference = findPreference(getString(R.string.ratingButton));

            Preference preference2 = findPreference(getString(R.string.paymentButton));

            Preference preference3 = findPreference(getString(R.string.log_out));

            preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {

                @Override
                public boolean onPreferenceClick(Preference preference) {
                    rating();
                    return true;
                }
            });

            preference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    payment();
                    return true;
                }
            });

            preference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    FirebaseAuth.getInstance().signOut();
                    signOut();
                    return true;
                }
            });

        }

        @Override
        public void onPause() {
            getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
            super.onPause();
        }


    }

    public static void rating(){

        Intent test = new Intent(SettingsActivity.baseContext, Rating_Page.class);
        test.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SettingsActivity.baseContext.startActivity(test);


    }

    public static void payment(){

        Intent test = new Intent(SettingsActivity.baseContext, Payment_Page.class);
        test.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SettingsActivity.baseContext.startActivity(test);


    }

    public static void signOut(){

        Intent test = new Intent(SettingsActivity.baseContext, MainActivity.class);
        test.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SettingsActivity.baseContext.startActivity(test);
    }

}