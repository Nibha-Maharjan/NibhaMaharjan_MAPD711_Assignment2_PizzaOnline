package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class toppings : AppCompatActivity() {

    private lateinit var textName : TextView

    private lateinit var checkBox: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox
    private lateinit var checkBox5: CheckBox
    private lateinit var checkBox6: CheckBox

    private lateinit var checkoutButton: Button
    private lateinit var selectedToppings: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toppings)

        title = "Toppings Page"

        textName = findViewById(R.id.textView)

        checkBox = findViewById(R.id.checkBox)
        checkBox2 = findViewById(R.id.checkBox2)
        checkBox3 = findViewById(R.id.checkBox3)
        checkBox4 = findViewById(R.id.checkBox4)
        checkBox5 = findViewById(R.id.checkBox5)
        checkBox6 = findViewById(R.id.checkBox6)


        val pizzaSize = intent.getStringExtra("Pizza_Size")
        val pizzaName = intent.getStringExtra("Pizza_Name")

        textName.text = "You have ordered a $pizzaName Pizza in $pizzaSize"

        selectedToppings = ArrayList()

        checkoutButton = findViewById(R.id.button)
        checkoutButton.setOnClickListener {
            // Check if each CheckBox is checked and add its text to the ArrayList
            if (checkBox.isChecked) {
                selectedToppings.add(checkBox.text.toString())
            }
            if (checkBox2.isChecked) {
                selectedToppings.add(checkBox2.text.toString())
            }
            if (checkBox3.isChecked) {
                selectedToppings.add(checkBox3.text.toString())
            }
            if (checkBox4.isChecked) {
            selectedToppings.add(checkBox4.text.toString())
            }
            if (checkBox5.isChecked) {
            selectedToppings.add(checkBox5.text.toString())
            }
            if (checkBox6.isChecked) {
            selectedToppings.add(checkBox6.text.toString())
            }

            // Create an Intent to start the CheckoutActivity
            val intent = Intent(this, checkout::class.java)
            // Pass the selected toppings as extra data
            intent.putStringArrayListExtra("selected_Toppings", selectedToppings)
            intent.putExtra("pizzaSize_Check", pizzaSize)
            intent.putExtra("pizzaName_Check", pizzaName)
            startActivity(intent)
        }


    }
}