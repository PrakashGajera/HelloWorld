package com.example.helloworld;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Activity_ImageDownload extends AppCompatActivity {

    String[] images = {"//Image link"};

    final String strPref_Download_ID = "PREF_DOWNLOAD_ID";

    SharedPreferences preferenceManager;
    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_download);

        preferenceManager
                = PreferenceManager.getDefaultSharedPreferences(this);
        downloadManager
                = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);

        for (int i = 0; i < images.length; i++) {

            try {

                File dir = new File(Environment.getExternalStorageDirectory(), "Fashion Ware");
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

                Uri downloadUri = Uri.parse(images[i]);
                DownloadManager.Request request = new DownloadManager.Request(
                        downloadUri);
                        request.setAllowedNetworkTypes(
                                DownloadManager.Request.NETWORK_WIFI
                                        | DownloadManager.Request.NETWORK_MOBILE)
                                .setAllowedOverRoaming(false)
                                .setTitle("Image Download")
                                .setDescription(String.valueOf(i))
                                .setDestinationInExternalPublicDir("/Fashion Ware", i+".jpg");
                mgr.enqueue(request);
                Log.d("Download Completed", String.valueOf(i));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        IntentFilter intentFilter
                = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(downloadReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        unregisterReceiver(downloadReceiver);
    }

    private BroadcastReceiver downloadReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context arg0, Intent arg1) {
            // TODO Auto-generated method stub
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(preferenceManager.getLong(strPref_Download_ID, 0));
            Cursor cursor = downloadManager.query(query);
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                int status = cursor.getInt(columnIndex);
                if (status == DownloadManager.STATUS_SUCCESSFUL) {

                    //Retrieve the saved request id
                    long downloadID = preferenceManager.getLong(strPref_Download_ID, 0);

                    ParcelFileDescriptor file;
                    try {
                        file = downloadManager.openDownloadedFile(downloadID);
                        FileInputStream fileInputStream
                                = new ParcelFileDescriptor.AutoCloseInputStream(file);
                        Bitmap bm = BitmapFactory.decodeStream(fileInputStream);
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            }
        }
    };
}
