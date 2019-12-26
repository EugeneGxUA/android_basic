package com.egaragul.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static int notificationId = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.notification_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent notificationIntent = new Intent(
                        MainActivity.this,
                        MainActivity.class
                );

                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this,
                        0,
                        notificationIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT
                );

                String bigText = "Это я, почтальон Печкин. Принёс для вас посылку. "
                        + "Только я вам её не отдам. Потому что у вас документов нету. ";

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(
                                MainActivity.this,
                                getString(R.string.notification_channel_id))
                                .setSmallIcon(android.R.drawable.stat_sys_download)
                                .setContentTitle("Title")
                                .setContentText("Text")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                                .setContentIntent(pendingIntent)
                                .setColor(Color.GREEN)
                                .setAutoCancel(true)
                        .addAction(R.drawable.ic_launcher_background, "Open", pendingIntent)
                        .addAction(R.drawable.ic_launcher_background, "Close", pendingIntent)
                        .addAction(R.drawable.ic_launcher_background, "Some else", pendingIntent)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText));

                NotificationManagerCompat notificationManagerCompat =
                        NotificationManagerCompat.from(MainActivity.this);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel channel =
                            new NotificationChannel(
                                    getString(R.string.notification_channel_id),
                                    "My app",
                                    NotificationManager.IMPORTANCE_HIGH);
                    channel.setDescription("My channel description");
                    channel.enableLights(true);
                    channel.setLightColor(Color.GREEN);
                    channel.enableVibration(true);
                    notificationManagerCompat.createNotificationChannel(channel);
                }


                Notification notification = builder.build();
                notification.vibrate = new long[]{2000, 1000, 1000, 1000, 1000, 1000};

//                Uri ringURI =
//                        RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//                notification.sound = ringURI;

                notificationManagerCompat.notify(notificationId++, builder.build());
            }
        });
    }
}
