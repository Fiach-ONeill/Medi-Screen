package com.example.patient_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {
static String username;
private SettingsFragment settingsFragment;
public static Context baseContext;
static SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        baseContext = getBaseContext();
        Toolbar toolbar = findViewById(R.id.app_bar8);

        setSupportActionBar(toolbar);


        settingsFragment = new SettingsFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, settingsFragment)
                .commit();


    }


    public static class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);





        }

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

            // retrieving value made in settings. The key is used to identify which setting field was changed.
            username = sharedPreferences.getString("emails", "email address");
            System.out.println(username);
        }

        @Override
        public void onResume() {
            super.onResume();
            getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

            Preference preference = findPreference(getString(R.string.ratingButton));

            Preference preference2 = findPreference(getString(R.string.paymentButton));

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




}