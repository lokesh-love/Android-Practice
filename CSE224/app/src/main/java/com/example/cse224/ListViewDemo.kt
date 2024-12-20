package com.example.cse224

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListViewDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_demo)
        var a=findViewById<EditText>(R.id.editlist)
        var b=findViewById<Button>(R.id.listbtn)
        var c=findViewById<ListView>(R.id.listdisp)
        var item= ArrayList<String>()
        var d: ArrayAdapter<String> = ArrayAdapter(this,R.layout.list_item,R.id.txt,item)
         c.adapter=d
        b.setOnClickListener {
            var e=a.text.toString()
            if(e.isNotEmpty())
            {
                item.add(e)
                d.notifyDataSetChanged()
                a.text.clear()
            }
            else
            {
                Toast.makeText(this,"no value entered",Toast.LENGTH_LONG).show()
            }
        }
    }
}