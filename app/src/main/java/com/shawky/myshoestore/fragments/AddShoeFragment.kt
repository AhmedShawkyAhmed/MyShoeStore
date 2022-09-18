package com.shawky.myshoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.shawky.myshoestore.MainActivity
import com.shawky.myshoestore.R
import com.shawky.myshoestore.viewModel.SharedViewModel
import com.shawky.myshoestore.databinding.FragmentAddShoeBinding
import com.shawky.myshoestore.model.Shoe

class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
    private val viewModel: SharedViewModel by activityViewModels()
    private val newShoe: Shoe = Shoe("","", "","")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddShoeBinding.inflate(layoutInflater)

        binding.addShoe = newShoe
        binding.setLifecycleOwner {viewLifecycleOwner.lifecycle}



        binding.cancelButton.setOnClickListener{ view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }
        binding.saveButton.setOnClickListener{ view: View ->
            //(activity as MainActivity?)!!.addNewItem()
            binding.apply {
                viewModel.addShoe(newShoe)
            }
            Navigation.findNavController(view)
                .navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }
        return binding.root
    }

}