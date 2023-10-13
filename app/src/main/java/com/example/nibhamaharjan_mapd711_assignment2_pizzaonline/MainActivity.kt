// Name: Nibha Maharjan
// Student ID: 301282952
// Date Completed: 13th Oct 2023
// App Desc: Pizza app for Second Assignment
// Pizza screen => Size - Intent used
// Size => Topping - Intent used
// Topping => Checkout - SharedPref used
// Final page - Both intent and shared used

package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Splash Screen Init and Time shown
        Thread.sleep(1000)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        //Action bar title changed to Cent Pizza
        supportActionBar?.title = "Cent Pizza"


    }

    //Menu Inflate
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }
    //Menu item Click Action and Toast
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent: Intent = when (item.itemId) {
            R.id.nav_home -> {
                Toast.makeText(this, "Welcome to Cent Pizza", Toast.LENGTH_SHORT).show()
                Intent(this, MainActivity::class.java)
            }
            R.id.nav_meat -> {
                Toast.makeText(this, "Order a Meat Supreme Pizza", Toast.LENGTH_SHORT).show()
                Intent(this, meatsupreme::class.java)
            }
            R.id.nav_hawaii -> {
                Toast.makeText(this, "Order a Super Hawaiian Pizza", Toast.LENGTH_SHORT).show()
                Intent(this, superhawaiian::class.java)
            }
            R.id.nav_veggie -> {
                Toast.makeText(this, "Order a Veggie Pizza", Toast.LENGTH_SHORT).show()
                Intent(this, veggie::class.java)
            }
            R.id.nav_meddi -> {
                Toast.makeText(this, "Order a Mediterranean Pizza", Toast.LENGTH_SHORT).show()
                Intent(this, mediterranean::class.java)
            }
            R.id.nav_cheddar -> {
                Toast.makeText(this, "Order a Cheddar Supreme Pizza", Toast.LENGTH_SHORT).show()
                Intent(this, cheddarsupreme::class.java)
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        startActivity(intent)
        return true
    }

}