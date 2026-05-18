package com.example.vidyavahini1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vidyavahini1.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.maplibre.android.MapLibre
import org.maplibre.android.annotations.MarkerOptions
import org.maplibre.android.camera.CameraPosition
import org.maplibre.android.geometry.LatLng
import org.maplibre.android.maps.MapLibreMap
import org.maplibre.android.maps.MapView
import org.maplibre.android.maps.Style

class PassengerDashboardActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Initialize MapLibre BEFORE setting the content view
        MapLibre.getInstance(this)

        setContentView(R.layout.activity_passenger_dashboard)

        bottomNavigation = findViewById(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.nav_tracking
        setupBottomNavigation()

        // 2. Setup the MapView
        mapView = findViewById<MapView>(R.id.mapView)
        mapView.onCreate(savedInstanceState) // Required for MapLibre
        setupVectorMap()
    }

    private fun setupVectorMap() {
        mapView.getMapAsync { map ->

            // 3. Load the beautiful LocationIQ Vector Style using your exact token!
            val styleUrl = "https://tiles.locationiq.com/v3/streets/vector.json?key=pk.d18403da3eee634ecc4c91e21eae27c2"

            map.setStyle(styleUrl) { style ->
                // The map is fully loaded and ready!

                // Example Coordinates (Replace with real campus/bus coordinates later)
                val busLocation = LatLng(12.9716, 77.5946)

                // Zoom into the bus smoothly
                map.cameraPosition = CameraPosition.Builder()
                    .target(busLocation)
                    .zoom(15.0)
                    .build()

                // Drop a marker pin
                map.addMarker(
                    MarkerOptions()
                        .position(busLocation)
                        .title("Route 42 Bus")
                        .snippet("On Schedule")
                )
            }
        }
    }

    private fun setupBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_routes -> {
                    Toast.makeText(this, "Routes", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_tracking -> true
                R.id.nav_safety -> {
                    Toast.makeText(this, "Safety", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    // ---------------------------------------------------------
    // MapLibre Lifecycle Methods (Crucial to prevent memory leaks)
    // ---------------------------------------------------------
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }
}