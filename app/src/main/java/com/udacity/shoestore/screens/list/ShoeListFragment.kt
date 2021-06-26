package com.udacity.shoestore.screens.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding

/**
 * Fragment for Shoe List screen
 */
class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ShoeListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.detailsButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }

}