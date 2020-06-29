package com.mag_solutions.learningstuff.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.mag_solutions.learningstuff.R;

public class NotificationActivity extends AppCompatActivity {

    private final String CHANNEL_ID = "123";
    private final int NOTIFICATION_ID = 321;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                createNotificationChannel();
                basicNotification();
            }
        });
    }

    private void basicNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_add)
                .setContentTitle("Basic Notification")
                .setContentText("This The Content of basic notification")
                .addAction(R.drawable.ic_add,"replay",null)
                .addAction(R.drawable.ic_check,"check", null)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Much longer text that cannot fit one line... and so more other stuff."))
                .setLargeIcon(Bitmap.createBitmap(BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.profile)))
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}