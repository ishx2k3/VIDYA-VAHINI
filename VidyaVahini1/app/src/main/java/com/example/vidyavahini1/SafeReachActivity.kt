package com.example.vidyavahini1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SafeReachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safereach)

        findViewById<Button>(R.id.btnSafeReachDone).setOnClickListener {
            // Move to the review screen
            startActivity(Intent(this, TripReviewActivity::class.java))
            finish()
        }
    }
}