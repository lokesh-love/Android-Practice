package com.example.cse224

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ButtonBarLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner

class IntentClass1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent_class1)

        var btni1 = findViewById<Button>(R.id.signup)
        var namei1 = findViewById<EditText>(R.id.nameintent)
        btni1.setOnClickListener {
            var nameee = namei1.text.toString()
            var i11 = Intent( this,IntentClass2::class.java)
            i11.putExtra("username",nameee)
            startActivity(i11)
        }
    }
}