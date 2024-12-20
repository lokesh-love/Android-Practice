package com.example.customalertdialogbox

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        val emailEditText = findViewById<TextView>(R.id.emailEditText)
        val passwordEditText = findViewById<TextView>(R.id.passwordEditText)
        val termsCheckBox = findViewById<CheckBox>(R.id.termsCheckBox)
        val submitButton = findViewById<Button>(R.id.submitButton)


        submitButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val termsAccepted = termsCheckBox.isChecked
            val isPasswordValid = password.length >= 8
            val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

            // Show the custom dialog with the results
            showVerificationDialog(isPasswordValid, isEmailValid, termsAccepted)
        }
    }

    private fun showVerificationDialog(passwordValid: Boolean, emailValid: Boolean, termsAccepted: Boolean) {
        // Inflate the custom dialog layout
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_verification_result, null)

        // Create the AlertDialog

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        // Get references to the dialog views
        val passwordStatusTextView = dialogView.findViewById<TextView>(R.id.passwordStatusTextView)
        val emailStatusTextView = dialogView.findViewById<TextView>(R.id.emailStatusTextView)
        val termsStatusTextView = dialogView.findViewById<TextView>(R.id.termsStatusTextView)
        val okButton = dialogView.findViewById<Button>(R.id.okButton)

        // Set the status messages based on validation results
        passwordStatusTextView.text = if (passwordValid) "Password check: Passed" else "Password check: Failed (min 8 characters)"
        emailStatusTextView.text = if (emailValid) "Email format check: Passed" else "Email format check: Failed"
        termsStatusTextView.text = if (termsAccepted) "Terms and conditions: Accepted" else "Terms and conditions: Not accepted"

        // Set OK button click listener to dismiss the dialog
        okButton.setOnClickListener {
            alertDialog.dismiss()
        }



        // Show the dialog
        alertDialog.show()
    }
}
