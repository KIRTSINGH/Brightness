package com.example.brightness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    float Backlight=0.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // BottomNavigationView navaview=findViewById(android.R.id.navigationBarBackground);
        //navaview.setItemHorizontalTranslationEnabled(new BottomNavigationView.OnNavigationItemSelectedListener() {
            SeekBar b = (SeekBar) findViewById(R.id.sb);
            final TextView tv = (TextView) findViewById(R.id.tv);
       b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               Backlight=(float)i/100;
               tv.setText(String.valueOf(Backlight));
               WindowManager.LayoutParams layoutParams=getWindow().getAttributes();
               layoutParams.screenBrightness=Backlight;
               getWindow().setAttributes(layoutParams);
           }


           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {


        }
        });

    }
}