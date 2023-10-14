package com.example.bcs421_week05hw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class StatsActivity : AppCompatActivity() {

    lateinit var correctText: TextView
    lateinit var earningText: TextView
    lateinit var playAgain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        var earnings = getIntent().getIntExtra("earnings", 0) // Get final earnings from intent
        var amountCorrect = getIntent().getIntExtra("amountCorrect", 0) // Get amount correct from intent

        correctText = findViewById(R.id.amountCorrectText)
        earningText = findViewById(R.id.earningsText)
        correctText.setText(amountCorrect.toString() + "/7")
        earningText.setText("\$" + earnings.toString())

        playAgain = findViewById(R.id.playAgainButton)
        playAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}