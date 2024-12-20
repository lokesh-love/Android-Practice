package com.example.cse224

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radiocheckdemo)
       var a= findViewById<RadioGroup>(R.id.rg)
        var c1= findViewById<CheckBox>(R.id.checkBox)
        var c2= findViewById<CheckBox>(R.id.checkBox2)
       var b=findViewById<Button>(R.id.button2)
        b.setOnClickListener {
          var i=  a.checkedRadioButtonId
            val pizzaSize = when (i) {
                R.id.radioButton -> "Small"
                R.id.radioButton2 -> "Medium"
                R.id.radioButton3 -> "Large"
                else -> ""
            }
            val toppings = mutableListOf<String>()
            if (c1.isChecked) toppings.add("Pepperoni")
            if (c2.isChecked) toppings.add("Extra Cheese")
            val orderSummary = "Pizza Size: $pizzaSize\nToppings: ${toppings.joinToString(", ")}"
            Toast.makeText(this, orderSummary, Toast.LENGTH_LONG).show()
        }
    }
}