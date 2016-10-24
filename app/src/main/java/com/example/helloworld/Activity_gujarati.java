package com.example.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Activity_gujarati extends AppCompatActivity {

    private SQLiteDatabase database;
    StringBuilder list_gujarati=new StringBuilder();

    StringBuilder list_Attitude =new StringBuilder();
    StringBuilder list_Love =new StringBuilder();
    StringBuilder list_Mother =new StringBuilder();
    StringBuilder list_Father =new StringBuilder();
    StringBuilder list_Friendship =new StringBuilder();
    StringBuilder list_Truth =new StringBuilder();
    StringBuilder list_Life =new StringBuilder();
    StringBuilder list_Motivational =new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gujarati);

        database=openOrCreateDatabase("gujarati_status.db",MODE_PRIVATE,null);

        Cursor cursor=database.query("gujarati_status",null,null,null,null,null,null);
        int cnt=cursor.getCount();
        cursor.moveToFirst();

        for (int i=0;i<cnt;i++) {

            list_gujarati.append("<item>"+cursor.getString(0)+"</item>"+"\n");
            Log.d("Count : " ,String.valueOf(i));
            cursor.moveToNext();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati status ");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "other.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_gujarati);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "other.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*database=openOrCreateDatabase("gujaratistatus.db",MODE_PRIVATE,null);

        Cursor cursor=database.query("gujarati_status",null,null,null,null,null,null);
        int cnt=cursor.getCount();
        cursor.moveToFirst();

        for (int i=0;i<cnt;i++) {

            if (cursor.getString(0).equals("1")) {
                list_Attitude.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            } else if (cursor.getString(0).equals("2")) {
                list_Love.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            } else if (cursor.getString(0).equals("3")) {
                list_Mother.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            } else if (cursor.getString(0).equals("4")) {
                list_Father.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            } else if (cursor.getString(0).equals("5")) {
                list_Friendship.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            } else if (cursor.getString(0).equals("6")) {
                list_Truth.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            } else if (cursor.getString(0).equals("7")) {
                list_Life.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            } else if (cursor.getString(0).equals("8")) {
                list_Motivational.append("<item>"+cursor.getString(2)+"</item>"+"\n");
            }

            Log.d("Count : " ,String.valueOf(i));
            cursor.moveToNext();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Attitude.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Attitude);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Attitude.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Love.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Love);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Love.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Mother.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Mother);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Mother.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Father.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Father);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Father.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Friendship.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Friendship);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Friendship.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Truth.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Truth);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Truth.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Life.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Life);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Life.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Gujarati Status");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Motivational.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Motivational);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Motivational.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
