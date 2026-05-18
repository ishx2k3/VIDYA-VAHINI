package com.example.vidyavahini1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RoleSelectionActivity : AppCompatActivity() {

    // Updated variables to match your XML IDs perfectly!
    private lateinit var cardPassenger: MaterialCardView
    private lateinit var cardDriver: MaterialCardView
    private lateinit var btnContinue: Button
    private lateinit var progressBar: ProgressBar

    private var selectedRole = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_role_selection)

        // Linking variables to your XML IDs
        cardPassenger = findViewById(R.id.cardPassenger)
        cardDriver = findViewById(R.id.cardDriver)
        btnContinue = findViewById(R.id.btnContinue)
        progressBar = findViewById(R.id.progressBar)

        // Disable button initially until a role is selected
        btnContinue.isEnabled = false

        cardPassenger.setOnClickListener {
            selectRole("PASSENGER", cardPassenger, cardDriver)
            btnContinue.text = "Continue as Passenger"
        }

        cardDriver.setOnClickListener {
            selectRole("DRIVER", cardDriver, cardPassenger)
            btnContinue.text = "Continue as Driver"
        }

        btnContinue.setOnClickListener {
            if (selectedRole.isNotEmpty()) {
                saveUserToDatabase()
            } else {
                Toast.makeText(this, "Please select a role", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun selectRole(role: String, selected: MaterialCardView, unselected: MaterialCardView) {
        selectedRole = role

        // Highlight the selected card with a blue border
        selected.strokeWidth = 8
        selected.strokeColor = android.graphics.Color.parseColor("#0C6B8A")

        // Remove the border from the other card
        unselected.strokeWidth = 0

        // Enable the continue button
        btnContinue.isEnabled = true
    }

    private fun saveUserToDatabase() {
        progressBar.visibility = View.VISIBLE
        btnContinue.isEnabled = false

        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            // We use the Firebase UID instead of a phone number!
            val userProfile = hashMapOf(
                "email" to (user.email ?: "No Email"),
                "role" to selectedRole
            )

            // Save to Firestore Database
            FirebaseFirestore.getInstance().collection("users").document(user.uid)
                .set(userProfile)
                .addOnSuccessListener {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, "Profile Saved!", Toast.LENGTH_SHORT).show()

                    // Route them based on their choice!
                    val intent = if (selectedRole == "PASSENGER") {
                        Intent(this, PassengerDashboardActivity::class.java)
                    } else {
                        Intent(this, DriverDashboardActivity::class.java)
                    }

                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener { e ->
                    progressBar.visibility = View.GONE
                    btnContinue.isEnabled = true
                    Toast.makeText(this, "Database Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
        } else {
            progressBar.visibility = View.GONE
            btnContinue.isEnabled = true
            Toast.makeText(this, "Error: No user logged in.", Toast.LENGTH_SHORT).show()
        }
    }
}