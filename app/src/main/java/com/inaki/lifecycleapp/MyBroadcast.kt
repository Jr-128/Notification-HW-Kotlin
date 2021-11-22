package com.inaki.lifecycleapp

import com.inaki.lifecycleapp.MainActivity2.Companion.getmTextView
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.inaki.lifecycleapp.MyBroadcast
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.NotificationCompat
import com.inaki.lifecycleapp.R
import com.inaki.lifecycleapp.MainActivity2
import android.content.IntentFilter
import android.util.Log

class MyBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val received = intent.getStringExtra(MY_EXTRA)
        Toast.makeText(context, "Notification sent", Toast.LENGTH_LONG).show()
        Log.d("MyBroadcast", "BroadcastReceived")
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(432, createNotification(context).build())
    }

    private fun createNotification(context: Context): NotificationCompat.Builder {
        return NotificationCompat.Builder(context, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("This is my notification")
            .setContentText("Notification requested with message: " + getmTextView())
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }

    companion object {
        var MY_EXTRA = "MY_EXTRA"
        var myAction = "MY_BROADCAST"
        var INTENT = IntentFilter(myAction)
    }
}