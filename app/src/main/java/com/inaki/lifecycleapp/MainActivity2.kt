package com.inaki.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.inaki.lifecycleapp.MyBroadcast
import android.os.Bundle
import com.inaki.lifecycleapp.R
import com.inaki.lifecycleapp.MainActivity2
import android.widget.TextView
import android.content.Intent
import android.os.Build
import android.app.NotificationManager
import android.app.NotificationChannel
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    private var mButton2: Button? = null
    private var m: LocalBroadcastManager? = null
    private var mBroadcast: MyBroadcast? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mTextView = findViewById(R.id.textView)
        mButton2 = findViewById(R.id.button2)
        mBroadcast = MyBroadcast()
        m = LocalBroadcastManager.getInstance(baseContext)
    }

    override fun onStart() {
        super.onStart()
        m!!.registerReceiver(mBroadcast!!, MyBroadcast.INTENT)
    }

    override fun onResume() {
        super.onResume()
        val oldIntent = intent
        if (oldIntent != null) {
            if (oldIntent.getStringExtra("DATA") != null) {
                mTextView!!.text = oldIntent.getStringExtra("DATA")
            }
        }
        val mIntent = Intent()
        mIntent.action = MyBroadcast.myAction
        mIntent.putExtra(MyBroadcast.MY_EXTRA, "Received")
        createNotificationChannel()
        mButton2!!.setOnClickListener { v: View? -> m!!.sendBroadcast(mIntent) }
    }

    override fun onStop() {
        super.onStop()
        m!!.unregisterReceiver(mBroadcast!!)
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = getString(R.string.channel_name)
            val description = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        private var mTextView: TextView? = null
        @JvmStatic
        fun getmTextView(): String {
            return mTextView!!.text.toString()
        }
    }
}