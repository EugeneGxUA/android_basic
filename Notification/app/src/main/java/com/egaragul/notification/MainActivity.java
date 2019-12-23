package com.egaragul.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final static int NOTIFY_ID = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.notification_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent notifiacatioIntent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this,
                        0,
                        notifiacatioIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT
                );

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(
                                MainActivity.this,
                                getString(R.string.notification_channel_id))
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Title")
                        .setContentText("Text")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pendingIntent);

                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);
                notificationManagerCompat.notify(NOTIFY_ID, builder.build());
            }
        });
    }
}
