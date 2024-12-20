package com.example.cse224

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppChooserDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_chooser_demo)
        val s1: Button = findViewById(R.id.sb1)
        s1.setOnClickListener {
            shareText("Hello, choose an app to share this message!")
        }
    }
    fun shareText(msg: String) {
        val send: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, msg)
            type = "text/plain"
        }
        val chooser: Intent = Intent.createChooser(send, "Share via")
        startActivity(chooser)
    }
    }