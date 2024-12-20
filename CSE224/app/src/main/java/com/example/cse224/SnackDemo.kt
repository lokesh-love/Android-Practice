package com.example.cse224

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class SnackDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_snackdemo)
        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)

        btn1.setOnClickListener(){
            val s1 = Snackbar.make(it,"ACTION CALL SNACKBAR",Snackbar.LENGTH_INDEFINITE)
            s1.setAction("DISMISS",){s1.dismiss()}
            s1.show()
        }

        btn2.setOnClickListener(View.OnClickListener {
            val s2 = Snackbar.make(it,"ACTION CALL SNACKBAR---Undo",Snackbar.LENGTH_LONG)
            s2.setAction("Undo",View.OnClickListener {
                val s3 = Snackbar.make(it,"Message Undo",Snackbar.LENGTH_LONG)
                s3.show()
            })
            s2.show()
        })
        }
}