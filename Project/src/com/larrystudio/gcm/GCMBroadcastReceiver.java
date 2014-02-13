package com.larrystudio.gcm;

import com.larrystudio.gamesmusic.MainActivity;
import com.larrystudio.videogamesmusic.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class GCMBroadcastReceiver extends BroadcastReceiver {

	private static final String logTag = "GCMBroadcastReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(logTag, "Received intent: " + intent.toString());
		showNotification(context);
	}

	private void showNotification(Context context) {
		PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0);

		NotificationCompat.Builder mBuilder =
				new NotificationCompat.Builder(context)
		.setSmallIcon(R.drawable.ic_action_good)
		.setContentTitle("My notification")
		.setContentText("Hello World!");
		mBuilder.setContentIntent(contentIntent);
		mBuilder.setDefaults(Notification.DEFAULT_SOUND);
		mBuilder.setAutoCancel(true);
		NotificationManager mNotificationManager =
				(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, mBuilder.build());
	}  
}