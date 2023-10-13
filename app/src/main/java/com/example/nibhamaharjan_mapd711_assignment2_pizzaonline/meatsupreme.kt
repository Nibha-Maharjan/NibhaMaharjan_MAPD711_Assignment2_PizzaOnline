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

    //Declaring variables
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

        // Assigning id of Radio group and button
        radioGroup = findViewById(R.id.radioGroup1)
        button = findViewById(R.id.submitButton)

        //Buttoncheck id
        val selectedOption: Int = radioGroup!!.checkedRadioButtonId

        // Assigning id of the checked radio button
        radioButton = findViewById(selectedOption)

        button.setOnClickListener {
            // getting id from radiogroup
            val selectedOption: Int? = radioGroup?.checkedRadioButtonId

            // Error handling
            if (selectedOption == null || selectedOption == -1) {
                Toast.makeText(this, "Please select a pizza size", Toast.LENGTH_SHORT).show()
            } else {
                // Assigning id
                val radioButton = findViewById<RadioButton>(selectedOption)

                val pizzaName = "Meat Supreme"

                // Move to topping with size data
                startActivity(
                    Intent(this, toppings::class.java)
                        .putExtra("Pizza_Size", radioButton.text.toString())
                        .putExtra("Pizza_Name", pizzaName)
                )
            }
        }

    }
}

