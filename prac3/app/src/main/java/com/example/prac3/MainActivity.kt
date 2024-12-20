package com.example.prac3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var tvThemeStatus: TextView
    private var isDarkTheme = false // Track the current theme state

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the main layout
        setContentView(R.layout.activity_main)

        // Apply window insets for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the toolbar by its ID and set it
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Set a title (if not set in the theme)
        supportActionBar?.title = "My Action Bar"

        // Initialize views
        rootLayout = findViewById(R.id.main)
        tvThemeStatus = findViewById(R.id.tvThemeStatus)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu (menu_main.xml)
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.profile -> {
                showProfileDialog() // Show profile dialog when "Profile" is clicked
                true
            }
            R.id.action_settings -> {
                // Handle settings action here (if needed)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showProfileDialog() {
        // Inflate the custom profile dialog layout
        val dialogView = layoutInflater.inflate(R.layout.profile_options_dialog, null)
        val btnChangeTheme = dialogView.findViewById<Button>(R.id.btnChangeTheme)
        val btnChangePassword = dialogView.findViewById<Button>(R.id.btnChangePassword)

        // Create and display an AlertDialog
        val dialog = AlertDialog.Builder(this)
            .setTitle("Profile Options")
            .setView(dialogView)
            .create()

        // Handle "Change Theme" button click
        btnChangeTheme.setOnClickListener {
            toggleTheme()
            dialog.dismiss()
        }

        // Handle "Change Password" button click
        btnChangePassword.setOnClickListener {
            // Implement change password logic here (if needed)
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun toggleTheme() {
        if (isDarkTheme) {
            // Switch to Light Theme
            rootLayout.setBackgroundColor(resources.getColor(android.R.color.white, theme))
            tvThemeStatus.text = "Light Theme"
            tvThemeStatus.setTextColor(resources.getColor(android.R.color.black, theme))
        } else {
            // Switch to Dark Theme
            rootLayout.setBackgroundColor(resources.getColor(android.R.color.black, theme))
            tvThemeStatus.text = "Dark Theme"
            tvThemeStatus.setTextColor(resources.getColor(android.R.color.white, theme))
        }
        isDarkTheme = !isDarkTheme // Toggle the theme state
    }
}


