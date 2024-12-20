package com.example.applyinglinearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radbut = findViewById<RadioButton>(R.id.radioButton)
        val butto = findViewById<Button>(R.id.button)



        radbut.setOnClickListener{
            radbut.text = if (radbut.isChecked) "Selected" else "RadioButton"
        }
        butto.setOnClickListener{
            radbut.isChecked = !radbut.isChecked
        }
    }
}