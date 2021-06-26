package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.screens.list.ShoeListViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ShoeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Activity-level View Model for ShoeList
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)


    }
}
