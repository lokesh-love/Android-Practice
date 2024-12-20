package com.example.firstactivity

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.secondactivie.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)  // Use the correct layout file for the second activity

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Receiving the message from MainActivity
        val message = intent.getStringExtra("message")
        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)
        textViewMessage.text = message
    }
}
