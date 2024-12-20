package com.example.policyhub

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
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

        val Textview = findViewById<TextView>(R.id.textView)
        val image1view = findViewById<ImageView>(R.id.imageView)
        val spin = findViewById<Spinner>(R.id.spinner)
        val button = findViewById<Button>(R.id.button)
        val image2view =findViewById<ImageView>(R.id.imageView2)
        val premiumTextView =findViewById<TextView>(R.id.premiumTextView)
        val agegroups= arrayOf("Below 18","18 to 60","Above 60")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,agegroups)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = adapter


        button.setOnClickListener {
            val selectedagegroup = spin.selectedItem.toString()
            val premium = when (selectedagegroup) {
                "Below 18" -> "8000/-"
                "18 to 60" -> "10000/-"
                "Above 60" -> "16000/-"
                else -> "0/-"
            }

            premiumTextView.text = "Your Premium is $premium per year"
        }

    }
}