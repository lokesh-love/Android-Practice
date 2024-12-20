package com.example.cse224

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DialogClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dialog_class)
        var btndialog = findViewById<Button>(R.id.button7)
        btndialog.setOnClickListener {
            var b =AlertDialog.Builder(this)
            b.setTitle("Exit")
            b.setMessage("Do you really want to exit")
            b.setCancelable(false)
            b.setPositiveButton("Yes"){dialog,_ -> finish()}
            b.setNegativeButton("No"){dialog,_ ->dialog.dismiss()}
            b.create().show()
        }
    }
}