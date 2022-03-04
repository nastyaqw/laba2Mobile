package com.hrithik.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hrithik.recyclerviewkotlin.databinding.FoodItemLayoutBinding

class FoodItemAdapter(private val OnClick:(FoodItem)->Unit) : RecyclerView.Adapter<FoodItemAdapter.FoodItemViewHolder>() {

    private val foodItemsList: MutableList<FoodItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodItemViewHolder {
        val binding =
            FoodItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodItemViewHolder(binding,OnClick)

    }

    override fun onBindViewHolder(holder: FoodItemViewHolder, position: Int) {
        val foodItem = foodItemsList[position]
        holder.bind(foodItem)
    }

    override fun getItemCount(): Int {
        return foodItemsList.size
    }

    fun addFood(foodItem: FoodItem) {
        foodItemsList.add(foodItem)
        notifyItemInserted(foodItemsList.lastIndex)
    }


    class FoodItemViewHolder(
        private val binding: FoodItemLayoutBinding,
        private val  OnClick: (FoodItem) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(foodItem: FoodItem) {
            binding.foodItemNameTV.text = foodItem.name
            binding.foodItemPriceTV.text = "Rs. ${foodItem.price}"
            binding.root.setOnClickListener{OnClick(foodItem)}
        }

    }
}