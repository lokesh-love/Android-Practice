package com.example.prac1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.res.Configuration
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonEng = findViewById<Button>(R.id.button)
        val buttonTel = findViewById<Button>(R.id.button2)
        val buttonSpan = findViewById<Button>(R.id.button3)
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)

        // Set initial text
        welcomeTextView.text = getString(R.string.welcome_message)

        // Set up button click listeners
        buttonEng.setOnClickListener { setLocale("en") }
        buttonTel.setOnClickListener { setLocale("tel") }
        buttonSpan.setOnClickListener { setLocale("es") }
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        resources.updateConfiguration(config, resources.displayMetrics)
        recreate() // Recreate the activity to apply the language change
    }
}
