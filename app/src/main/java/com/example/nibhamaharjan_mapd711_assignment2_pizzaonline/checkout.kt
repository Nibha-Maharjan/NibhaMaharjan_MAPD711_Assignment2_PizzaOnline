package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class checkout : AppCompatActivity() {
    private lateinit var text1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        title = "Checkout"

        text1 = findViewById(R.id.textView5)

        val selectedToppings = intent.getStringArrayListExtra("selected_Toppings")
        val pizzSiz = intent.getStringExtra("pizzaSize_Check")
        val pizzNam = intent.getStringExtra("pizzaName_Check")

        val toppingsAdded = findViewById<TextView>(R.id.textView4)

        text1.text = "You have ordered a $pizzNam Pizza in $pizzSiz and your toppings are:"
        toppingsAdded.text = selectedToppings?.joinToString(", ") ?: "No toppings selected"
    }
}