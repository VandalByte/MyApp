package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }
    
    val TAG = "CHICK"

    fun clickHandler(view: View) {
        Log.i("button_click", "clickHandler: button clicked")
//        val dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9342345500"))
//        val webIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
//        startActivity(webIntent)

        val hIndent = Intent(this, HomeActivity::class.java)
//        throw NullPointerException("THOWSS THE ERROR!!!")
        startActivity(hIndent)
    }

    // activity is visible to the user to interact
    override fun onStart() {
        super.onStart()
        Log.i(TAG, "Chick started")
    }
    // (sleep) incoming call ur activity goes into the background for sometime
    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Chick paused")
    }

    // when activity comes back to foreground
    override fun onResume() {
        super.onResume()
        Log.w(TAG, "Chick resumed")
    }
    // activity is no longer visible but may still be in memory
    override fun onStop() {
        super.onStop()
        Log.w(TAG, "Chick stopped")
    }

    // activity is being removed from memory and is about to be terminated
    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"activity is destroyed")
    }
}