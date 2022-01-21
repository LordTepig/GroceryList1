package com.example.grocerylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.grocerylist.databinding.FragmentGroceryListBinding

class GroceryListFragment : Fragment() {

    private var _binding: FragmentGroceryListBinding? = null
    private val binding get() = _binding!!
    private var currentGroceryIndex:Int = 0
    private var groceryList: MutableList<String> = mutableListOf("", "", "", "", "")
    private lateinit var textList: List<TextView>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGroceryListBinding.inflate(inflater, container, false)
        val rootView = binding.root
        val args = GroceryListFragmentArgs.fromBundle(requireArguments())
        binding.startingWelcomeMessageTextView.text = "Welcome, ${args.nameArg}!"

        setFragmentResultListener("requestKey"){ requestKey, bundle ->
            val result = bundle.getString("bundleKey")
            if (currentGroceryIndex < 5){
                groceryList.set(currentGroceryIndex, result.toString())
                currentGroceryIndex++
                }

            for((index, eachView) in textList.withIndex()){
                eachView.text = groceryList[index]
                }

            }
        // Inflate the layout for this fragment
        binding.addItemButton.setOnClickListener{
            val action = GroceryListFragmentDirections.actionGroceryListFragmentToChooseItemFragment()
            rootView.findNavController().navigate(action) //navigates to choose item fragment
        }
        return rootView
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}