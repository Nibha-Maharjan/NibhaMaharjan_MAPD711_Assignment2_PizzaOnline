package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
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
    private lateinit var sharedPrefs: SharedPreferences

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

        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        checkoutButton = findViewById(R.id.button)
        checkoutButton.setOnClickListener {
            // Save checkbox names to SharedPreferences as a comma-separated String
            val selectedToppings = StringBuilder()
            if (checkBox.isChecked) {
                selectedToppings.append(checkBox.text).append(", ")
            }
            if (checkBox2.isChecked) {
                selectedToppings.append(checkBox2.text).append(", ")
            }
            if (checkBox3.isChecked) {
                selectedToppings.append(checkBox3.text).append(", ")
            }
            if (checkBox4.isChecked) {
                selectedToppings.append(checkBox4.text).append(", ")
            }
            if (checkBox5.isChecked) {
                selectedToppings.append(checkBox5.text).append(", ")
            }
            if (checkBox6.isChecked) {
                selectedToppings.append(checkBox6.text).append(", ")
            }

            val pizzasizeDetail = sharedPrefs.edit()
            val pizzanameDetail = sharedPrefs.edit()
            val editor = sharedPrefs.edit()
            editor.putString("selected_toppings", selectedToppings.toString())
            pizzasizeDetail.putString("psize", pizzaSize.toString())
            pizzanameDetail.putString("pname", pizzaName.toString())
            editor.putString("selected_toppings", selectedToppings.toString())
            editor.apply()
            pizzanameDetail.apply()
            pizzasizeDetail.apply()

            // Pass the selected toppings as extra data
            startActivity(Intent(this, checkout::class.java))
        }


    }
}