package com.example.cse224

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Listspinnerdemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listspinnerdemo)
        var spin = findViewById<Spinner>(R.id.spin)
        var options = arrayOf("login", "home", "settings")
        var a = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.adapter = a
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    1 ->  Toast.makeText(applicationContext,"hi",Toast.LENGTH_LONG).show() // Opens new activity on Option 1 selection
                    2 -> Toast.makeText(applicationContext,"hi",Toast.LENGTH_LONG).show()
                    3 -> Toast.makeText(applicationContext,"hi",Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
            private fun openNewActivity(option: Int) {
                Toast.makeText(applicationContext,"hi",Toast.LENGTH_LONG).show()
            }

        }
    }
}
