package com.example.alertdialogbox

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the button in the layout
        val showAlertButton = findViewById<Button>(R.id.buttonShowAlert)

        // Set a click listener on the button
        showAlertButton.setOnClickListener {
            // Create an AlertDialog Builder
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert Dialog Title")
            builder.setMessage("This is the message for the Alert Dialog.")

            // Set positive button and its action
            builder.setPositiveButton("OK") { dialog, _ ->
                Toast.makeText(applicationContext, "Clicked OK", Toast.LENGTH_SHORT).show()
            }

            // Set negative button and its action
            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss() // Close the dialog
            }

            // Create and show the AlertDialog
            val alertDialog = builder.create()
            alertDialog.show()
        }
        val butt =findViewById<Button>(R.id.button)
        butt.setOnClickListener{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("hey its important")
            builder.setMessage("listen to me and Prepare for war")
            builder.setPositiveButton("OK") { dialog, _ ->
                Toast.makeText(applicationContext, "Clicked Ok", Toast.LENGTH_SHORT).show()

            }
            builder.setNegativeButton("Cancel"){dialog,_->
                Toast.makeText(applicationContext,"Cancel",Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            }

            val alertDialog=builder.create()
            alertDialog.show()
        }
    }
}
