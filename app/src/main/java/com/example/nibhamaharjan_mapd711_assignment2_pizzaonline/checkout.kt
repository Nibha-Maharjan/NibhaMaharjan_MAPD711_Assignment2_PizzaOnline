package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class checkout : AppCompatActivity() {
    private lateinit var text1 : TextView
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)


        title = "Checkout"
        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        text1 = findViewById(R.id.textView5)


        val toppingsAdded = findViewById<TextView>(R.id.textView4)

        val selectedToppings = sharedPrefs.getString("selected_toppings", "")
        val selectedpname = sharedPrefs.getString("pname","")
        val selectedpsize = sharedPrefs.getString("psize","")

        text1.text="$selectedpname Pizza of size $selectedpsize"
        // Use the retrieved data as needed
        val message = "Selected Toppings: $selectedToppings"
        toppingsAdded.text = message

//
//        text1.text = "You have ordered a $pizzNam Pizza in $pizzSiz and your toppings are:"
//        toppingsAdded.text = selectedToppings?.joinToString(", ") ?: "No toppings selected"
    }
}