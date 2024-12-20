package com.example.sanackbar

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import androidx.constraintlayout.widget.ConstraintLayout
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Enable edge-to-edge support
        setContentView(R.layout.activity_main)

        // Apply WindowInsets to handle padding for system bars (status and navigation bars)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Reference the layout and button
        val rootLayout = findViewById<ConstraintLayout>(R.id.main)
        val button = findViewById<Button>(R.id.button)

        // Set a click listener on the button to show the Snackbar
        button.setOnClickListener {
            // Create and show the Snackbar
            val snackbar = Snackbar.make(rootLayout, "Hello, this is a Snackbar!", Snackbar.LENGTH_SHORT)

            // Customize Snackbar appearance
            snackbar.setTextColor(Color.WHITE)
            snackbar.setBackgroundTint(Color.BLACK)

            // Set an action on the Snackbar
            snackbar.setAction("UNDO") {
                // Display a secondary Snackbar when "Undo" is clicked
                Snackbar.make(rootLayout, "Undo clicked!", Snackbar.LENGTH_SHORT).show()
            }
            snackbar.setActionTextColor(Color.YELLOW)  // Set the action button text color

            // Show the Snackbar
            snackbar.show()


        }
    }
}
