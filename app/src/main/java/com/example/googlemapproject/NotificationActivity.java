package com.example.googlemapproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.googlemapproject.services.CreateChannel;

public class NotificationActivity extends AppCompatActivity {

    Button button1, button2;
    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification1();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNotification2();
            }
        });
    }

    public void displayNotification1(){
        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp).setContentTitle("First Notification").
                        setContentText("This is first Notification")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
        notificationManagerCompat.notify(1,notification);


    }
    public void displayNotification2(){
        Notification notification = new NotificationCompat.Builder(this,CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_notifications_black_24dp).setContentTitle("Second Notification").
                        setContentText("This is second Notification")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE).build();
        notificationManagerCompat.notify(2,notification);


    }


}
