package com.example.grocerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.example.grocerylist.databinding.FragmentChooseItemBinding

class ChooseItemFragment : Fragment() {

    private var _binding: FragmentChooseItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseItemBinding.inflate(inflater, container, false)
        val rootView = binding.root

        // Inflate the layout for this fragment
        val groceryButtons: List<View> = listOf(binding.peanutButterButton,binding.milkButton,binding.breadButton,binding.grapesButton,binding.strawberriesButton,binding.pastaButton,binding.meatballsButton,binding.orangeJuiceButton)
        var item = ""
        for (button in groceryButtons){
            button.setOnClickListener{view->
                when (view){
                    binding.peanutButterButton -> item = binding.peanutButterButton.text.toString()
                    binding.milkButton -> item = binding.milkButton.text.toString()
                    binding.breadButton -> item = binding.breadButton.text.toString()
                    binding.grapesButton -> item = binding.grapesButton.text.toString()
                    binding.strawberriesButton -> item = binding.strawberriesButton.text.toString()
                    binding.pastaButton -> item = binding.pastaButton.text.toString()
                    binding.meatballsButton -> item = binding.meatballsButton.text.toString()
                    binding.orangeJuiceButton -> item = binding.orangeJuiceButton.text.toString()
                }
                setFragmentResult("requestKey", bundleOf("bundleKey" to item))
                rootView.findNavController().navigateUp()
            }
        }

        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}