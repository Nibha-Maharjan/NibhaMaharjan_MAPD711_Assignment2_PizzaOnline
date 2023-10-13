package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FinalActivity : AppCompatActivity() {

    //Defining Variables
    private lateinit var sharedPrefs: SharedPreferences
    private lateinit var usrName : TextView
    private lateinit var usrType : TextView
    private lateinit var usrSize : TextView
    private lateinit var usrTopp : TextView
    private lateinit var usrAdd : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)
        title = "Thank you for ordering"
        //Init SharedPrefs
        sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        usrName=findViewById(R.id.textView16)
        usrType=findViewById(R.id.textView17)
        usrSize=findViewById(R.id.textView18)
        usrTopp=findViewById(R.id.textView19)
        usrAdd=findViewById(R.id.textView20)

        //Assigning Intents and SharedPrefs both
        val userName = intent.getStringExtra("CusName")
        val userPizz = sharedPrefs.getString("pname","")
        val userSize = sharedPrefs.getString("psize","")
        val userTopp = sharedPrefs.getString("selected_toppings", "")
        val useradd = intent.getStringExtra("CusAdd")

        //Updating Values
        usrName.text = "Customer Name : "+userName
        usrType.text = "Type of Pizza : "+userPizz
        usrSize.text = "Size of Pizza : "+userSize
        usrTopp.text = "Toppings : "+userTopp
        usrAdd.text = "Customer Address : "+useradd


    }
}
