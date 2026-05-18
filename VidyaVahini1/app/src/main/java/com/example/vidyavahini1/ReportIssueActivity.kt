package com.example.vidyavahini1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReportIssueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportissue)

        val etIssueType = findViewById<EditText>(R.id.etIssueType)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val btnSubmitReport = findViewById<Button>(R.id.btnSubmitReport)

        btnSubmitReport.setOnClickListener {
            val type = etIssueType.text.toString()
            val desc = etDescription.text.toString()

            if (type.isNotEmpty() && desc.isNotEmpty()) {
                Toast.makeText(this, "Report submitted successfully.", Toast.LENGTH_SHORT).show()
                finish() // Go back to dashboard
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}