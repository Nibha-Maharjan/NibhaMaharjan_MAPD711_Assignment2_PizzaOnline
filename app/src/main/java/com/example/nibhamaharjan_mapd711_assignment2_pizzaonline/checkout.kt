package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
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


        val spinner: Spinner = findViewById(R.id.spinner)
// Create an ArrayAdapter using the string array and a default spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.ctype,
            android.R.layout.simple_spinner_item
            ).also { adapter ->
            // Specify the layout to use when the list of choices appears.
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
                spinner.adapter = adapter
            }



//
//        text1.text = "You have ordered a $pizzNam Pizza in $pizzSiz and your toppings are:"
//        toppingsAdded.text = selectedToppings?.joinToString(", ") ?: "No toppings selected"
    }
}
class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        // An item is selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos).
    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback.
    }
}
