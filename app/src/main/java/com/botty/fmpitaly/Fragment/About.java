package com.botty.fmpitaly.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.botty.fmpitaly.R;


/**
 * Created by BottyIvan on 19/01/15.
 */
public class About extends PreferenceFragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.about);

    }
}
