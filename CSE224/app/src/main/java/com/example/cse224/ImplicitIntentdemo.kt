package com.example.cse224

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitIntentdemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intentdemo)
        val et1=findViewById<Button>(R.id.url)
        val btn1=findViewById<Button>(R.id.Navigate)
        val btn2=findViewById<Button>(R.id.btnCam)
        val btn3=findViewById<Button>(R.id.call)
        val btn4=findViewById<Button>(R.id.btncontact)
        val btn5=findViewById<Button>(R.id.gallery)
        val btn6=findViewById<Button>(R.id.btndial)

        btn1.setOnClickListener {
            val i1= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(i1)
        }
        btn2.setOnClickListener {
            val i2=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(i2)
        }
        btn3.setOnClickListener {
            val i3: Intent =Intent(Intent.ACTION_VIEW)
            i3.setType(CallLog.Calls.CONTENT_TYPE)
            startActivity(i3)
        }
        btn4.setOnClickListener {
            val i4=Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivity(i4)
        }
        btn5.setOnClickListener {
            val i5=Intent()
            i5.action=Intent.ACTION_VIEW
            i5.type="image/*"
            startActivity(i5)
        }
        btn6.setOnClickListener {
            val i6= Intent(Intent.ACTION_DIAL)
            i6.setData(Uri.parse("tel:+91123456789"))
            startActivity(i6)
        }
    }
}