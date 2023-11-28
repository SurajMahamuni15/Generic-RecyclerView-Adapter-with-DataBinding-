package com.example.genericrecyclerviewadapter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.genericrecyclerviewadapter.model.FoodModelData
import com.example.genericrecyclerviewadapter.adapter.GenericDataBindingAdapter
import com.example.genericrecyclerviewadapter.databinding.ActivityMainBinding
import com.example.genericrecyclerviewadapter.databinding.ActivityMainBinding.inflate
import com.example.genericrecyclerviewadapter.databinding.GenericRvItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var _adapter: GenericDataBindingAdapter<FoodModelData, GenericRvItemBinding>? = null
    private val adapter get() = _adapter!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflate(layoutInflater)
        initializeAdapter()
        setContentView(binding.root)
        setDataToAdapter()
    }

    private fun setDataToAdapter() {
        adapter.setData(ArrayList<FoodModelData>().apply {
            addAll(
                arrayOf<FoodModelData>(
                    FoodModelData("Apple"),
                    FoodModelData("Banana"),
                    FoodModelData("Orange"),
                    FoodModelData("Grapes"),
                    FoodModelData("Strawberry"),
                    FoodModelData("Watermelon"),
                    FoodModelData("Pineapple"),
                    FoodModelData("Mango"),
                    FoodModelData("Kiwi"),
                    FoodModelData("Blueberry"),
                    FoodModelData("Raspberry"),
                    FoodModelData("Blackberry"),
                    FoodModelData("Avocado"),
                    FoodModelData("Tomato"),
                    FoodModelData("Cucumber"),
                    FoodModelData("Carrot"),
                    FoodModelData("Broccoli"),
                    FoodModelData("Spinach"),
                    FoodModelData("Lettuce"),
                    FoodModelData("Kale"),
                    FoodModelData("Potato"),
                    FoodModelData("Sweet Potato"),
                    FoodModelData("Onion"),
                    FoodModelData("Garlic"),
                    FoodModelData("Bell Pepper"),
                    FoodModelData("Eggplant"),
                    FoodModelData("Zucchini"),
                    FoodModelData("Cauliflower"),
                    FoodModelData("Brussels Sprouts"),
                    FoodModelData("Asparagus"),
                    FoodModelData("Chicken"),
                    FoodModelData("Beef"),
                    FoodModelData("Pork"),
                    FoodModelData("Fish"),
                    FoodModelData("Shrimp"),
                    FoodModelData("Salmon"),
                    FoodModelData("Tofu"),
                    FoodModelData("Quinoa"),
                    FoodModelData("Rice"),
                    FoodModelData("Pasta"),
                    FoodModelData("Bread"),
                    FoodModelData("Oats"),
                    FoodModelData("Milk"),
                    FoodModelData("Cheese"),
                    FoodModelData("Yogurt"),
                    FoodModelData("Eggs"),
                    FoodModelData("Butter"),
                    FoodModelData("Olive Oil"),
                    FoodModelData("Honey"),
                    FoodModelData("Nuts")
                )
            )
        })
    }

    private fun initializeAdapter() {
        _adapter = GenericDataBindingAdapter(
            inflater = GenericRvItemBinding::inflate,
            bindToView = { binding, data ->
                binding.foodData = data
            })
        binding.genericRv.adapter = adapter
    }
}