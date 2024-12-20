package com.example.calculs

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.number1)
        val number2 = findViewById<EditText>(R.id.number2)
        val resultText = findViewById<TextView>(R.id.resultText)

        val addButton = findViewById<Button>(R.id.addButton)
        val subButton = findViewById<Button>(R.id.subButton)
        val divButton = findViewById<Button>(R.id.divButton)
        val mulButton = findViewById<Button>(R.id.mulButton)
        val perButton = findViewById<Button>(R.id.percent)

        addButton.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 + num2
                resultText.text = "Result: $result"
            } else {
                resultText.text = "Please enter valid numbers"
            }
        }

        subButton.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 - num2
                resultText.text = "Result: $result"
            } else {
                resultText.text = "Please enter valid numbers"
            }
        }

        divButton.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null && num2 != 0.0) { // Prevent division by zero
                val result = num1 / num2
                resultText.text = "Result: $result"
            } else {
                resultText.text = "Please enter valid numbers"
            }
        }

        mulButton.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()
            if (num1 != null && num2 != null) {
                val result = num1 * num2
                resultText.text = "Result: $result"
            } else {
                resultText.text = "Please enter valid numbers"
            }
        }

        perButton.setOnClickListener {
            val num1 = number1.text.toString().toDoubleOrNull()
            val num2 = number2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null && num2 != 0.0) { // Prevent division by zero
                val result = (num1 / num2) * 100
                resultText.text = "Result: %.2f".format(result) // Format to 2 decimal places
            } else {
                resultText.text = "Please enter valid numbers"
            }
        }
    }
}
