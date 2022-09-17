package com.shawky.myshoestore.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.shawky.myshoestore.MainActivity
import com.shawky.myshoestore.R
import com.shawky.myshoestore.viewModel.SharedViewModel
import com.shawky.myshoestore.databinding.FragmentAddShoeBinding

class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddShoeBinding.inflate(layoutInflater)

        binding.cancelButton.setOnClickListener{ view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }
        binding.saveButton.setOnClickListener{ view: View ->
            (activity as MainActivity?)!!.addNewItem()
            Navigation.findNavController(view)
                .navigate(R.id.action_addShoeFragment_to_shoeListFragment)
        }



        binding.addShoe = viewModel
        return binding.root
    }

}