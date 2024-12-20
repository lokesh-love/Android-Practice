package com.example.samplequestion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)

        // Set up click listener for the button
        button.setOnClickListener {
            // Get the text entered by the user
            val message = editText.text.toString()

            // Show the text as a toast message
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }

        // Set up listener for the rating bar
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            // Show the selected rating as a toast message
            Toast.makeText(this, "Rating: $rating", Toast.LENGTH_SHORT).show()
        }
    }
}
