package com.example.cse224

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class SnackbarClass1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snackbar_class1)
        var b= findViewById<Button>(R.id.btnsnackbar)
        b.setOnClickListener { view -> Snackbar.make(view,"Email sent",Snackbar.LENGTH_LONG)
            .setAction("undo"){    }.show()
        }
    }
}