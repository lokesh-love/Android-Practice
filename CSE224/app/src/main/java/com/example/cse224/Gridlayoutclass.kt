package com.example.cse224

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Gridlayoutclass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gridlayoutclass)
        var a=findViewById<ImageButton>(R.id.imageButton8)
        a.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java) // Passing selected option to the next activity
            startActivity(intent)
        }
    }
}