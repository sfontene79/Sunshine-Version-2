package com.example.android.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private ShareActionProvider mShareProvider;
    private String mWeatherText;

    public DetailActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Announce that this fragment has menu items
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_detail, container, false);

        mWeatherText = getActivity().getIntent().getStringExtra(Intent.EXTRA_TEXT);

        TextView textView = (TextView)fragmentView.findViewById(R.id.debug_text);
        textView.setText(mWeatherText);
        return fragmentView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Complete menu with detail items
        inflater.inflate(R.menu.menu_detail_fragment, menu);

        // Get share provider
        MenuItem item = menu.findItem(R.id. action_share);
        mShareProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

        // Update share provider
        setShareIntent();
    }

    private void setShareIntent() {
        // Shared text
        String shareText = mWeatherText + " #SUNSHINE";

        // Intent used for sharing
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
        shareIntent.setType("text/plain");
        if (mShareProvider != null) {
            mShareProvider.setShareIntent(shareIntent);
        }
    }
}
