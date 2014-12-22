package br.org.pasqualino.menuuem.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import br.org.pasqualino.menuuem.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}
