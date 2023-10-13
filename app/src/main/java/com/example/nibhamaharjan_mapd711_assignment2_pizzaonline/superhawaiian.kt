package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class superhawaiian : AppCompatActivity() {
    var radioGroupa: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhawaiian)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Display name of the Application
        title = "Super Hawaiian"

        radioGroupa = findViewById(R.id.radioGroup2)
        button = findViewById(R.id.button1)

        button.setOnClickListener {
            val selectedOption: Int? = radioGroupa?.checkedRadioButtonId

            if (selectedOption == null || selectedOption == -1) {
                Toast.makeText(this, "Please select a pizza size", Toast.LENGTH_SHORT).show()
            } else {

                val radioButton = findViewById<RadioButton>(selectedOption)
                val pizzaName = "Super Hawaiian"

                // Moving to Topping with size data
                startActivity(
                    Intent(this, toppings::class.java)
                        .putExtra("Pizza_Size", radioButton.text.toString())
                        .putExtra("Pizza_Name", pizzaName)
                )
            }
        }

    }

}