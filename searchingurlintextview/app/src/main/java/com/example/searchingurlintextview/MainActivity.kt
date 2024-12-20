package com.example.searchingurlintextview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val butt1 = findViewById<Button>(R.id.button)
        val urlslin =findViewById<EditText>(R.id.editTextText)
        val but2=findViewById<Button>(R.id.button2)
        butt1.setOnClickListener{
            val url=urlslin.text.toString()
            if(url.isNotEmpty()) {

                val intr = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intr)
            }else{
                Toast.makeText(this,"ARAE PUKA PANI CHAESAE LINK PETTU",Toast.LENGTH_SHORT).show()
            }
        }

        but2.setOnClickListener{
            val pnt = Intent(this,secondactivity::class.java)
            startActivity(pnt)
        }








    }
}