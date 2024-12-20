package com.example.cse224

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppChooserClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_chooser_class)
        val s1 = findViewById<Button>(R.id.send1)
        s1.setOnClickListener {
            shareText("this text is being shared")
        }
        11
        
    }
    private fun shareText(msg: String) {
        var send: Intent =Intent().apply {
            action= Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,msg)
            type="text/plain"
        }
        var i: Intent= Intent.createChooser(send,"share via")
        startActivity(i)
    }
}