package com.example.pieshop

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val displayText: TextView = findViewById(R.id.displayTxt)
        val receivedPies = intent.getStringArrayListExtra("pies")
        val size = intent.getStringArrayListExtra("size")

        val receivedToppings = intent.getStringArrayListExtra("toppings")
        val toppingsText = if (!receivedToppings.isNullOrEmpty()) {
            receivedToppings.joinToString(", ")
        } else {
            "No toppings selected"
        }
        val totalPrice = intent.getDoubleExtra("totalPrice", 0.0)

        if (!receivedPies.isNullOrEmpty()) {
            val piesText = receivedPies.joinToString(", ")

            if (!size.isNullOrEmpty()) {
                val piesSize = size.joinToString(", ")

                // Append the toppings information to your order details
                val orderDetails =
                    "Selected Pies: $piesText \nSize: $piesSize \nToppings: $toppingsText \nTotal Price: Php $totalPrice"

                displayText.text = orderDetails
            }
        }
    }
}


