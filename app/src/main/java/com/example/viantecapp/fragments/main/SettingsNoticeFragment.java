package com.example.viantecapp.fragments.main;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.viantecapp.R;

public class SettingsNoticeFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}