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

class ListViewClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view_class)
        var data = findViewById<EditText>(R.id.editlist)
        var add = findViewById<Button>(R.id.button5)
        var listt = findViewById<ListView>(R.id.datalist)
        var b = ArrayList<String>()
        var d: ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,b)
        listt.adapter=d
        add.setOnClickListener {
            var item = data.text.toString()
            if(item.isNotEmpty()){
              b.add(item)
              data.text.clear()
              d.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this,"no data entered",Toast.LENGTH_LONG).show()
            }
        }
    }
}