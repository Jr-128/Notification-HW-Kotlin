package com.inaki.lifecycleapp

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.inaki.lifecycleapp.R
import com.inaki.lifecycleapp.MainActivity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.Button
import com.inaki.lifecycleapp.MainActivity2

class MainActivity : AppCompatActivity() {
    private var mEditText: EditText? = null
    private var mButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(NAME, "onCreate called")
        mButton = findViewById(R.id.button)
        mEditText = findViewById(R.id.edit_text)
    }

    override fun onStart() {
        super.onStart()
        Log.d(NAME, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(NAME, "onResume called")
        mButton!!.setOnClickListener { v: View? ->
            val activityIntent = Intent(baseContext, MainActivity2::class.java)
            activityIntent.putExtra("DATA", mEditText!!.text.toString())
            startActivity(activityIntent)

            // Implicit intent example
            val webpage = Uri.parse("https://www.android.com")
            val webIntent = Intent(Intent.ACTION_VIEW, webpage)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d(NAME, "onPause called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(NAME, "onRestart called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(NAME, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(NAME, "onDestroy called")
    }

    companion object {
        private const val NAME = "MainActivity"
    }
}