package com.example.cse224

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ContextmenuExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contextmenu_example)
        var j1 = findViewById<ImageView>(R.id.myImageView)
        registerForContextMenu(j1)
    }
    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val j2: MenuInflater = menuInflater
        j2.inflate(R.menu.context_menu, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        var j1 = findViewById<ImageView>(R.id.myImageView)
        return when (item.itemId) {
            R.id.change_color -> {
                j1.setColorFilter(Color.RED)
                Toast.makeText(this, "Image color changed to red", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.rotate -> {
                j1.rotation = j1.rotation + 45f
                Toast.makeText(this, "Image rotated by 45 degrees", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}