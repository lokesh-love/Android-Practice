package com.example.cse224

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class Localexample2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_localexample2)
        val buttonEnglish = findViewById<Button>(R.id.btneng)
        val buttonHindi = findViewById<Button>(R.id.btnhindi)
        buttonEnglish.setOnClickListener {
            setLocale("en")
        }

        buttonHindi.setOnClickListener {
            setLocale("hi")
        }
    }
    fun setLocale(langCode: String) {
        // Check if the current locale is different before applying the new one
        val current = resources.configuration.locales.get(0).language
        if (langCode != current)
        {
            val l = Locale(langCode)
            Locale.setDefault(l)
            val c = Configuration(resources.configuration)
            c.setLocale(l)
            resources.updateConfiguration(c, resources.displayMetrics)
        }
        recreate()


}
}