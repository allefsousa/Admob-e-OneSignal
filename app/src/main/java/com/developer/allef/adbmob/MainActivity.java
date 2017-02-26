package com.developer.allef.adbmob;

import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private AdView aadView;
    private InterstitialAd inter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //173181c5-0a60-4472-a7b6-4e6ba7326180
        setContentView(R.layout.activity_main);
        inter = new InterstitialAd(this);
        inter.setAdUnitId(getString(R.string.admobinterstitial));

        Bannertelatoda();

        inter.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Bannertelatoda();
                super.onAdClosed();

            }
        });


        button = (Button)findViewById(R.id.btnMostrarBanner);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               inter.show();
            }
        });


        aadView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        aadView.loadAd(adRequest);
    }

    @Override
    public void onPause() {
        if(aadView != null){
            aadView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(aadView != null){
            aadView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if(aadView != null){
            aadView.destroy();
        }
        super.onDestroy();
    }
    private void Bannertelatoda(){
        AdRequest adRequest = new AdRequest.Builder().build();
        inter.loadAd(adRequest);
    }
}
