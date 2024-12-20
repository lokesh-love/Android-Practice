package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val buttonSaveTask = findViewById<Button>(R.id.buttonSaveTask)
        val editTextTask = findViewById<EditText>(R.id.editTextTask)

        buttonSaveTask.setOnClickListener {
            val taskDescription = editTextTask.text.toString().trim()

            if (taskDescription.isNotEmpty()) {
                val intent = Intent().apply {
                    putExtra("TASK_DESCRIPTION", taskDescription)
                }
                setResult(RESULT_OK, intent)
                finish()
            } else {
                editTextTask.error = "Please enter a task description"
            }
        }
    }
}
