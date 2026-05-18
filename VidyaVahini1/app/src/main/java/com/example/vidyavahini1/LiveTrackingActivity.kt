package com.example.vidyavahini1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.maplibre.android.MapLibre
import org.maplibre.android.maps.MapView

class LiveTrackingActivity : AppCompatActivity() {
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapLibre.getInstance(this)
        setContentView(R.layout.activity_livetracking)

        mapView = findViewById(R.id.fullScreenMapView)
        mapView.onCreate(savedInstanceState)

        findViewById<FloatingActionButton>(R.id.btnBackFromTracking).setOnClickListener {
            finish() // Go back to dashboard
        }

        mapView.getMapAsync { map ->
            val styleUrl = "https://tiles.locationiq.com/v3/streets/vector.json?key=pk.d18403da3eee634ecc4c91e21eae27c2"
            map.setStyle(styleUrl)
        }
    }

    override fun onStart() { super.onStart(); mapView.onStart() }
    override fun onResume() { super.onResume(); mapView.onResume() }
    override fun onPause() { super.onPause(); mapView.onPause() }
    override fun onStop() { super.onStop(); mapView.onStop() }
    override fun onLowMemory() { super.onLowMemory(); mapView.onLowMemory() }
    override fun onDestroy() { super.onDestroy(); mapView.onDestroy() }
}