package com.udacity.shoestore.screens.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeDetailViewModel: ViewModel() {

    val shoe = MutableLiveData<Shoe>()

    init {
        shoe.value = Shoe("", 0.0, "", "", emptyList())
    }
}