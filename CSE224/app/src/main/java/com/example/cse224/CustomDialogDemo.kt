package com.example.cse224

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomDialogDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_dialog_demo)
        val custom = findViewById<Button>(R.id.button8)
        custom.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_custom,null)
            val b = AlertDialog.Builder(this).setView(dialogView)
            b.setPositiveButton("Subscribe") { dialog, _ ->
                val e = dialogView.findViewById<EditText>(R.id.emailEditText)
                val email = e.text.toString()

                if (email.isNotBlank()) {
                    Toast.makeText(this, "Subscribed with: $email", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
                }
                dialog.dismiss()
            }
            b.setNegativeButton("Cancel") { dialog, _ ->dialog.dismiss()}
            b.create().show()
        }
    }
}