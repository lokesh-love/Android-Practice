package com.example.cse224

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IntentDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent_demo)
        var nameedit = findViewById<EditText>(R.id.nameedit)
        var ageedit = findViewById<EditText>(R.id.ageedit)
        var intentbtn = findViewById<Button>(R.id.intentbutton)
        intentbtn.setOnClickListener {
            var z = nameedit.text.toString()
            var y = ageedit.text.toString()
            var i = Intent(this,intent2::class.java)
            i.putExtra("z1",z)
            i.putExtra("y1",y)
            startActivity(i)

        }
    }
}