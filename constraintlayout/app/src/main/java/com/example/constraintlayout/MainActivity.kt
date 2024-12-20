package com.example.constraintlayout

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find buttons by their IDs
        val buttonTop = findViewById<Button>(R.id.buttonTop)
        val buttonLeft = findViewById<Button>(R.id.buttonLeft)
        val buttonBelowTop = findViewById<Button>(R.id.buttonBelowTop)
        val buttonRight = findViewById<Button>(R.id.buttonRight)
        val buttonBottom = findViewById<Button>(R.id.buttonBottom)
        val buttonCustom = findViewById<Button>(R.id.buttonCustom)

        // Set click listeners (optional)
        buttonTop.setOnClickListener {
            // Do something when the Top Center button is clicked
        }

        buttonLeft.setOnClickListener {
            // Do something when the Left Center button is clicked
        }

        buttonBelowTop.setOnClickListener {
            // Do something when the Below Top Button is clicked
        }

        buttonRight.setOnClickListener {
            // Do something when the Right Center button is clicked
        }

        buttonBottom.setOnClickListener {
            // Do something when the Bottom Center button is clicked
        }

        buttonCustom.setOnClickListener {
            // Do something when the Custom Position button is clicked
        }
    }
}
