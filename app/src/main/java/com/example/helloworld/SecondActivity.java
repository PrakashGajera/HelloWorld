package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.startapp.android.publish.Ad;
import com.startapp.android.publish.AdEventListener;
import com.startapp.android.publish.nativead.NativeAdDetails;
import com.startapp.android.publish.nativead.NativeAdPreferences;
import com.startapp.android.publish.nativead.StartAppNativeAd;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private NativeAdDetails nativeAd = null;
    private StartAppNativeAd startAppNativeAd = new StartAppNativeAd(this);
    private ImageView imgFreeApp = null;
    private TextView txtFreeApp = null;
    //55a9a174-e7a5-468e-817c-6477db941f3d

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
                nativeAd.sendImpression(SecondActivity.this);

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
        setContentView(R.layout.activity_second);

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
    }
}
