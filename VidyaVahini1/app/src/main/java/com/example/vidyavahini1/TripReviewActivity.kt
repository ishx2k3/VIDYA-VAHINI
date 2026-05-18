package com.example.vidyavahini1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TripReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tripreview)

        findViewById<Button>(R.id.btnSubmitReview).setOnClickListener {
            Toast.makeText(this, "Thank you for your feedback!", Toast.LENGTH_SHORT).show()
            finish() // Ends the flow and returns to Dashboard
        }
    }
}