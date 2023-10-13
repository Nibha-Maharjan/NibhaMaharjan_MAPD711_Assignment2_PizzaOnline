package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class meatsupreme : AppCompatActivity() {

    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var button: Button

    private lateinit var btnSendData: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meatsupreme)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Display name of the Application
        title = "Meat Supreme"

        // Assigning id of RadioGroup
        radioGroup = findViewById(R.id.radioGroup1)

        // Assigning id of Submit button
        button = findViewById(R.id.submitButton)

        // Actions to be performed
        // when Submit button is clicked

        // Getting the checked radio button id
        // from the radio group
        val selectedOption: Int = radioGroup!!.checkedRadioButtonId

        // Assigning id of the checked radio button
        radioButton = findViewById(selectedOption)

        button.setOnClickListener {
            // Getting the checked radio button id from the radio group
            val selectedOption: Int? = radioGroup?.checkedRadioButtonId

            // If no radio button is selected, show a toast message
            if (selectedOption == null || selectedOption == -1) {
                Toast.makeText(this, "Please select a pizza size", Toast.LENGTH_SHORT).show()
            } else {
                // Assigning id of the checked radio button
                val radioButton = findViewById<RadioButton>(selectedOption)

                val pizzaName = "Meat Supreme"

                // Start the ToppingsActivity with selected pizza size data
                startActivity(
                    Intent(this, toppings::class.java)
                        .putExtra("Pizza_Size", radioButton.text.toString())
                        .putExtra("Pizza_Name", pizzaName)
                )
            }
        }

    }
}

