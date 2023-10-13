package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.regex.Pattern

class checkout : AppCompatActivity() {
    //Delaring Variables
    private lateinit var text1 : TextView
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var editName : EditText
    private lateinit var editAddress : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)


        title = "Checkout"
        //Initializing sharedPres and Assigning Values
        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        text1 = findViewById(R.id.textView5)
        editName = findViewById(R.id.editTextText)
        editAddress = findViewById(R.id.editTextText2)
        val toppingsAdded = findViewById<TextView>(R.id.textView4)

        //Getting Data from sharedPrefs
        val selectedToppings = sharedPrefs.getString("selected_toppings", "")
        val selectedpname = sharedPrefs.getString("pname","")
        val selectedpsize = sharedPrefs.getString("psize","")
        //Updating Values in UI
        text1.text="$selectedpname Pizza of size $selectedpsize"
        // Use the retrieved data as needed
        val message = "Selected Toppings: $selectedToppings"
        toppingsAdded.text = message


        val spinner: Spinner = findViewById(R.id.spinner)
        // Create arrayadapter using the string array and a default android spinner layout.
        ArrayAdapter.createFromResource(
            this,
            R.array.ctype,
            android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner.
                spinner.adapter = adapter
            }

        //Validation start
        val cardValidation = findViewById<EditText>(R.id.editTextNumber2)
        val pinValidation = findViewById<EditText>(R.id.editTextNumber3)
        val phoneValidation = findViewById<EditText>(R.id.editTextPhone)
        val buttonCheckout = findViewById<Button>(R.id.button5)

        // Find the EditText for expiry date
        val expiryDate = findViewById<EditText>(R.id.editTextDate2)

        // Set a click listener on the EditText to show DatePickerDialog
        expiryDate.setOnClickListener {
            showDate()
        }


        buttonCheckout.setOnClickListener {
            val creditCardNumber = cardValidation.text.toString()
            val pin = pinValidation.text.toString()
            val phoneNumber = phoneValidation.text.toString()

            // Defining regex for validation
            val creditCardPattern = Pattern.compile("^\\d{16}$")
            val pinPattern = Pattern.compile("^\\d{4}$")
            val phonePattern = Pattern.compile("^\\d{10}$")



            //Card, Pin, and number validation condition
            if (!creditCardPattern.matcher(creditCardNumber).matches() ||
                !pinPattern.matcher(pin).matches() ||
                !phonePattern.matcher(phoneNumber).matches()
            ) {
                if (!creditCardPattern.matcher(creditCardNumber).matches()) {
                    cardValidation.error = "Invalid Credit Card Number"
                }
                if (!pinPattern.matcher(pin).matches()) {
                    pinValidation.error = "Invalid PIN"
                }
                if (!phonePattern.matcher(phoneNumber).matches()) {
                    phoneValidation.error = "Invalid Phone Number"
                }
            } else {
                startActivity(
                    //Starting intent to FinalActivity
                    Intent(this,FinalActivity::class.java)
                        //Using key value pairs to pass the data into the second activity
                        .putExtra("CusName",editName.text.toString())
                        .putExtra("CusAdd",editAddress.text.toString())
                        .putExtra("CussPizz",selectedpname.toString())
                        .putExtra("CussSize",selectedpsize.toString())
                        .putExtra("CussTop",selectedToppings.toString())
                )
            }
        }


    }
    //Date window popup
    private fun showDate() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)

                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(selectedDate.time)

                val expiryDate = findViewById<EditText>(R.id.editTextDate2)
                expiryDate.setText(formattedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
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
