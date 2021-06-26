package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.screens.list.ShoeListViewModel

/**
 * Fragment for Shoe Detail screen
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoeDetailFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)

        // View Model binding
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.viewModel = viewModel

        // Navigation setup and add new Shoe
        binding.detailSaveButton.setOnClickListener {
            val shoeLisViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
            shoeLisViewModel.addShoe(viewModel.shoe.value!!)
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        // Navigation setup for Cancel button
        binding.detailCancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }

}