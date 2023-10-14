package com.example.bcs421_week05hw

import android.content.Intent
import android.graphics.Color.GREEN
import android.graphics.Color.TRANSPARENT
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity5 : AppCompatActivity() {

    lateinit var radioGroup: RadioGroup
    lateinit var radioButton: RadioButton
    lateinit var confirmButton: Button
    lateinit var earningsText: TextView //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question5)

        radioGroup = findViewById(R.id.RadioGroup)
        confirmButton = findViewById(R.id.ButtonConfirm)
        earningsText = findViewById(R.id.TextViewGameOver)
        // Get the values passed from the Intent
        var earnings = getIntent().getIntExtra("earnings", 0)
        var amountCorrect = getIntent().getIntExtra("amountCorrect", 0)
        // Update the earnings text view to show how much we've earned so far
        earningsText.setText("You Earned : $ " + earnings)

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
            var answer = getString(R.string.question_five_answer)

            // Compare choice made to predetermined correct answer from strings.xml
            if (choiceMade.equals(answer)) {
                earnings = earnings + 100
                amountCorrect++
                Toast.makeText(this, "This is the CORRECT answer. You earned \$" + earnings + ".", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "This is NOT the correct answer. You earned \$" + earnings + ".", Toast.LENGTH_SHORT).show()
            }

            // Send data to the next UI
            val intent = Intent(this, QuestionActivity6::class.java)
            intent.putExtra("earnings", earnings)
            intent.putExtra("amountCorrect", amountCorrect)
            startActivity(intent)
        }

    }
}