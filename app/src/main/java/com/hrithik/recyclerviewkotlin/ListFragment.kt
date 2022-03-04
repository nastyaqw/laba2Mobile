package com.hrithik.recyclerviewkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrithik.recyclerviewkotlin.databinding.ActivityMainBinding
import com.hrithik.recyclerviewkotlin.databinding.ListFragmentBinding


class ListFragment : Fragment() {
    private var adapter: FoodItemAdapter = FoodItemAdapter(
        OnClick = { foodItem: FoodItem ->
            val action =ListFragmentDirections.actionListFragmentToDetailFragment(foodItem.name)
            findNavController().navigate(action)
        }
    )
    private lateinit var b: ListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        b= ListFragmentBinding.inflate(inflater,container,false)
        setUpAdapter()
        b.button.setOnClickListener { createRegistration() }
        return b.root
    }

    fun createRegistration(){
        var editTextMy = b.editTextTextPersonName.text.toString()
        // println("Login in fun - $editTextMy")
        val price = (100 ).toFloat()
        val foodItem = FoodItem(name = editTextMy, price = price)
        adapter.addFood(foodItem)
    }

    private fun setUpAdapter() {
        b.foodItemsRV.adapter = adapter
        b.foodItemsRV.layoutManager = LinearLayoutManager(b.root.context)
    }


}