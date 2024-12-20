package com.example.prac4

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
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

        // Adjust system bar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Bind Views
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val spinnerLanguage = findViewById<Spinner>(R.id.spinnerLanguage)
        val buttonGo = findViewById<Button>(R.id.buttonGo)

        // Define Spinner Options
        val languages = arrayOf("Japanese", "Korean", "Spanish")

        // Setup Spinner Adapter
        val languageAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            languages
        )
        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerLanguage.adapter = languageAdapter

        // Button Click Listener
        buttonGo.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val selectedLanguage = spinnerLanguage.selectedItem.toString()

            if (name.isBlank()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val welcomeMessage = when (selectedLanguage) {
                    "Japanese" -> "こんにちは, $name!"
                    "Korean" -> "안녕하세요, $name!"
                    "Spanish" -> "¡Hola, $name!"
                    else -> "Welcome, $name!"
                }
                Toast.makeText(this, welcomeMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
