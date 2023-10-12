package com.example.nibhamaharjan_mapd711_assignment2_pizzaonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                setContentView(R.layout.activity_main)
                Toast.makeText(this@MainActivity, "Welcome to Cent Pizza", Toast.LENGTH_LONG).show()
            }
            R.id.nav_meat -> {
                setContentView(R.layout.activity_meatsupreme)
                Toast.makeText(this@MainActivity, "Order a Meat Supreme Pizza", Toast.LENGTH_LONG).show()
            }

            R.id.nav_hawaii -> {
                setContentView(R.layout.activity_superhawaiian)
                Toast.makeText(this, "Order a Super Hawaiian Pizza", Toast.LENGTH_LONG).show()
            }

            R.id.nav_veggie -> {
                setContentView(R.layout.activity_veggie)
                Toast.makeText(this, "Order a Veggie Pizza", Toast.LENGTH_LONG).show()
            }

            R.id.nav_meddi -> {
                setContentView(R.layout.activity_mediterranean)
                Toast.makeText(this, "Order a Mediterranean Pizza", Toast.LENGTH_LONG).show()
            }

            R.id.nav_cheddar -> {
                setContentView(R.layout.activity_cheddarsupreme)
                Toast.makeText(this, "Order a Cheddar Supreme Pizza", Toast.LENGTH_LONG).show()
            }
        }
        return true
    }
}