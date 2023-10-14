package com.example.bcs421_week05hw

import android.content.Intent
import android.graphics.Color.GREEN
import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity1 : AppCompatActivity() {

    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton
    lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question1)

        radioGroup = findViewById(R.id.RadioGroup)
        confirmButton = findViewById(R.id.ButtonConfirm)
        var earnings = 0
        var amountCorrect = 0

        // Change listener to check which radio button is currently checked
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton
            val isChecked = checkedRadioButton.isChecked
            if (isChecked) {
                val count = radioGroup.childCount
                // Set all radio button backgrounds to transparent as a reset
                for (i in 0 until count) {
                    val o = radioGroup.getChildAt(i) as RadioButton
                    o.setBackgroundColor(TRANSPARENT)
                }
                checkedRadioButton.setBackgroundColor(GREEN) // Green background
            }
        })

        confirmButton.setOnClickListener{
            var radioID = radioGroup.checkedRadioButtonId // Get ID of checked radio button
            radioButton = findViewById(radioID)

            var choiceMade = radioButton.text.toString()
            var answer = getString(R.string.question_one_answer)

            // If the choice made is correct, we add to the earnings. Otherwise the earnings remain the same.
            if (choiceMade.equals(answer)) {
                earnings = earnings + 100
                amountCorrect++
                Toast.makeText(this, "This is the CORRECT answer. You earned \$" + earnings + ".", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "This is NOT the correct answer. You earned \$" + earnings + ".", Toast.LENGTH_SHORT).show()
            }

            // Send data to the next UI
            val intent = Intent(this, QuestionActivity2::class.java)
            intent.putExtra("earnings", earnings)
            intent.putExtra("amountCorrect", amountCorrect)
            startActivity(intent)
        }

    }
}