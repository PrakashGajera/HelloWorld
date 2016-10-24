package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;

public class Activity_Amzon_ads extends AppCompatActivity {

    private AdLayout adView; // The ad view used to load and display the ad.
    private static final String APP_KEY = "sample-app-v1_pub-2"; // Sample Application Key. Replace this value with your Application Key.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amzon_ads);

        AdRegistration.setAppKey(APP_KEY);

        // Programmatically create the AmazonAdLayout
        this.adView = new AdLayout(this);
        LinearLayout layout = (LinearLayout) findViewById(R.id.mainLayout);
        // Set the correct width and height of the ad
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layout.addView(this.adView,lp);

        // If you declared AdLayout in your xml you would instead
        // replace the 3 lines above with the following line:
        //   this.adView = (AdLayout) findViewById(R.id.adview);

        AdTargetingOptions adOptions = new AdTargetingOptions();
        // Optional: Set ad targeting options here.
        this.adView.loadAd(adOptions); // Retrieves an ad on background thread

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        this.adView.destroy();
    }

}
