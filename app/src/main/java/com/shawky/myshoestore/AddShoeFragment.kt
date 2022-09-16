package com.shawky.myshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.shawky.myshoestore.databinding.FragmentAddShoeBinding

class AddShoeFragment : Fragment() {

    private lateinit var binding: FragmentAddShoeBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddShoeBinding.inflate(layoutInflater)

        binding.cancelButton.setOnClickListener{
                findNavController().navigateUp()
        }
        binding.saveButton.setOnClickListener{
            (activity as MainActivity?)!!.addNewItem()
            findNavController().navigateUp()
        }
        binding.addShoe = viewModel.shoe
        return binding.root
    }

}