package com.example.kenyang.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kenyang.R
import com.example.kenyang.adapter.CategoriesAdapter
import com.example.kenyang.data.Category
import com.example.kenyang.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment() {

    private lateinit var binding: FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = CategoriesAdapter()
        val list: List<Category> = makeCategoryList()
        adapter.submitList(list)

        binding.rvCategory.adapter = adapter
        binding.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun makeCategoryList(): List<Category> {
        val list = mutableListOf<Category>()

        val categoryNames = resources.getStringArray(R.array.category_names)
        val images = resources.obtainTypedArray(R.array.category_image)

        for (i in categoryNames.indices) {
            val category = Category(categoryNames[i], images.getResourceId(i, -1))
            list.add(category)
        }

        return list
    }


}