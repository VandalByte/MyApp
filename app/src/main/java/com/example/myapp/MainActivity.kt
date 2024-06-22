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

        val hIndent = Intent(this, DBActivity::class.java)
//        throw NullPointerException("THOWSS THE ERROR!!!")
        startActivity(hIndent)
    }

    fun String.commaSep(value: String):String{
        val newStr = value.replace(" ", ",")
        return newStr
    }
}