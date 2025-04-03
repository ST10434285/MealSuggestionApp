package com.example.mealsuggestionapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import vcmsa.ci.mealsuggestionapp.R

class MainActivity : AppCompatActivity() {

    var timeInput: TextInputLayout? = null
    var suggestButton: Button? = null
    var resetButton: Button? = null
    var mealSuggestion: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI elements
        val timeInput = findViewById<TextInputLayout>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)

        // The meal suggestions
        val mealSuggestions = mapOf(
            "Morning" to "Eggs",
            "Mid-morning" to "Fruit",
            "Afternoon" to "Sandwich",
            "Mid-afternoon" to "Cake",
            "Dinner" to "Pasta",
            "After Dinner" to "Ice Cream"
        )

        // The suggestion button click
        suggestButton.setOnClickListener {
            val input = timeInput.textDirection.toString().trim()
            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a valid time of day.", Toast.LENGTH_SHORT).show()
            } else {
                val meal = mealSuggestions[input]
                if (meal != null) {
                    mealSuggestion.text = "Suggested meal: $meal"
                } else {
                    Toast.makeText(this, "Invalid time of day. Try again.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // The reset button click
        resetButton.setOnClickListener {
            timeInput.textDirection.clear()
            mealSuggestion.text = ""
        }
    }
}

private fun Int.clear() {
    TODO("Not yet implemented")
}


