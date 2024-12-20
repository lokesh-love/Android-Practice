package com.example.prac5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val message=intent.getStringExtra("Message")?: "Nomessage"
        val extraInfo = intent.getIntExtra("EXTRA_INFO", -1)

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Received: $message\nExtra Info: $extraInfo"

        val butt2 = findViewById<Button>(R.id.button2)
        butt2.setOnClickListener{
            val inte=Intent(this,MainActivity::class.java)
            startActivity(inte)
        }

    }
}