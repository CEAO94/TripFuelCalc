package com.example.tripfuelcalculate

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

const val TripCalc_KEY = "ResultAct"

class ResultAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(TripCalc_KEY, 0f)

        val value = findViewById<TextView>(R.id.value)
        val message = findViewById<TextView>(R.id.msg)

        value.text = "€ " + result.toString()

    }
}