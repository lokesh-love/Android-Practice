package com.example.cse224

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Radiocheckclass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radiocheckclass)
        var a=findViewById<RadioGroup>(R.id.rgzsize)
        var placeorder=findViewById<Button>(R.id.placeorder)
        var paneer=findViewById<CheckBox>(R.id.checkBox4)
        var corn=findViewById<CheckBox>(R.id.checkBox5)
        var mushroom= findViewById<CheckBox>(R.id.checkBox6)
        placeorder.setOnClickListener {
            var size=a.checkedRadioButtonId
            var finalsize = when(size){
                R.id.radioButton6 -> "large"
                R.id.radioButton4 -> "medium"
                R.id.radioButton5 ->"small"
                else -> "choose any one option"
            }
            var topping=mutableListOf<String>()
            if (paneer.isChecked) topping.add("Paneer")
            if (corn.isChecked) topping.add("Corn")
            if (mushroom.isChecked) topping.add("Mushroom")
          Toast.makeText(this,"You Selected"+ finalsize + "Pizza with toppings"+topping,Toast.LENGTH_LONG).show()

        }
    }
}