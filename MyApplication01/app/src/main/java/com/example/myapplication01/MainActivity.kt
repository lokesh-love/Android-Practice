package com.example.myapplication01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Reference to your XML file

        // Find views by their IDs
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        // Set up button click listeners
        button.setOnClickListener {
            textView.text = "Button clicked!"
        }
        button1.setOnClickListener {
            textView.text = "Button 1 clicked!"
        }
        button2.setOnClickListener {
            textView.text = "Button 2 clicked!"
        }
    }

    private fun setContentView(activityMain: Int) {

    }
}
