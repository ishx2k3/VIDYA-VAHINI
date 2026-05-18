package com.example.vidyavahini1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.maplibre.android.MapLibre
import org.maplibre.android.annotations.MarkerOptions
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapView

class DriverDashboardActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var mapView: MapView
    private lateinit var btnTripAction: Button

    private var isTripActive = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MapLibre.getInstance(this)
        setContentView(R.layout.activity_driverdashboard)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        btnTripAction = findViewById(R.id.btnTripAction)

        // Highlight "Home" for the driver
        bottomNavigation.selectedItemId = R.id.nav_home

        setupBottomNavigation()
        setupTripButton()

        mapView = findViewById(R.id.driverMapView)
        mapView.onCreate(savedInstanceState)
        setupVectorMap()
    }

    private fun setupTripButton() {
        btnTripAction.setOnClickListener {
            isTripActive = !isTripActive

            if (isTripActive) {
                btnTripAction.text = "END TRIP"
                btnTripAction.setBackgroundColor(android.graphics.Color.parseColor("#E53935")) // Red
                Toast.makeText(this, "Trip Started! Location sharing active.", Toast.LENGTH_SHORT).show()
            } else {
                btnTripAction.text = "START TRIP"
                btnTripAction.setBackgroundColor(android.graphics.Color.parseColor("#4CAF50")) // Green
                Toast.makeText(this, "Trip Ended.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupVectorMap() {
        mapView.getMapAsync { map ->
            val styleUrl = "https://tiles.locationiq.com/v3/streets/vector.json?key=pk.d18403da3eee634ecc4c91e21eae27c2"

            map.setStyle(styleUrl) { style ->
                // Example Driver Location
                val currentLocation = LatLng(12.9716, 77.5946)

                map.cameraPosition = CameraPosition.Builder()
                    .target(currentLocation)
                    .zoom(16.0)
                    .build()

                map.addMarker(
                    MarkerOptions()
                        .position(currentLocation)
                        .title("You are here")
                )
            }
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_routes -> {
                    Toast.makeText(this, "Routes List", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_tracking -> {
                    Toast.makeText(this, "Tracking View", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_safety -> {
                    val intent = android.content.Intent(this, SosAlertActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }

    // --- MapLibre Lifecycle Methods ---
    override fun onStart() { super.onStart(); mapView.onStart() }
    override fun onResume() { super.onResume(); mapView.onResume() }
    override fun onPause() { super.onPause(); mapView.onPause() }
    override fun onStop() { super.onStop(); mapView.onStop() }
    override fun onLowMemory() { super.onLowMemory(); mapView.onLowMemory() }
    override fun onDestroy() { super.onDestroy(); mapView.onDestroy() }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}