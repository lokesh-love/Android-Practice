package com.example.lokeshportfolio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Edge-to-edge layout setup
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        val skillsButton = findViewById<ImageButton>(R.id.imageButton3)
        val educationButton = findViewById<ImageButton>(R.id.imageButton7)
        val certificationButton = findViewById<ImageButton>(R.id.imageButton9)
        val socialProfileButton = findViewById<ImageButton>(R.id.imageButton10)
        val tvName = findViewById<TextView>(R.id.tVName)

        // Set click listeners for buttons
        skillsButton.setOnClickListener {
            val intent = Intent(this, skillsactivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Skills button clicked", Toast.LENGTH_SHORT).show()
        }

        educationButton.setOnClickListener {
            val intr =Intent(this,educationactivity::class.java)
            startActivity(intr)
            Toast.makeText(this, "Education button clicked", Toast.LENGTH_SHORT).show()
        }

        certificationButton.setOnClickListener {

            Toast.makeText(this, "Certification button clicked", Toast.LENGTH_SHORT).show()
        }

        socialProfileButton.setOnClickListener {
            val intent = Intent(this, socialprofile::class.java)
            startActivity(intent)
            Toast.makeText(this, "Social Profiles button clicked", Toast.LENGTH_SHORT).show()
        }

        // Example of interaction with the name TextView
        tvName.setOnClickListener {
            Toast.makeText(this, "Hello, Lokesh Kumar Rongali!", Toast.LENGTH_SHORT).show()
        }
    }
}
