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

public class Activity_Hindi_Status extends AppCompatActivity {

    private SQLiteDatabase database;

    StringBuilder list_romantic=new StringBuilder();
    StringBuilder list_mohabbat=new StringBuilder();
    StringBuilder list_dard=new StringBuilder();
    StringBuilder list_Bewafa=new StringBuilder();
    StringBuilder list_judai=new StringBuilder();
    StringBuilder list_yade=new StringBuilder();
    StringBuilder list_dosti=new StringBuilder();
    StringBuilder list_Atitude=new StringBuilder();
    StringBuilder list_jindgani=new StringBuilder();
    StringBuilder list_preranadayak=new StringBuilder();
    StringBuilder list_majedar=new StringBuilder();
    StringBuilder list_ghayal=new StringBuilder();
    StringBuilder list_shikayat=new StringBuilder();
    StringBuilder list_dard_E_dil=new StringBuilder();
    StringBuilder list_rishtey=new StringBuilder();
    StringBuilder list_din_vishesh=new StringBuilder();
    StringBuilder list_filmy=new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi_status);

        database=openOrCreateDatabase("StatusNewData",MODE_PRIVATE,null);

        Cursor cursor=database.query("quotes",null,null,null,null,null,null);
        int cnt=cursor.getCount();
        cursor.moveToFirst();

        for (int i=0;i<cnt;i++) {

            if (cursor.getString(2).equals("1")) {
                list_romantic.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("2")) {
                list_mohabbat.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("3")) {
                list_dard.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("4")) {
                list_Bewafa.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("5")) {
                list_judai.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("6")) {
                list_yade.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("7")) {
                list_dosti.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("8")) {
                list_Atitude.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("9")) {
                list_jindgani.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("10")) {
                list_preranadayak.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("11")) {
                list_majedar.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("12")) {
                list_ghayal.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("13")) {
                list_shikayat.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("14")) {
                list_dard_E_dil.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("15")) {
                list_rishtey.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("16")) {
                list_din_vishesh.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            } else if (cursor.getString(2).equals("17")) {
                list_filmy.append("<item>"+cursor.getString(1)+"</item>"+"\n");
            }

            Log.d("Count : " ,String.valueOf(i));
            cursor.moveToNext();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Romantic.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_romantic);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Romantic.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "mohabbat.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_mohabbat);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "mohabbat.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "dard.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_dard);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "dard.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Bewafa.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Bewafa);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Bewafa.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "judai.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_judai);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "judai.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "yade.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_yade);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "yade.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "dosti.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_dosti);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "dosti.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "Atitude.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_Atitude);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "Atitude.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "jindgani.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_jindgani);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "jindgani.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "preranadayak.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_preranadayak);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "preranadayak.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "majedar.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_majedar);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "majedar.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "ghayal.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_ghayal);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "ghayal.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "shikayat.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_shikayat);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "shikayat.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "dard_E_dil.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_dard_E_dil);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "dard_E_dil.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "rishtey.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_rishtey);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "rishtey.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "din_vishesh.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_din_vishesh);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "din_vishesh.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }
            File gpxfile = new File(root, "filmy.txt");
            FileWriter writer = new FileWriter(gpxfile);
            writer.append(list_filmy);
            writer.flush();
            writer.close();
            Toast.makeText(getApplicationContext(), "filmy.txt Completed", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
