package com.udacity.shoestore.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe

/**
 * Fragment for Shoe List screen
 */
class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: ShoeListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        // View model bind
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        // Observing the Shoe list and filling the scrollview/linear layout, binding each array value
        // to a new inflated item layout
        viewModel.shoeList.observe(viewLifecycleOwner, { list ->
            list.forEach { shoe: Shoe ->
                val itemBinding: ShoeListItemBinding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.shoe_list_item,
                    binding.shoeListLayout,
                    true
                )
                itemBinding.shoe = shoe
            }
        })

        // Check if a new shoe was created from ShoeDetailFragment
        //val args = ShoeListFragmentArgs.fromBundle(requireArguments())
        //if (args.newShoe != null) viewModel.addShoe(args.newShoe!!)

        // Navigation setup for button
        binding.detailsButton.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        return binding.root
    }

}