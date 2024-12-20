package com.example.localization

import android.content.res.Configuration
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.localisation.R
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var languageSpinner: Spinner
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        languageSpinner = findViewById(R.id.languageSpinner)
        textView = findViewById(R.id.textView)

// Set up the Spinner with the language options
        val languages = arrayOf("English", "Hindi", "Spanish")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, languages)
        languageSpinner.adapter = adapter

// Handle language change when a language is selected from the dropdown
        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                when (position) {
                    0 -> setLocale("en") // English
                    1 -> setLocale("hi") // Hindi
                    2 -> setLocale("es") // Spanish
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
// Do nothing
            }
        }
    }

    // Function to change the language
    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        resources.updateConfiguration (config, resources.displayMetrics)

// Update the displayed text with the new language setting
        textView.setText(R.string.hello_world)
    }
}