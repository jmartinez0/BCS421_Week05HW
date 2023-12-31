package com.example.bcs421_week05hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Makes the splash screen a full screen activity
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Wait 2 seconds before switching from Splash Screen to Login Screen
        Handler().postDelayed({
            val intent = Intent(this, QuestionActivity1::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}