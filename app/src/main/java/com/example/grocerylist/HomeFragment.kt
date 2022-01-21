package com.example.grocerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.grocerylist.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val rootView = binding.root
        // Inflate the layout for this fragment
        binding.startListButton.setOnClickListener {
            val name = binding.enterNameEditText.text.toString()

            val action = HomeFragmentDirections.actionHomeFragmentToGroceryListFragment(name)
            rootView.findNavController().navigate(action) //navigates to groceryListFragment

        }
        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}