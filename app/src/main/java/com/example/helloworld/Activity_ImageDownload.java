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

    String[] images = {"http://transcendencetechnology.in/blouse/blouse1.jpg",
            "http://transcendencetechnology.in/blouse/blouse2.jpg",
            "http://transcendencetechnology.in/blouse/blouse3.jpg",
            "http://transcendencetechnology.in/blouse/blouse4.jpg",
            "http://transcendencetechnology.in/blouse/blouse5.jpg",
            "http://transcendencetechnology.in/blouse/blouse6.jpg",
            "http://transcendencetechnology.in/blouse/blouse7.jpg",
            "http://transcendencetechnology.in/blouse/blouse8.jpg",
            "http://transcendencetechnology.in/blouse/blouse9.jpg",
            "http://transcendencetechnology.in/blouse/blouse10.jpg",
            "http://transcendencetechnology.in/blouse/blouse11.jpg",
            "http://transcendencetechnology.in/blouse/blouse12.jpg",
            "http://transcendencetechnology.in/blouse/blouse13.jpg",
            "http://transcendencetechnology.in/blouse/blouse14.jpg",
            "http://transcendencetechnology.in/blouse/blouse15.jpg",
            "http://transcendencetechnology.in/blouse/blouse16.jpg",
            "http://transcendencetechnology.in/blouse/blouse17.jpg",
            "http://transcendencetechnology.in/blouse/blouse18.jpg",
            "http://transcendencetechnology.in/blouse/blouse19.jpg",
            "http://transcendencetechnology.in/blouse/blouse20.jpg",
            "http://transcendencetechnology.in/blouse/blouse21.jpg",
            "http://transcendencetechnology.in/blouse/blouse22.jpg",
            "http://transcendencetechnology.in/blouse/blouse23.jpg",
            "http://transcendencetechnology.in/blouse/blouse24.jpg",
            "http://transcendencetechnology.in/blouse/blouse25.jpg",
            "http://transcendencetechnology.in/blouse/blouse26.jpg",
            "http://transcendencetechnology.in/blouse/blouse27.jpg",
            "http://transcendencetechnology.in/blouse/blouse28.jpg",
            "http://transcendencetechnology.in/blouse/blouse29.jpg",
            "http://transcendencetechnology.in/blouse/blouse30.jpg",
            "http://transcendencetechnology.in/blouse/blouse31.jpg",
            "http://transcendencetechnology.in/blouse/blouse32.jpg",
            "http://transcendencetechnology.in/blouse/blouse33.jpg",
            "http://transcendencetechnology.in/blouse/blouse34.jpg",
            "http://transcendencetechnology.in/blouse/blouse35.jpg",
            "http://transcendencetechnology.in/blouse/blouse36.jpg",
            "http://transcendencetechnology.in/blouse/blouse37.jpg",
            "http://transcendencetechnology.in/blouse/blouse38.jpg",
            "http://transcendencetechnology.in/blouse/blouse39.jpg",
            "http://transcendencetechnology.in/blouse/blouse40.jpg",
            "http://transcendencetechnology.in/blouse/blouse41.jpg",
            "http://transcendencetechnology.in/blouse/blouse42.jpg",
            "http://transcendencetechnology.in/blouse/blouse43.jpg",
            "http://transcendencetechnology.in/blouse/blouse44.jpg",
            "http://transcendencetechnology.in/blouse/blouse45.jpg",
            "http://transcendencetechnology.in/blouse/blouse46.jpg",
            "http://transcendencetechnology.in/blouse/blouse47.jpg",
            "http://transcendencetechnology.in/blouse/blouse48.jpg",
            "http://transcendencetechnology.in/blouse/blouse49.jpg",
            "http://transcendencetechnology.in/blouse/blouse50.jpg",
            "http://transcendencetechnology.in/blouse/blouse51.jpg",
            "http://transcendencetechnology.in/blouse/blouse52.jpg",
            "http://transcendencetechnology.in/blouse/blouse53.jpg",
            "http://transcendencetechnology.in/blouse/blouse54.jpg",
            "http://transcendencetechnology.in/blouse/blouse55.jpg",
            "http://transcendencetechnology.in/blouse/blouse56.jpg",
            "http://transcendencetechnology.in/blouse/blouse57.jpg",
            "http://transcendencetechnology.in/blouse/blouse58.jpg",
            "http://transcendencetechnology.in/blouse/blouse59.jpg",
            "http://transcendencetechnology.in/blouse/blouse60.jpg",
            "http://transcendencetechnology.in/blouse/blouse61.jpg",
            "http://transcendencetechnology.in/blouse/blouse62.jpg",
            "http://transcendencetechnology.in/blouse/blouse63.jpg",
            "http://transcendencetechnology.in/blouse/blouse64.jpg",
            "http://transcendencetechnology.in/blouse/blouse65.jpg",
            "http://transcendencetechnology.in/blouse/blouse66.jpg",
            "http://transcendencetechnology.in/blouse/blouse67.jpg",
            "http://transcendencetechnology.in/blouse/blouse68.jpg",
            "http://transcendencetechnology.in/blouse/blouse69.jpg",
            "http://transcendencetechnology.in/blouse/blouse70.jpg",
            "http://transcendencetechnology.in/blouse/blouse71.jpg",
            "http://transcendencetechnology.in/blouse/blouse72.jpg",
            "http://transcendencetechnology.in/blouse/blouse73.jpg",
            "http://transcendencetechnology.in/blouse/blouse74.jpg",
            "http://transcendencetechnology.in/blouse/blouse75.jpg",
            "http://transcendencetechnology.in/blouse/blouse76.jpg",
            "http://transcendencetechnology.in/blouse/blouse77.jpg",
            "http://transcendencetechnology.in/blouse/blouse78.jpg",
            "http://transcendencetechnology.in/blouse/blouse79.jpg",
            "http://transcendencetechnology.in/blouse/blouse80.jpg",
            "http://transcendencetechnology.in/blouse/blouse81.jpg",
            "http://transcendencetechnology.in/blouse/blouse82.jpg",
            "http://transcendencetechnology.in/blouse/blouse83.jpg",
            "http://transcendencetechnology.in/blouse/blouse84.jpg",
            "http://transcendencetechnology.in/blouse/blouse85.jpg",
            "http://transcendencetechnology.in/blouse/blouse86.jpg",
            "http://transcendencetechnology.in/blouse/blouse87.jpg",
            "http://transcendencetechnology.in/blouse/blouse88.jpg",
            "http://transcendencetechnology.in/blouse/blouse89.jpg",
            "http://transcendencetechnology.in/blouse/blouse90.jpg",
            "http://transcendencetechnology.in/blouse/blouse91.jpg",
            "http://transcendencetechnology.in/blouse/blouse92.jpg",
            "http://transcendencetechnology.in/blouse/blouse93.jpg",
            "http://transcendencetechnology.in/blouse/blouse94.jpg",
            "http://transcendencetechnology.in/blouse/blouse95.jpg",
            "http://transcendencetechnology.in/blouse/blouse96.jpg",
            "http://transcendencetechnology.in/blouse/blouse97.jpg",
            "http://transcendencetechnology.in/blouse/blouse98.jpg",
            "http://transcendencetechnology.in/blouse/blouse99.jpg",
            "http://transcendencetechnology.in/blouse/blouse100.jpg",
            "http://transcendencetechnology.in/blouse/blouse101.jpg",
            "http://transcendencetechnology.in/blouse/blouse102.jpg",
            "http://transcendencetechnology.in/blouse/blouse103.jpg",
            "http://transcendencetechnology.in/blouse/blouse104.jpg",
            "http://transcendencetechnology.in/blouse/blouse105.jpg",
            "http://transcendencetechnology.in/blouse/blouse106.jpg",
            "http://transcendencetechnology.in/blouse/blouse107.jpg",
            "http://transcendencetechnology.in/blouse/blouse108.jpg",
            "http://transcendencetechnology.in/blouse/blouse109.jpg",
            "http://transcendencetechnology.in/blouse/blouse110.jpg",
            "http://transcendencetechnology.in/blouse/blouse111.jpg",
            "http://transcendencetechnology.in/blouse/blouse112.jpg",
            "http://transcendencetechnology.in/blouse/blouse113.jpg",
            "http://transcendencetechnology.in/blouse/blouse114.jpg",
            "http://transcendencetechnology.in/blouse/blouse115.jpg",
            "http://transcendencetechnology.in/blouse/blouse116.jpg",
            "http://transcendencetechnology.in/blouse/blouse117.jpg",
            "http://transcendencetechnology.in/blouse/blouse118.jpg",
            "http://transcendencetechnology.in/blouse/blouse119.jpg",
            "http://transcendencetechnology.in/blouse/blouse120.jpg",
            "http://transcendencetechnology.in/blouse/blouse121.jpg",
            "http://transcendencetechnology.in/blouse/blouse122.jpg",
            "http://transcendencetechnology.in/blouse/blouse123.jpg",
            "http://transcendencetechnology.in/blouse/blouse124.jpg",
            "http://transcendencetechnology.in/blouse/blouse125.jpg",
            "http://transcendencetechnology.in/blouse/blouse126.jpg",
            "http://transcendencetechnology.in/blouse/blouse127.jpg",
            "http://transcendencetechnology.in/blouse/blouse128.jpg",
            "http://transcendencetechnology.in/blouse/blouse129.jpg",
            "http://transcendencetechnology.in/blouse/blouse130.jpg",
            "http://transcendencetechnology.in/blouse/blouse131.jpg",
            "http://transcendencetechnology.in/blouse/blouse132.jpg",
            "http://transcendencetechnology.in/blouse/blouse133.jpg",
            "http://transcendencetechnology.in/blouse/blouse134.jpg",
            "http://transcendencetechnology.in/blouse/blouse135.jpg",
            "http://transcendencetechnology.in/blouse/blouse136.jpg",
            "http://transcendencetechnology.in/blouse/blouse137.jpg",
            "http://transcendencetechnology.in/blouse/blouse138.jpg",
            "http://transcendencetechnology.in/blouse/blouse139.jpg",
            "http://transcendencetechnology.in/blouse/blouse140.jpg",
            "http://transcendencetechnology.in/blouse/blouse141.jpg",
            "http://transcendencetechnology.in/blouse/blouse142.jpg",
            "http://transcendencetechnology.in/blouse/blouse143.jpg",
            "http://transcendencetechnology.in/blouse/blouse144.jpg",
            "http://transcendencetechnology.in/blouse/blouse145.jpg",
            "http://transcendencetechnology.in/blouse/blouse146.jpg",
            "http://transcendencetechnology.in/blouse/blouse147.jpg",
            "http://transcendencetechnology.in/blouse/blouse148.jpg",
            "http://transcendencetechnology.in/blouse/blouse149.jpg",
            "http://transcendencetechnology.in/blouse/blouse150.jpg",
            "http://transcendencetechnology.in/blouse/blouse151.jpg",
            "http://transcendencetechnology.in/blouse/blouse152.jpg",
            "http://transcendencetechnology.in/blouse/blouse153.jpg",
            "http://transcendencetechnology.in/blouse/blouse154.jpg",
            "http://transcendencetechnology.in/blouse/blouse155.jpg",
            "http://transcendencetechnology.in/blouse/blouse156.jpg",
            "http://transcendencetechnology.in/blouse/blouse157.jpg",
            "http://transcendencetechnology.in/blouse/blouse158.jpg",
            "http://transcendencetechnology.in/blouse/blouse159.jpg",
            "http://transcendencetechnology.in/blouse/blouse160.jpg",
            "http://transcendencetechnology.in/blouse/blouse161.jpg",
            "http://transcendencetechnology.in/blouse/blouse162.jpg",
            "http://transcendencetechnology.in/blouse/blouse163.jpg",
            "http://transcendencetechnology.in/blouse/blouse164.jpg",
            "http://transcendencetechnology.in/blouse/blouse165.jpg",
            "http://transcendencetechnology.in/blouse/blouse166.jpg",
            "http://transcendencetechnology.in/blouse/blouse167.jpg",
            "http://transcendencetechnology.in/blouse/blouse168.jpg",
            "http://transcendencetechnology.in/blouse/blouse169.jpg",
            "http://transcendencetechnology.in/blouse/blouse170.jpg",
            "http://transcendencetechnology.in/blouse/blouse171.jpg",
            "http://transcendencetechnology.in/blouse/blouse172.jpg",
            "http://transcendencetechnology.in/blouse/blouse173.jpg",
            "http://transcendencetechnology.in/blouse/blouse174.jpg",
            "http://transcendencetechnology.in/blouse/blouse175.jpg",
            "http://transcendencetechnology.in/blouse/blouse176.jpg",
            "http://transcendencetechnology.in/blouse/blouse177.jpg",
            "http://transcendencetechnology.in/blouse/blouse178.jpg",
            "http://transcendencetechnology.in/blouse/blouse179.jpg",
            "http://transcendencetechnology.in/blouse/blouse180.jpg",
            "http://transcendencetechnology.in/blouse/blouse181.jpg",
            "http://transcendencetechnology.in/blouse/blouse182.jpg",
            "http://transcendencetechnology.in/blouse/blouse183.jpg",
            "http://transcendencetechnology.in/blouse/blouse184.jpg",
            "http://transcendencetechnology.in/blouse/blouse185.jpg",
            "http://transcendencetechnology.in/blouse/blouse186.jpg",
            "http://transcendencetechnology.in/blouse/blouse187.jpg",
            "http://transcendencetechnology.in/blouse/blouse188.jpg",
            "http://transcendencetechnology.in/blouse/blouse189.jpg",
            "http://transcendencetechnology.in/blouse/blouse190.jpg",
            "http://transcendencetechnology.in/blouse/blouse191.jpg",
            "http://transcendencetechnology.in/blouse/blouse192.jpg",
            "http://transcendencetechnology.in/blouse/blouse193.jpg",
            "http://transcendencetechnology.in/blouse/blouse194.jpg",
            "http://transcendencetechnology.in/blouse/blouse195.jpg",
            "http://transcendencetechnology.in/blouse/blouse196.jpg",
            "http://transcendencetechnology.in/blouse/blouse197.jpg",
            "http://transcendencetechnology.in/blouse/blouse198.jpg",
            "http://transcendencetechnology.in/blouse/blouse199.jpg",
            "http://transcendencetechnology.in/blouse/blouse200.jpg",
            "http://transcendencetechnology.in/blouse/blouse201.jpg",
            "http://transcendencetechnology.in/blouse/blouse202.jpg",
            "http://transcendencetechnology.in/blouse/blouse203.jpg",
            "http://transcendencetechnology.in/blouse/blouse204.jpg",
            "http://transcendencetechnology.in/blouse/blouse205.jpg",
            "http://transcendencetechnology.in/blouse/blouse206.jpg",
            "http://transcendencetechnology.in/blouse/blouse207.jpg",
            "http://transcendencetechnology.in/blouse/blouse208.jpg",
            "http://transcendencetechnology.in/blouse/blouse209.jpg",
            "http://transcendencetechnology.in/blouse/blouse210.jpg",
            "http://transcendencetechnology.in/blouse/blouse211.jpg",
            "http://transcendencetechnology.in/blouse/blouse212.jpg",
            "http://transcendencetechnology.in/blouse/blouse213.jpg",
            "http://transcendencetechnology.in/blouse/blouse214.jpg",
            "http://transcendencetechnology.in/blouse/blouse215.jpg",
            "http://transcendencetechnology.in/blouse/blouse216.jpg",
            "http://transcendencetechnology.in/blouse/blouse217.jpg",
            "http://transcendencetechnology.in/blouse/blouse218.jpg",
            "http://transcendencetechnology.in/blouse/blouse219.jpg",
            "http://transcendencetechnology.in/blouse/blouse220.jpg",
            "http://transcendencetechnology.in/blouse/blouse221.jpg",
            "http://transcendencetechnology.in/blouse/blouse222.jpg",
            "http://transcendencetechnology.in/blouse/blouse223.jpg",
            "http://transcendencetechnology.in/blouse/blouse224.jpg",
            "http://transcendencetechnology.in/blouse/blouse225.jpg",
            "http://transcendencetechnology.in/blouse/blouse226.jpg",
            "http://transcendencetechnology.in/blouse/blouse227.jpg",
            "http://transcendencetechnology.in/blouse/blouse228.jpg",
            "http://transcendencetechnology.in/blouse/blouse229.jpg",
            "http://transcendencetechnology.in/blouse/blouse230.jpg",
            "http://transcendencetechnology.in/blouse/blouse231.jpg",
            "http://transcendencetechnology.in/blouse/blouse232.jpg",
            "http://transcendencetechnology.in/blouse/blouse233.jpg",
            "http://transcendencetechnology.in/blouse/blouse234.jpg",
            "http://transcendencetechnology.in/blouse/blouse235.jpg",
            "http://transcendencetechnology.in/blouse/blouse236.jpg",
            "http://transcendencetechnology.in/blouse/blouse237.jpg",
            "http://transcendencetechnology.in/blouse/blouse238.jpg",
            "http://transcendencetechnology.in/blouse/blouse239.jpg",
            "http://transcendencetechnology.in/blouse/blouse240.jpg",
            "http://transcendencetechnology.in/blouse/blouse241.jpg",
            "http://transcendencetechnology.in/blouse/blouse242.jpg",
            "http://transcendencetechnology.in/blouse/blouse243.jpg",
            "http://transcendencetechnology.in/blouse/blouse244.jpg",
            "http://transcendencetechnology.in/blouse/blouse245.jpg",
            "http://transcendencetechnology.in/blouse/blouse246.jpg",
            "http://transcendencetechnology.in/blouse/blouse247.jpg",
            "http://transcendencetechnology.in/blouse/blouse248.jpg",
            "http://transcendencetechnology.in/blouse/blouse249.jpg",
            "http://transcendencetechnology.in/blouse/blouse250.jpg",
            "http://transcendencetechnology.in/blouse/blouse251.jpg",
            "http://transcendencetechnology.in/blouse/blouse252.jpg",
            "http://transcendencetechnology.in/blouse/blouse253.jpg",
            "http://transcendencetechnology.in/blouse/blouse254.jpg",
            "http://transcendencetechnology.in/blouse/blouse255.jpg",
            "http://transcendencetechnology.in/blouse/blouse256.jpg",
            "http://transcendencetechnology.in/blouse/blouse257.jpg",
            "http://transcendencetechnology.in/blouse/blouse258.jpg",
            "http://transcendencetechnology.in/blouse/blouse259.jpg",
            "http://transcendencetechnology.in/blouse/blouse260.jpg",
            "http://transcendencetechnology.in/blouse/blouse261.jpg",
            "http://transcendencetechnology.in/blouse/blouse262.jpg",
            "http://transcendencetechnology.in/blouse/blouse263.jpg",
            "http://transcendencetechnology.in/blouse/blouse264.jpg",
            "http://transcendencetechnology.in/blouse/blouse265.jpg",
            "http://transcendencetechnology.in/blouse/blouse266.jpg",
            "http://transcendencetechnology.in/blouse/blouse267.jpg",
            "http://transcendencetechnology.in/blouse/blouse268.jpg",
            "http://transcendencetechnology.in/blouse/blouse269.jpg",
            "http://transcendencetechnology.in/blouse/blouse270.jpg",
            "http://transcendencetechnology.in/blouse/blouse271.jpg",
            "http://transcendencetechnology.in/blouse/blouse272.jpg",
            "http://transcendencetechnology.in/blouse/blouse273.jpg",
            "http://transcendencetechnology.in/blouse/blouse274.jpg",
            "http://transcendencetechnology.in/blouse/blouse275.jpg",
            "http://transcendencetechnology.in/blouse/blouse276.jpg",
            "http://transcendencetechnology.in/blouse/blouse277.jpg",
            "http://transcendencetechnology.in/blouse/blouse278.jpg",
            "http://transcendencetechnology.in/blouse/blouse279.jpg",
            "http://transcendencetechnology.in/blouse/blouse280.jpg",
            "http://transcendencetechnology.in/blouse/blouse281.jpg",
            "http://transcendencetechnology.in/blouse/blouse282.jpg",
            "http://transcendencetechnology.in/blouse/blouse283.jpg",
            "http://transcendencetechnology.in/blouse/blouse284.jpg",
            "http://transcendencetechnology.in/blouse/blouse285.jpg",
            "http://transcendencetechnology.in/blouse/blouse286.jpg",
            "http://transcendencetechnology.in/blouse/blouse287.jpg",
            "http://transcendencetechnology.in/blouse/blouse288.jpg",
            "http://transcendencetechnology.in/blouse/blouse289.jpg",
            "http://transcendencetechnology.in/blouse/blouse290.jpg",
            "http://transcendencetechnology.in/blouse/blouse291.jpg",
            "http://transcendencetechnology.in/blouse/blouse292.jpg",
            "http://transcendencetechnology.in/blouse/blouse293.jpg",
            "http://transcendencetechnology.in/blouse/blouse294.jpg",
            "http://transcendencetechnology.in/blouse/blouse295.jpg",
            "http://transcendencetechnology.in/blouse/blouse296.jpg",
            "http://transcendencetechnology.in/blouse/blouse297.jpg",
            "http://transcendencetechnology.in/blouse/blouse298.jpg",
            "http://transcendencetechnology.in/blouse/blouse299.jpg",
            "http://transcendencetechnology.in/blouse/blouse300.jpg",
            "http://transcendencetechnology.in/blouse/blouse301.jpg",
            "http://transcendencetechnology.in/blouse/blouse302.jpg",
            "http://transcendencetechnology.in/blouse/blouse303.jpg",
            "http://transcendencetechnology.in/blouse/blouse304.jpg",
            "http://transcendencetechnology.in/blouse/blouse305.jpg",
            "http://transcendencetechnology.in/blouse/blouse306.jpg",
            "http://transcendencetechnology.in/blouse/blouse307.jpg",
            "http://transcendencetechnology.in/blouse/blouse308.jpg",
            "http://transcendencetechnology.in/blouse/blouse309.jpg",
            "http://transcendencetechnology.in/blouse/blouse310.jpg",
            "http://transcendencetechnology.in/blouse/blouse311.jpg",
            "http://transcendencetechnology.in/blouse/blouse312.jpg",
            "http://transcendencetechnology.in/blouse/blouse313.jpg",
            "http://transcendencetechnology.in/blouse/blouse314.jpg",
            "http://transcendencetechnology.in/blouse/blouse315.jpg",
            "http://transcendencetechnology.in/blouse/blouse316.jpg",
            "http://transcendencetechnology.in/blouse/blouse317.jpg",
            "http://transcendencetechnology.in/blouse/blouse318.jpg",
            "http://transcendencetechnology.in/blouse/blouse319.jpg",
            "http://transcendencetechnology.in/blouse/blouse320.jpg",
            "http://transcendencetechnology.in/blouse/blouse321.jpg",
            "http://transcendencetechnology.in/blouse/blouse322.jpg",
            "http://transcendencetechnology.in/blouse/blouse323.jpg",
            "http://transcendencetechnology.in/blouse/blouse324.jpg",
            "http://transcendencetechnology.in/blouse/blouse325.jpg",
            "http://transcendencetechnology.in/blouse/blouse326.jpg",
            "http://transcendencetechnology.in/blouse/blouse327.jpg",
            "http://transcendencetechnology.in/blouse/blouse328.jpg",
            "http://transcendencetechnology.in/blouse/blouse329.jpg",
            "http://transcendencetechnology.in/blouse/blouse330.jpg",
            "http://transcendencetechnology.in/blouse/blouse331.jpg",
            "http://transcendencetechnology.in/blouse/blouse332.jpg",
            "http://transcendencetechnology.in/blouse/blouse333.jpg",
            "http://transcendencetechnology.in/blouse/blouse334.jpg",
            "http://transcendencetechnology.in/blouse/blouse335.jpg",
            "http://transcendencetechnology.in/blouse/blouse336.jpg",
            "http://transcendencetechnology.in/blouse/blouse337.jpg",
            "http://transcendencetechnology.in/blouse/blouse338.jpg",
            "http://transcendencetechnology.in/blouse/blouse339.jpg",
            "http://transcendencetechnology.in/blouse/blouse340.jpg",
            "http://transcendencetechnology.in/blouse/blouse341.jpg",
            "http://transcendencetechnology.in/blouse/blouse342.jpg",
            "http://transcendencetechnology.in/blouse/blouse343.jpg",
            "http://transcendencetechnology.in/blouse/blouse344.jpg",
            "http://transcendencetechnology.in/blouse/blouse345.jpg",
            "http://transcendencetechnology.in/blouse/blouse346.jpg",
            "http://transcendencetechnology.in/blouse/blouse347.jpg",
            "http://transcendencetechnology.in/blouse/blouse348.jpg",
            "http://transcendencetechnology.in/blouse/blouse349.jpg",
            "http://transcendencetechnology.in/blouse/blouse350.jpg",
            "http://transcendencetechnology.in/blouse/blouse351.jpg",
            "http://transcendencetechnology.in/blouse/blouse352.jpg",
            "http://transcendencetechnology.in/blouse/blouse353.jpg",
            "http://transcendencetechnology.in/blouse/blouse354.jpg",
            "http://transcendencetechnology.in/blouse/blouse355.jpg",
            "http://transcendencetechnology.in/blouse/blouse356.jpg",
            "http://transcendencetechnology.in/blouse/blouse357.jpg",
            "http://transcendencetechnology.in/blouse/blouse358.jpg",
            "http://transcendencetechnology.in/blouse/blouse359.jpg",
            "http://transcendencetechnology.in/blouse/blouse360.jpg",
            "http://transcendencetechnology.in/blouse/blouse361.jpg",
            "http://transcendencetechnology.in/blouse/blouse362.jpg",
            "http://transcendencetechnology.in/blouse/blouse363.jpg",
            "http://transcendencetechnology.in/blouse/blouse364.jpg",
            "http://transcendencetechnology.in/blouse/blouse365.jpg",
            "http://transcendencetechnology.in/blouse/blouse366.jpg",
            "http://transcendencetechnology.in/blouse/blouse367.jpg",
            "http://transcendencetechnology.in/blouse/blouse368.jpg",
            "http://transcendencetechnology.in/blouse/blouse369.jpg",
            "http://transcendencetechnology.in/blouse/blouse370.jpg",
            "http://transcendencetechnology.in/blouse/blouse371.jpg",
            "http://transcendencetechnology.in/blouse/blouse372.jpg",
            "http://transcendencetechnology.in/blouse/blouse373.jpg",
            "http://transcendencetechnology.in/blouse/blouse374.jpg",
            "http://transcendencetechnology.in/blouse/blouse375.jpg",
            "http://transcendencetechnology.in/blouse/blouse376.jpg",
            "http://transcendencetechnology.in/blouse/blouse377.jpg",
            "http://transcendencetechnology.in/blouse/blouse378.jpg",
            "http://transcendencetechnology.in/blouse/blouse379.jpg",
            "http://transcendencetechnology.in/blouse/blouse380.jpg",
            "http://transcendencetechnology.in/blouse/blouse381.jpg",
            "http://transcendencetechnology.in/blouse/blouse382.jpg",
            "http://transcendencetechnology.in/blouse/blouse383.jpg",
            "http://transcendencetechnology.in/blouse/blouse384.jpg",
            "http://transcendencetechnology.in/blouse/blouse385.jpg",
            "http://transcendencetechnology.in/blouse/blouse386.jpg",
            "http://transcendencetechnology.in/blouse/blouse387.jpg",
            "http://transcendencetechnology.in/blouse/blouse388.jpg",
            "http://transcendencetechnology.in/blouse/blouse389.jpg",
            "http://transcendencetechnology.in/blouse/blouse390.jpg",
            "http://transcendencetechnology.in/blouse/blouse391.jpg",
            "http://transcendencetechnology.in/blouse/blouse392.jpg",
            "http://transcendencetechnology.in/blouse/blouse393.jpg",
            "http://transcendencetechnology.in/blouse/blouse394.jpg",
            "http://transcendencetechnology.in/blouse/blouse395.jpg",
            "http://transcendencetechnology.in/blouse/blouse396.jpg",
            "http://transcendencetechnology.in/blouse/blouse397.jpg",
            "http://transcendencetechnology.in/blouse/blouse398.jpg",
            "http://transcendencetechnology.in/blouse/blouse399.jpg",
            "http://transcendencetechnology.in/blouse/blouse400.jpg",
            "http://transcendencetechnology.in/blouse/blouse401.jpg",
            "http://transcendencetechnology.in/blouse/blouse402.jpg",
            "http://transcendencetechnology.in/blouse/blouse403.jpg",
            "http://transcendencetechnology.in/blouse/blouse404.jpg",
            "http://transcendencetechnology.in/blouse/blouse405.jpg",
            "http://transcendencetechnology.in/blouse/blouse406.jpg",
            "http://transcendencetechnology.in/blouse/blouse407.jpg",
            "http://transcendencetechnology.in/blouse/blouse408.jpg",
            "http://transcendencetechnology.in/blouse/blouse409.jpg",
            "http://transcendencetechnology.in/blouse/blouse410.jpg",
            "http://transcendencetechnology.in/blouse/blouse411.jpg",
            "http://transcendencetechnology.in/blouse/blouse412.jpg",
            "http://transcendencetechnology.in/blouse/blouse413.jpg",
            "http://transcendencetechnology.in/blouse/blouse414.jpg",
            "http://transcendencetechnology.in/blouse/blouse415.jpg",
            "http://transcendencetechnology.in/blouse/blouse416.jpg",
            "http://transcendencetechnology.in/blouse/blouse417.jpg",
            "http://transcendencetechnology.in/blouse/blouse418.jpg",
            "http://transcendencetechnology.in/blouse/blouse419.jpg",
            "http://transcendencetechnology.in/blouse/blouse420.jpg",
            "http://transcendencetechnology.in/blouse/blouse421.jpg",
            "http://transcendencetechnology.in/blouse/blouse422.jpg",
            "http://transcendencetechnology.in/blouse/blouse423.jpg",
            "http://transcendencetechnology.in/blouse/blouse424.jpg",
            "http://transcendencetechnology.in/blouse/blouse425.jpg",
            "http://transcendencetechnology.in/blouse/blouse426.jpg",
            "http://transcendencetechnology.in/blouse/blouse427.jpg",
            "http://transcendencetechnology.in/blouse/blouse428.jpg",
            "http://transcendencetechnology.in/blouse/blouse429.jpg",
            "http://transcendencetechnology.in/blouse/blouse430.jpg",
            "http://transcendencetechnology.in/blouse/blouse431.jpg",
            "http://transcendencetechnology.in/blouse/blouse432.jpg",
            "http://transcendencetechnology.in/blouse/blouse433.jpg",
            "http://transcendencetechnology.in/blouse/blouse434.jpg",
            "http://transcendencetechnology.in/blouse/blouse435.jpg",
            "http://transcendencetechnology.in/blouse/blouse436.jpg",
            "http://transcendencetechnology.in/blouse/blouse437.jpg",
            "http://transcendencetechnology.in/blouse/blouse438.jpg",
            "http://transcendencetechnology.in/blouse/blouse439.jpg",
            "http://transcendencetechnology.in/blouse/blouse440.jpg",
            "http://transcendencetechnology.in/blouse/blouse441.jpg",
            "http://transcendencetechnology.in/blouse/blouse442.jpg",
            "http://transcendencetechnology.in/blouse/blouse443.jpg",
            "http://transcendencetechnology.in/blouse/blouse444.jpg",
            "http://transcendencetechnology.in/blouse/blouse445.jpg",
            "http://transcendencetechnology.in/blouse/blouse446.jpg",
            "http://transcendencetechnology.in/blouse/blouse447.jpg",
            "http://transcendencetechnology.in/blouse/blouse448.jpg",
            "http://transcendencetechnology.in/blouse/blouse449.jpg",
            "http://transcendencetechnology.in/blouse/blouse450.jpg",
            "http://transcendencetechnology.in/blouse/blouse451.jpg",
            "http://transcendencetechnology.in/blouse/blouse452.jpg",
            "http://transcendencetechnology.in/blouse/blouse453.jpg",
            "http://transcendencetechnology.in/blouse/blouse454.jpg",
            "http://transcendencetechnology.in/blouse/blouse455.jpg",
            "http://transcendencetechnology.in/blouse/blouse456.jpg" };

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
