package com.example.failproject

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their IDs
        val editText = findViewById<EditText>(R.id.editText)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        val signInButton = findViewById<Button>(R.id.button)

        // Edge-to-edge display setup
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
            val systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                view.paddingLeft,
                view.paddingTop,
                view.paddingRight,
                systemInsets.bottom
            )
            WindowInsetsCompat.CONSUMED
        }

        // Button click listener
        signInButton.setOnClickListener {
            val username = editText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // Check if fields are empty and display toast accordingly
            if (username.isEmpty() || password.isEmpty()) {
                // Display error message if any field is empty
                Toast.makeText(this, "Enter valid choice", Toast.LENGTH_SHORT).show()
            } else {
                // Display success message if both fields are filled
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
