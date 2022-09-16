package com.shawky.myshoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.shawky.myshoestore.databinding.FragmentLoginBinding
import com.shawky.myshoestore.databinding.FragmentOnBoardingBinding

class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        binding.nextButton.setOnClickListener{
                view: View ->
            Navigation.findNavController(view).navigate(R.id.action_onBoardingFragment_to_instructionsFragment)
        }
        return binding.root
    }

}