package com.shawky.myshoestore.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.shawky.myshoestore.R
import com.shawky.myshoestore.viewModel.SharedViewModel
import com.shawky.myshoestore.databinding.FragmentShoeListBinding
import com.shawky.myshoestore.databinding.ListItemBinding

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.setContentView(requireActivity(), R.layout.activity_main)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->

            for (shoe in shoeList) {

                val shoeItem = ListItemBinding.inflate(layoutInflater)

                shoeItem.shoe = shoe
                binding.linearLayout.addView(shoeItem.root)
            }
        })
        binding.addShoeButton.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeListFragment_to_addShoeFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolBar)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_logout -> {
                findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
                Toast.makeText(requireActivity(),"Logout",Toast.LENGTH_LONG).show()
                return true
            }
        }
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}