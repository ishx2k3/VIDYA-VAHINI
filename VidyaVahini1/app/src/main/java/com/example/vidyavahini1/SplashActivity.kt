package com.example.vidyavahini1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    // 1. Uncommented Firebase Auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 2. Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        lifecycleScope.launch {
            delay(2000) // Wait 2 seconds
            checkAuthentication()
        }
    }

    private fun checkAuthentication() {
        // 3. Actually check Firebase for a logged-in user
        val currentUser = auth.currentUser

        if (currentUser != null) {
            // User IS logged in.
            // We will leave this commented out just for one more step until we build the Dashboard/Role Selection!
             val intent = Intent(this@SplashActivity, RoleSelectionActivity::class.java)
            startActivity(intent)
        } else {
            // User is NOT logged in. Send them to your new LoginActivity!
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
        }

        finish()
    }
}