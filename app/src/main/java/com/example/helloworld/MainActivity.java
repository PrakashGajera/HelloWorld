package com.example.helloworld;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btn_second,btn_amazon,btn_imagedownload,btn_gujarati;
    private ImageView imgFreeApp = null;
    private TextView txtFreeApp = null;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgFreeApp = (ImageView) findViewById(R.id.imgFreeApp);
        txtFreeApp = (TextView) findViewById(R.id.txtFreeApp);

        database=openOrCreateDatabase("StatusNewData",MODE_PRIVATE,null);

        btn_second = (Button) findViewById(R.id.button);
        btn_amazon = (Button) findViewById(R.id.btn_amazon);
        btn_imagedownload= (Button) findViewById(R.id.btn_imagedownload);
        btn_gujarati= (Button) findViewById(R.id.btn_gujarati);

        //        new Send_mail().execute();

        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Activity_Hindi_Status.class);
                startActivity(intent);
            }
        });
        btn_amazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Activity_Amzon_ads.class);
                startActivity(intent);
            }
        });
        btn_imagedownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Activity_ImageDownload.class);
                startActivity(intent);

            }
        });
        btn_gujarati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Activity_gujarati.class);
                startActivity(intent);

            }
        });
    }

    public class Send_mail extends AsyncTask<String,String,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {

            Mail m = new Mail("<Sender Email Id>", "<Password>");
            String[] toArr = {"<Receiver Email id>", "<Receiver Email id>","<Receiver Email id>"};
            m.setTo(toArr);
            m.setFrom("<Sender Email id>");
            m.setSubject("Here is Good News! Mail is Received");
            m.setBody("Hello Sir/Madam");

            try {
                if(m.send()) {
//                    Toast.makeText(getApplicationContext(), "Email was sent successfully.", Toast.LENGTH_LONG).show();
                    Log.e("MailApp", "Email was sent successfully.");
                } else {
//                    Toast.makeText(getApplicationContext(), "Email was not sent.", Toast.LENGTH_LONG).show();
                    Log.e("MailApp", "Email was not sent.");
                }
            } catch(Exception e) {
                //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
                Log.e("MailApp", "Could not send email", e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
