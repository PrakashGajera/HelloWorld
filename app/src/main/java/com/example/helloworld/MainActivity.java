package com.example.helloworld;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;
import com.startapp.android.publish.nativead.NativeAdDetails;
import com.startapp.android.publish.nativead.StartAppNativeAd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static String DeviceTocken;
    Button btn_second;
    private StartAppAd startAppAd = new StartAppAd(this);
    private NativeAdDetails nativeAd = null;
    private StartAppNativeAd startAppNativeAd = new StartAppNativeAd(this);
    private ImageView imgFreeApp = null;
    private TextView txtFreeApp = null;

    InputStream in;
    BufferedReader reader;
    String line;
    private File wallpaperDirectory;
    private FileOutputStream output;
    private int count;
    private String filename;
    private String laststringa;


/*
    */

    /**
     * Native Ad Callback
     *//*

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
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "208199841", true);
//        StartAppAd.showSplash(this, savedInstanceState);
        /*StartAppAd.showSplash(this, savedInstanceState,
                new SplashConfig()
                        .setTheme(SplashConfig.Theme.GLOOMY)
                        .setLogo(R.mipmap.ic_launcher)
                        .setAppName("Prakash Gajera")
        );*/


        setContentView(R.layout.activity_main);

        imgFreeApp = (ImageView) findViewById(R.id.imgFreeApp);
        txtFreeApp = (TextView) findViewById(R.id.txtFreeApp);
        /*if (txtFreeApp != null) {
            txtFreeApp.setText("Loading Native Ad...");
        }*/

        /*startAppNativeAd.loadAd(
                new NativeAdPreferences()
                        .setAdsNumber(1)
                        .setAutoBitmapDownload(true)
                        .setImageSize(NativeAdPreferences.NativeAdBitmapSize.SIZE150X150),
                nativeAdListener);*/

        AccountManager accManager = AccountManager.get(MainActivity.this);
        Account acc[] = accManager.getAccountsByType("com.google");
        int accCount = acc.length;
        for (int i = 0; i < accCount; i++) {
            //Do your task here...
            Log.d("Account Name", acc[i].name);
            Log.d("Account Type", acc[i].type);
        }


        btn_second = (Button) findViewById(R.id.button);

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                takeScreenshot();
//                new Screenshot_whatsapp().execute();
                List<File> files = getListFiles(new File(Environment.getExternalStorageDirectory(), "Fashion Ware"));


               /* try{
                    final InputStream file = getAssets().open("dresses.txt");
                    reader = new BufferedReader(new InputStreamReader(file));
                    String line = reader.readLine();
                    while(line != null){
                        Log.d("StackOverflow", line);
                        line = reader.readLine();
                    }
                } catch(IOException ioe){
                    ioe.printStackTrace();
                }*/


               /* File sdcard = Environment.getExternalStorageDirectory();

//Get the text file
                File file = new File(sdcard,"text.txt");

//Read text from file
                StringBuilder text = new StringBuilder();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;

                    while ((line = br.readLine()) != null) {
                        text.append(line);
                        Log.d("Link",line);
                        text.append('\n');
                    }
                    br.close();
                }
                catch (IOException e) {
                    //You'll need to add proper error handling here
                }

//Find the view by its id

//Set the text
                txtFreeApp.setText(text);*/

            }
        });

       /* btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show an Ad
                startAppAd.showAd(new AdDisplayListener() {

                    *//**
         * Callback when Ad has been hidden
         * @param ad
         *//*
                    @Override
                    public void adHidden(Ad ad) {

                    // Run second activity right after the ad was hidden
                        Intent nextActivity = new Intent(MainActivity.this,
                                SecondActivity.class);
                        startActivity(nextActivity);
                    }

                    *//**
         * Callback when ad has been displayed
         * @param ad
         *//*
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
        });*/

       /* StartAppAd.showAd(this);*/
        DeviceTocken = BuildConfig.FLAVOR;

    }

    private List<File> getListFiles(File parentDir) {
        ArrayList<File> inFiles = new ArrayList<File>();
        File[] files = parentDir.listFiles();
        for (File file : files) {

            if (file.isDirectory()) {
                inFiles.addAll(getListFiles(file));
                Log.d("Folder Name1", String.valueOf(file));
            } else {
                if (file.getName().endsWith(".txt")) {
                    inFiles.add(file);
                    Log.d("Folder Name2", String.valueOf(file));

                    try {
                        InputStream inputStream = new FileInputStream(file);
                        reader = new BufferedReader(new InputStreamReader(inputStream));
                        String line = reader.readLine();
                        while (line != null) {
                            Log.d("File Path", line);
                            line = reader.readLine();

                            try {

                                filename = line.substring(line.lastIndexOf('/') + 1);

                                int lastIndex = line.lastIndexOf("/");
                                int prevIndex = line.lastIndexOf("/", lastIndex - 1);
                                laststringa = line.substring(prevIndex + 1, lastIndex).trim();
                                if (laststringa != null) {
                                    Log.d("Folder Name", laststringa);
                                } else {
                                    Log.d("Folder Name", laststringa);
                                }

                                File dir = new File(Environment.getExternalStorageDirectory(), "Fashion Ware" + File.separator + laststringa);
                                try {
                                    if (dir.mkdir()) {
                                        System.out.println("Directory created");

                                    } else {
                                        System.out.println("Directory is not created");
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                DownloadManager mgr = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

                                Uri downloadUri = Uri.parse(line);
                                DownloadManager.Request request = new DownloadManager.Request(
                                        downloadUri);

                                request.setAllowedNetworkTypes(
                                        DownloadManager.Request.NETWORK_WIFI
                                                | DownloadManager.Request.NETWORK_MOBILE)
                                        .setAllowedOverRoaming(false).setTitle(laststringa)
                                        .setDescription(filename)
                                        .setDestinationInExternalPublicDir("/Fashion Ware"+File.separator+laststringa, filename);

                                mgr.enqueue(request);
                                Log.d("Download Completed",laststringa +" "+filename);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                }
            }
        }
        return inFiles;
    }

    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            // image naming and path  to include sd card  appending name you choose for file
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";

            // create bitmap screen capture
            View v1 = getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            File imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

//            openScreenshot(imageFile);

            /*File myimage = new File(Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg");
            Uri uri = Uri.parse(myimage.toString());

            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("image*//*");
            share.setPackage("com.whatsapp");
            share.putExtra(Intent.EXTRA_STREAM, uri);
            share.putExtra(Intent.EXTRA_SUBJECT,"Hello World");
//		share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(
//				Environment.getExternalStorageDirectory().getPath()
//						+ "/Hari_Smruti_Quotes/" + title + ".jpg")));
            startActivity(Intent.createChooser(share, "Share Image"));*/

        } catch (Throwable e) {
            // Several error may come out with file handling or OOM
            e.printStackTrace();
        }
    }

    public class Screenshot_whatsapp extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            Date now = new Date();
            android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

            try {
                // image naming and path  to include sd card  appending name you choose for file
                String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "abc" + ".jpg";
                Log.d("MPath", mPath.toString());
                // create bitmap screen capture
                View v1 = getWindow().getDecorView().getRootView();
                v1.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
                v1.setDrawingCacheEnabled(false);

                File imageFile = new File(mPath);

                FileOutputStream outputStream = new FileOutputStream(imageFile);
                int quality = 100;
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
                outputStream.flush();
                outputStream.close();

//            openScreenshot(imageFile);


            } catch (Throwable e) {
                // Several error may come out with file handling or OOM
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            File myimage = new File(Environment.getExternalStorageDirectory().toString() + "/" + "abc" + ".jpg");
            Log.d("PAth", myimage.toString());
           /* Uri uri = Uri.parse(myimage.toString());

            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("image*//**//*");
            share.setPackage("com.whatsapp");
            share.putExtra(Intent.EXTRA_STREAM, uri);
            share.putExtra(Intent.EXTRA_SUBJECT,"Hello World");
//		share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(
//				Environment.getExternalStorageDirectory().getPath()
//						+ "/Hari_Smruti_Quotes/" + title + ".jpg")));
            startActivity(share);*/

            Uri imageUri = Uri.parse(myimage.getAbsolutePath());
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            //Target whatsapp:
            shareIntent.setPackage("com.whatsapp");
            //Add text and then Image URI
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello World");
            shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
            shareIntent.setType("image/*");
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

            try {
                startActivity(shareIntent);
            } catch (android.content.ActivityNotFoundException ex) {
            }
        }
    }

    public void freeAppClick(View view) {
        if (nativeAd != null) {
            nativeAd.sendClick(this);
        }
    }


    @Override
    public void onBackPressed() {
//        StartAppAd.onBackPressed(this);
        super.onBackPressed();
    }
}
