package com.example.contactlist

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailedcontact)

        // Adjust for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve data from intent
        val userProfile = findViewById<ImageView>(R.id.USERPROFILEIMAGE)
        val name = findViewById<TextView>(R.id.NAME)
        val number = findViewById<TextView>(R.id.CONTACTNUMBER)

        val profileImageResId = intent.getIntExtra("profileImage", R.drawable.image1)
        val nameText = intent.getStringExtra("name")
        val numberText = intent.getStringExtra("number")

        // Set data to views
        userProfile.setImageResource(profileImageResId)
        name.text = nameText ?: "Unknown" // Fallback if null
        number.text = numberText ?: "No number" // Fallback if null
    }
}
