package com.shawky.myshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.shawky.myshoestore.databinding.FragmentInstructionsBinding
import com.shawky.myshoestore.databinding.FragmentOnBoardingBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInstructionsBinding.inflate(layoutInflater)
        binding.startButton.setOnClickListener{
                view: View ->
            Navigation.findNavController(view).navigate(R.id.action_instructionsFragment_to_shoeListFragment)
        }
        return binding.root
    }

}