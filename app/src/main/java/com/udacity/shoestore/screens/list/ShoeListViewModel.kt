package com.udacity.shoestore.screens.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    // List of Shoes, readable-only by binding
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList


    // Create dummy values for test
    init {
        val fakeList = ArrayList<Shoe>()

        fakeList.add(Shoe("Choquis", 32.0, "Naique", "Topeson Pisante", emptyList()))
        fakeList.add(Shoe("Tradicional", 31.0, "Havaianas", "Uso geral", emptyList()))
        fakeList.add(Shoe("Basic", 33.2, "Kichute", "Esportivo de primeira", emptyList()))

        _shoeList.value = fakeList


    }

    // Add a new shoe
    fun addShoe(shoe: Shoe) {
        (_shoeList.value as ArrayList<Shoe>).add(shoe)
    }
}