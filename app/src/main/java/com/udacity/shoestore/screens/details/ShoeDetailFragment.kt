package com.udacity.shoestore.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe

/**
 * Fragment for Shoe Detail screen
 */
class ShoeDetailFragment : Fragment() {

    private var shoe = Shoe("", 0.0, "", "", emptyList());

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: ShoeDetailFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)

        binding.shoe = shoe

        binding.detailSaveButton.setOnClickListener {
            Toast.makeText(activity, binding.shoe.toString(), Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.detailCancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }

}