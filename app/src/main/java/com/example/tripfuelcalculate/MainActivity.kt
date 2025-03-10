package com.example.tripfuelcalculate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtDistance = findViewById<TextInputEditText>(R.id.distance)
        val edtAutonomy = findViewById<TextInputEditText>(R.id.autonomy)
        val edtPrice = findViewById<TextInputEditText>(R.id.price)

        val result = findViewById<Button>(R.id.button)

        result.setOnClickListener() {

            val distance: String = edtDistance.text.toString()
            val autonomy: String = edtAutonomy.text.toString()
            val price: String = edtPrice.text.toString()

            if (distance.isEmpty() || autonomy.isEmpty() || price == "") {
                Snackbar.make(edtDistance, "You must place a valid value for each field.", Snackbar.LENGTH_LONG).show()

            } else {

                val edtDist: Float = distance.toFloat()
                val edtAut: Float = autonomy.toFloat()
                val edtPrice: Float = price.toFloat()

                val result: Float = (edtDist / edtAut) * edtPrice

                val intent = Intent(this, ResultAct::class.java)
                intent.putExtra(TripCalc_KEY, result)
                startActivity(intent)

            }
        }
    }
}