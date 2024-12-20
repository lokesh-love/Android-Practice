package com.example.contactlist

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var userArrayList: ArrayList<UserData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Edge-to-edge layout adjustments
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Data initialization
        val contactProfileImages = intArrayOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,
            R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8,
            R.drawable.image9, R.drawable.image10
        )
        val contactNames = arrayOf(
            "Loki", "Pokiri", "Dumber", "Active", "Realize", "Clever",
            "Believe", "Leader", "Focus", "Teach"
        )
        val contactNumbers = arrayOf(
            "8309546739", "9247284040", "6302552201", "7413698528", "8413698528",
            "7413698568", "7413698628", "7443698528", "7413598528", "7413668528"
        )

        // Populate the user list
        userArrayList = ArrayList()
        for (i in contactProfileImages.indices) {
            val userData = UserData(contactProfileImages[i], contactNames[i], contactNumbers[i])
            userArrayList.add(userData)
        }

        // Set up the ListView and adapter
        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = ContactAdapter(this, userArrayList)

        // Set up the item click listener
        listView.setOnItemClickListener { _, _, position, _ ->
            val user = userArrayList[position]
            val intent = Intent(this, DetailedContact::class.java).apply {
                putExtra("profileImage", user.contactProfile)

            }
            startActivity(intent)
        }
    }
}
