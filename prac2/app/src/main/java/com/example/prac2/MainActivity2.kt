package com.example.prac2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    private lateinit var mainLayout: ConstraintLayout
    private lateinit var themeStatus: TextView
    private var isDarkTheme = false // Track theme state

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Enables edge-to-edge layout
        setContentView(R.layout.activity_main) // Corrected layout file reference

        // Adjust layout for system bars
      // Ensure ID matches your layout
         // For displaying theme status

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu) // Ensure `menu_main.xml` exists in `res/menu`
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.change_theme -> {
                toggleTheme() // Handle theme toggle
                return true
            }
            R.id.change_password -> {
                showChangePasswordDialog() // Open Change Password Dialog
                return true
            }
            R.id.menu_settings -> {
                themeStatus.text = "Settings clicked" // Placeholder for settings action
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun toggleTheme() {
        isDarkTheme = !isDarkTheme
        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            themeStatus.text = "Dark Theme Activated"
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            themeStatus.text = "Light Theme Activated"
        }
    }

    private fun showChangePasswordDialog() {
        val passwordDialog = AlertDialog.Builder(this)
        passwordDialog.setTitle("Change Password")
        passwordDialog.setMessage("Password change functionality is under development.")
        passwordDialog.setPositiveButton("Ok") { dialog, _ -> dialog.dismiss() }
        passwordDialog.show()
    }
}
