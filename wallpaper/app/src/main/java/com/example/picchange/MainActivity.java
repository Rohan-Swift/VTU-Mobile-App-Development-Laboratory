package com.example.picchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button wall;
    Timer tim;
    Drawable drawable;
    WallpaperManager wlp;
    int prev=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        tim = new Timer();
        wlp = WallpaperManager.getInstance(this);
        wall = findViewById(R.id.button);
        wall.setOnClickListener(new View.OnClickListener() { 
            @Override public void onClick(View view) {
            setWallpaper();
        }
        });
    }
    private void setWallpaper() {
        tim.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1) {
                    drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.one, null);
                    prev = 2;
                }
                else if(prev==2) {
                    drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.two, null);
                    prev=3;
                }
                else if(prev==3) {
                    drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.three, null);
                    prev=4;
                }
                else if(prev==4) {
                    drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.four, null);
                    prev=5;
                }
                else if(prev==5) {
                    drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.five, null);
                    prev=1;
                }
                Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap(); 
                try {
                    wlp.setBitmap(wallpaper);
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
        },0,300); } }
