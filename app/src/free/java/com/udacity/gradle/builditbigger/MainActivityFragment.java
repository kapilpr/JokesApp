package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.android.jokeslibrary.JokesActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment implements JokeListener {

    public MainActivityFragment() {
        // Required empty public constructor
    }
    public static final String JOKE_INTENT = "joke_intent";

    private InterstitialAd mInterstitialAd;
    private ProgressBar mProgressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mProgressBar = (ProgressBar) root.findViewById(R.id.progress_bar);

        Button button = (Button) root.findViewById(R.id.joke_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayJokesFromLibrary();
            }
        });

        return root;
    }

    private void displayJokesFromLibrary() {
        mProgressBar.setVisibility(View.VISIBLE);
        final EndpointsAsyncTask task = new EndpointsAsyncTask(this);
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener(){

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                if (mInterstitialAd.isLoaded())
                    mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                task.execute();
            }

            @Override
            public void onAdClosed() {
                task.execute();
            }
        });
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        try {
            mInterstitialAd.loadAd(adRequest);
        } catch(java.lang.NoClassDefFoundError error) {
            error.printStackTrace();
        }
    }

    @Override
    public void onJokeReceived(String joke) {
        mProgressBar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(getContext(), JokesActivity.class);
        intent.putExtra(JOKE_INTENT, joke);
        startActivity(intent);
    }
}
