package com.example.vidyavahini1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SosAlertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sosalert)

        val btnTriggerSos = findViewById<FloatingActionButton>(R.id.btnTriggerSos)
        val btnCancelSos = findViewById<Button>(R.id.btnCancelSos)

        btnTriggerSos.setOnClickListener {
            Toast.makeText(this, "🚨 SOS ALERT SENT WITH LOCATION 🚨", Toast.LENGTH_LONG).show()
        }

        btnCancelSos.setOnClickListener {
            finish() // Closes this screen and goes back to Dashboard
        }
    }
}