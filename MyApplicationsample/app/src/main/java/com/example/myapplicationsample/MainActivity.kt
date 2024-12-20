package com.example.myapplicationsample

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Find views by ID
        val editText = findViewById<EditText>(R.id.editText)
        val updateButton = findViewById<Button>(R.id.updateButton)
        val textView1 = findViewById<TextView>(R.id.textView1)
        val toggleImageButton = findViewById<Button>(R.id.toggleImageButton)
        val imageView1 = findViewById<ImageView>(R.id.imageView1)

// Set a click listener on the updateButton
        updateButton.setOnClickListener {
// Get text from EditText and set it in TextView
            val userInput = editText.text.toString()
            if (userInput.isNotEmpty()) {
                textView1.text = userInput
// Change button color when clicked
                updateButton.setBackgroundColor(Color.GREEN)
            } else {
// Show a Toast if no text entered
                Toast.makeText(this, "Please enter some text!", Toast.LENGTH_SHORT).show()
            }
        }

// Set a click listener on the toggleImageButton to hide/show the ImageView
        toggleImageButton.setOnClickListener {
// Toggle the visibility of the imageView
            if (imageView1.visibility == View.VISIBLE) {
                imageView1.visibility = View.GONE
                toggleImageButton.text = "Show Image"
            } else {
                imageView1.visibility = View.VISIBLE
                toggleImageButton.text = "Hide Image"
            }
        }
    }
}