package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class toppings : AppCompatActivity() {

    private lateinit var textName : TextView
    private lateinit var textName1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toppings)

        title = "Toppings Page"

        textName = findViewById(R.id.textView)


        val pizzaSize = intent.getStringExtra("Pizza_Size")
        val pizzaName = intent.getStringExtra("Pizza_Name")

        textName.text = "You have ordered a $pizzaName Pizza in $pizzaSize"
    }
}