package com.example.applocalization

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set initial welcome message
        val welcomeTextView: TextView = findViewById(R.id.welcomeTextView)
        welcomeTextView.text = getString(R.string.welcome_message)
    }

    // Method to switch to Telugu
    fun switchToTelugu(view: View) {
        setLocale("tel") // Telugu locale
    }

    // Method to switch to Spanish
    fun switchToSpanish(view: View) {
        setLocale("es") // Spanish locale
    }

    // Method to switch to English
    fun switchToEnglish(view: View) {
        setLocale("en") // English locale
    }

    // Method to set the locale and update the configuration
    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        // Update the configuration with the new locale
        resources.updateConfiguration(config, resources.displayMetrics)

        // Refresh the activity to reflect the language change
        recreate()
    }
}
