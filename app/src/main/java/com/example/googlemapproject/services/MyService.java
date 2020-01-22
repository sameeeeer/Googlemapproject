package com.example.googlemapproject.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public Context context = this;
    public Handler handler = null;
    public Runnable runnable = null;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
    int count =0;

    @Override
    public void onCreate() {
        Toast.makeText(context, "Service Created!", Toast.LENGTH_SHORT).show();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                count++;
                Toast.makeText(context, "Test : " + count  , Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }


    @Override
    public void onDestroy() {
        handler.removeCallbacks(runnable);
        Toast.makeText(context, "Service Stopped",
                Toast.LENGTH_SHORT).show();
    }

    public static double getRandom(double min, double max){
        return Math.random()*((max-min)+1)+min;
    }
}