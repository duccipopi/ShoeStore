package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.core.text.isDigitsOnly
import androidx.databinding.InverseMethod
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                val images: List<String> = mutableListOf()) : Parcelable {
        fun doubledSize(s: String): Double {
            size = s.toDoubleOrNull() ?: 0.0
            return size
        }

        @InverseMethod(value = "doubledSize")
        public final fun stringedSize(d: Double): String {
            return size.toString()
        }
}