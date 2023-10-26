package com.example.pieshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val launchSecondActivityButton = findViewById<View>(R.id.launchSecondActivityButton)
        val checkbox1 = findViewById<CheckBox>(R.id.checkbox1)
        val checkbox2 = findViewById<CheckBox>(R.id.checkbox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkbox3)


        val checkbox4 = findViewById<CheckBox>(R.id.checkbox4)
        val checkbox5 = findViewById<CheckBox>(R.id.checkbox5)
        val checkbox6 = findViewById<CheckBox>(R.id.checkbox6)
        val checkbox7 = findViewById<CheckBox>(R.id.checkbox7)

        val checkbox8 = findViewById<CheckBox>(R.id.checkbox8)
        val checkbox9 = findViewById<CheckBox>(R.id.checkbox9)
        val checkbox10 = findViewById<CheckBox>(R.id.checkbox10)
        launchSecondActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val dataToSend = ArrayList<String>()

            if (checkbox1.isChecked) {
                dataToSend.add("Buko Pie")
            }
            if (checkbox2.isChecked) {
                dataToSend.add("Mango Pie")
            }
            if (checkbox3.isChecked) {
                dataToSend.add("Ube Pie")
            }

            val size = ArrayList<String>()
            if (checkbox8.isChecked) {
                size.add("Small")
            }
            if (checkbox9.isChecked) {
                size.add("Medium")
            }
            if (checkbox10.isChecked) {
                size.add("Large")
            }

            val toppings = ArrayList<String>()
            if (checkbox4.isChecked) {
                toppings.add("Chocolate")
            }
            if (checkbox5.isChecked) {
                toppings.add("Sprinkles")
            }
            if (checkbox6.isChecked) {
                toppings.add("Cheese")
            }
            if (checkbox7.isChecked) {
                toppings.add("Caramel")
            }

            // Calculate the total price based on the selected items
            val totalPrice = calculatePrice(dataToSend, size, toppings)

            intent.putStringArrayListExtra("pies", dataToSend)
            intent.putStringArrayListExtra("size", size)
            intent.putStringArrayListExtra("toppings", toppings)
            intent.putExtra("totalPrice", totalPrice)

            startActivity(intent)
        }
    }

    private fun calculatePrice(pies: List<String>, size: List<String>, toppings: List<String>): Double {
        // Define the prices for different pies and sizes
        val piePrices = mapOf(
            "Buko Pie" to 35.0,
            "Mango Pie" to 35.0,
            "Ube Pie" to 40.0
        )
        val sizePrices = mapOf(
            "Small" to 0.0,
            "Medium" to 15.0,
            "Large" to 30.0
        )
        val toppingPrice = 4.50  // Price per topping

        // Calculate the total price
        var totalPrice = 0.0
        for (pie in pies) {
            totalPrice += piePrices[pie] ?: 0.00
        }
        for (selectedSize in size) {
            totalPrice += sizePrices[selectedSize] ?: 0.00
        }
        totalPrice += toppings.size * toppingPrice

        return totalPrice
    }
}
