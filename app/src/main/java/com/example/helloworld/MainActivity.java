package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdDisplayListener;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;
import com.startapp.android.publish.nativead.NativeAdDetails;
import com.startapp.android.publish.nativead.NativeAdPreferences;
import com.startapp.android.publish.nativead.StartAppNativeAd;
import com.startapp.android.publish.splash.SplashConfig;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static String DeviceTocken;
    Button btn_second;
    private StartAppAd startAppAd = new StartAppAd(this);
    private NativeAdDetails nativeAd = null;
    private StartAppNativeAd startAppNativeAd = new StartAppNativeAd(this);
    private ImageView imgFreeApp = null;
    private TextView txtFreeApp = null;

    /** Native Ad Callback */
    private AdEventListener nativeAdListener = new AdEventListener() {

        @Override
        public void onReceiveAd(Ad ad) {

            // Get the native ad
            ArrayList<NativeAdDetails> nativeAdsList = startAppNativeAd.getNativeAds();
            if (nativeAdsList.size() > 0){
                nativeAd = nativeAdsList.get(0);
            }

            // Verify that an ad was retrieved
            if (nativeAd != null){

                // When ad is received and displayed - we MUST send impression
                nativeAd.sendImpression(MainActivity.this);

                if (imgFreeApp != null && txtFreeApp != null){

                    // Set button as enabled
                    imgFreeApp.setEnabled(true);
                    txtFreeApp.setEnabled(true);

                    // Set ad's image
                    imgFreeApp.setImageBitmap(nativeAd.getImageBitmap());

                    // Set ad's title
                    txtFreeApp.setText(nativeAd.getTitle());
                }
            }
        }

        @Override
        public void onFailedToReceiveAd(Ad ad) {

// Error occurred while loading the native ad
            if (txtFreeApp != null) {
                txtFreeApp.setText("Error while loading Native Ad");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "208199841", true);
//        StartAppAd.showSplash(this, savedInstanceState);
        StartAppAd.showSplash(this, savedInstanceState,
                new SplashConfig()
                        .setTheme(SplashConfig.Theme.GLOOMY)
                        .setLogo(R.mipmap.ic_launcher)
                        .setAppName("Prakash Gajera")
        );


        setContentView(R.layout.activity_main);

        imgFreeApp = (ImageView) findViewById(R.id.imgFreeApp);
        txtFreeApp = (TextView) findViewById(R.id.txtFreeApp);
        if (txtFreeApp != null) {
            txtFreeApp.setText("Loading Native Ad...");
        }

        startAppNativeAd.loadAd(
                new NativeAdPreferences()
                        .setAdsNumber(1)
                        .setAutoBitmapDownload(true)
                        .setImageSize(NativeAdPreferences.NativeAdBitmapSize.SIZE150X150),
                nativeAdListener);


        btn_second= (Button) findViewById(R.id.button);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show an Ad
                startAppAd.showAd(new AdDisplayListener() {

                    /**
                     * Callback when Ad has been hidden
                     * @param ad
                     */
                    @Override
                    public void adHidden(Ad ad) {

// Run second activity right after the ad was hidden
                        Intent nextActivity = new Intent(MainActivity.this,
                                SecondActivity.class);
                        startActivity(nextActivity);
                    }

                    /**
                     * Callback when ad has been displayed
                     * @param ad
                     */
                    @Override
                    public void adDisplayed(Ad ad) {

                    }

                    @Override
                    public void adClicked(Ad arg0) {

                    }

                    @Override
                    public void adNotDisplayed(Ad ad) {

                    }
                });
            }
        });



        StartAppAd.showAd(this);
        DeviceTocken = BuildConfig.FLAVOR;

    }

    public void freeAppClick(View view){
        if (nativeAd != null){
            nativeAd.sendClick(this);
        }
    }


    @Override
    public void onBackPressed() {
        StartAppAd.onBackPressed(this);
        super.onBackPressed();
    }
}
