package com.example.unit5choosers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply window insets to adjust for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the ImageView and Share Button
        val imge = findViewById<ImageView>(R.id.imageView2)
        val shareButton = findViewById<Button>(R.id.button)

        // Create a file and get URI for sharing
        val imageFile = File(getExternalFilesDir(null), "famicon.jpg")
        if (imageFile.exists()) {
            val imageUri: Uri = FileProvider.getUriForFile(
                this, "${packageName}.provider", imageFile
            )

            // Set up intent for sharing the image
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, imageUri)
                type = "image/jpg"
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            }

            // Start the chooser for sharing when button is clicked
            shareButton.setOnClickListener {
                val chooser = Intent.createChooser(shareIntent, "Share image via")
                startActivity(chooser)
            }
        } else {
            Toast.makeText(this, "Image file not found.", Toast.LENGTH_SHORT).show()
        }

        // Set up the button to open MainActivity2 for permissions
        val permButton = findViewById<Button>(R.id.button3)
        permButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}
