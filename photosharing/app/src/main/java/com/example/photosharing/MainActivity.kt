package com.example.photosharing
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uploadPhotoButton = findViewById<Button>(R.id.button)

// On button click, check permissions
        uploadPhotoButton.setOnClickListener {
            checkPermissionAndProceed()
        }
    }

    private fun checkPermissionAndProceed() {
        val permission = Manifest.permission.READ_EXTERNAL_STORAGE

        when {
// If permission is already granted
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED -> {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            }

// If permission is denied but not permanently
            shouldShowRequestPermissionRationale(permission) -> {
                showRationaleDialog()
            }

// If permission is denied permanently
            else -> {
                requestPermissionLauncher.launch(permission)
            }
        }
    }

    // Permission result handling
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            } else {
// Check if permission is permanently denied
                if (!shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    showSettingsDialog() // Guide user to app settings
                } else {
                    showRationaleDialog() // Show rationale dialog
                }
            }
        }

    // Show a rationale dialog explaining why the permission is needed
    private fun showRationaleDialog() {
        AlertDialog.Builder(this)
            .setTitle("Storage Access Required")
            .setMessage("This app needs access to your device storage to upload photos. Please grant the permission.")
            .setPositiveButton("Try Again") { _, _ ->
                requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    // Show a dialog to guide users to app settings for permanently denied permissions
    private fun showSettingsDialog() {
        AlertDialog.Builder(this)
            .setTitle("Permission Required")
            .setMessage("Storage access permission has been permanently denied. Please go to the app settings to enable it.")
            .setPositiveButton("Open Settings") { _, _ ->
                val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", packageName, null)
                }
                startActivity(intent)
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}