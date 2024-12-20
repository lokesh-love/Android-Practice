package com.example.navigationtoexplictintent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1=findViewById<EditText>(R.id.editTextText)
        val num2=findViewById<EditText>(R.id.editTextText2)
        val rest=findViewById<TextView>(R.id.editTextText3)
        val addbut=findViewById<Button>(R.id.button4)

        addbut.setOnClickListener{
            val m = num1.text.toString().toDoubleOrNull()
            val n =num2.text.toString().toDoubleOrNull()

            if (m != null && n != null) {
                val r = m + n
                rest.text = "Addition is $r"
            } else {
                rest.text = "Please enter valid numbers."
            }
        }


    }
}