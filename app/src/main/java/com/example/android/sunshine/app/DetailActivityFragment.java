package com.example.android.sunshine.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_detail, container, false);

        String weatherText = getActivity().getIntent().getStringExtra(Intent.EXTRA_TEXT);

        TextView textView = (TextView)fragmentView.findViewById(R.id.debug_text);
        textView.setText(weatherText);
        return fragmentView;
    }

}
