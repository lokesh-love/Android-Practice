package com.example.cse224

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class BasicAlertDialog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_basic_alert_dialog)
        val alert= findViewById<Button>(R.id.button6)
        alert.setOnClickListener {
            val b = AlertDialog.Builder(this)
            b.setTitle("Exit")
            b.setMessage("Do you really want to exit?")
            b.setPositiveButton("Yes") { dialog, _ ->finish()}
            b.setNegativeButton("No") { dialog, _ ->dialog.dismiss()}
            b.create().show()
    }
        }
    }