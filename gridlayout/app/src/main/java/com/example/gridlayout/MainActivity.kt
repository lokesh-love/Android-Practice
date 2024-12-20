package com.example.gridlayout

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Handle window insets for edge-to-edge UI
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Get references to buttons and set click listeners
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val button10 = findViewById<Button>(R.id.button10)

        // Example: Setting a click listener to show a simple message
        button2.setOnClickListener {
            button2.text = "Clicked!" // Change text on click
        }
        // Add similar click listeners for other buttons as needed
        button3.setOnClickListener {
            button3.text = "Button 3 Pressed"
        }
        button4.setOnClickListener {
            button3.text = "Button 4 Pressed"
        }
        button5.setOnClickListener {
            button3.text = "Button 5 Pressed"
        }
        button6.setOnClickListener {
            button3.text = "Button 6 Pressed"
        }
        button7.setOnClickListener {
            button3.text = "Button 7 Pressed"
        }
        button8.setOnClickListener {
            button3.text = "Button 8 Pressed"
        }
        button9.setOnClickListener {
            button3.text = "Button 9 Pressed"
        }
        button10.setOnClickListener {
            button3.text = "Button 10 Pressed"
        }

        // Repeat for other buttons if you want additional functionality
    }
}
