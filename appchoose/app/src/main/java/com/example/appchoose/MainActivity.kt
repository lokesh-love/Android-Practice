package com.example.appchoose

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageView: ImageView = findViewById(R.id.imageView)
        val shareButton: Button = findViewById(R.id.shareButton)

        // Set the OnClickListener for the button
        shareButton.setOnClickListener {
            // Get the image file from the drawable folder

            val imageFile = File(getExternalFilesDir(null), "my_image.png")
            // Get the Uri for the image file using FileProvider
            val imageUri: Uri = FileProvider.getUriForFile(
                this, "${packageName}.provider", imageFile
            )
            // Create an Intent to share the image
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "image/png"
                // Grant temporary read permission to the receiving apps
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            }
            // Create a chooser to allow the user to pick an app
            val chooser = Intent.createChooser(shareIntent, "Share Image via")
            startActivity(chooser)

        }
    }
}