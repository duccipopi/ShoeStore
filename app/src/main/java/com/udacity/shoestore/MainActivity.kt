package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.screens.list.ShoeListViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ShoeListViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Setup toolbar
        setSupportActionBar(binding.toolbar)

        // Setup top-level destinations
        val navController = findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        appBarConfiguration.topLevelDestinations.addAll(setOf(
            R.id.welcomeFragment,
            R.id.instructionFragment,
            R.id.shoeListFragment
        ))

        // Bind NavigationController to Navigation Host
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        // Activity-level View Model for ShoeList
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)


    }

    // Bind "up" button to Navigation Host
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(findNavController(R.id.navHostFragment), appBarConfiguration)
    }
}
