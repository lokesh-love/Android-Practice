package com.example.prac2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize components
        val nameInput: EditText = findViewById(R.id.nameInput)
        val numberInput: EditText = findViewById(R.id.numberInput)
        val callButton: Button = findViewById(R.id.callButton)

        // Set click listener for the Call button
        callButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val number = numberInput.text.toString().trim()

            // Validate user inputs
            when {
                name.isEmpty() -> {
                    Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
                }
                number.isEmpty() -> {
                    Toast.makeText(this, "Please enter a mobile number", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Show Toast with the entered name
                    Toast.makeText(this, "Calling $name", Toast.LENGTH_SHORT).show()

                    // Create an intent to open the dialer
                    val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = Uri.parse("tel:$number")
                    }
                    startActivity(dialIntent)
                }



            }

        }


        val buttnext = findViewById<Button>(R.id.nextbutton)

        buttnext.setOnClickListener {
            val intr = Intent(this, MainActivity2::class.java)
            startActivity(intr)
        }
        }
    }
