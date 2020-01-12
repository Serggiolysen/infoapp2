package com.lysenko.infoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.lysenko.infoapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this@MainActivity, R.id.navHostMain).navigateUp()
    }

    // MARK: - Internal logic
    private fun setupNavigation() {
        val navController = Navigation.findNavController(this@MainActivity, R.id.navHostMain)
        bottomNavigation.setupWithNavController(navController)
    }
}
