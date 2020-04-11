package com.tongfu.mytestapp.advertise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.tongfu.mytestapp.R;

import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdvertiseActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertise);
        ButterKnife.bind(this);
        MobileAds.initialize(this,
                "ca-app-pub-3052609858986892~6336764053");

        List<String> testDeviceIds = Arrays.asList("39996A0BFA24CF43C5FD46F527160023");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3052609858986892/6359787117");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }

    @OnClick(R.id.btn_show_advertisement)
    public void onClick(){
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Toast.makeText(this, "广告还没准备好。", Toast.LENGTH_SHORT).show();
        }
    }
}
