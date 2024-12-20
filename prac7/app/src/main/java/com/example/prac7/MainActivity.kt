package com.example.prac7

import android.app.AlertDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
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

        // UI Elements
        val name = findViewById<EditText>(R.id.editTextText)
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val role = findViewById<Spinner>(R.id.spinner)
        val registerButton = findViewById<Button>(R.id.button)

        // Spinner Setup
        val roles = arrayOf("TEACHER", "ACTOR", "DOCTOR")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, roles)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        role.adapter = adapter

        // Button Click Listener
        registerButton.setOnClickListener {
            val nameText = name.text.toString()
            val emailText = email.text.toString()
            val selectedRole = role.selectedItem.toString()

            // Validate inputs
            if (nameText.isNotEmpty() && emailText.isNotEmpty() && isValidEmail(emailText)) {
                showConfirmDialog(nameText, emailText, selectedRole)
            } else {
                Toast.makeText(this, "Please fill in all the fields with valid information.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Email Validation Function
    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Confirmation Dialog Function
    private fun showConfirmDialog(name: String, email: String, role: String) {
    val dialogView = layoutInflater.inflate(R.layout.custom_alert_dialog, null)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        // Set data in dialog views
        val nameTextView = dialogView.findViewById<TextView>(R.id.tvname)
        val emailTextView = dialogView.findViewById<TextView>(R.id.tvEmail)
        val roleTextView = dialogView.findViewById<TextView>(R.id.tvRole)
        val closeButton = dialogView.findViewById<Button>(R.id.button2)

        nameTextView.text = "Name: $name"
        emailTextView.text = "Email: $email"
        roleTextView.text = "Role: $role"

        // Close Button Listener
        closeButton.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}
