package com.example.kenyang.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kenyang.adapter.dataModel.Category
import com.example.kenyang.databinding.ItemRoundCategoryBinding

class CategoriesAdapter : ListAdapter<Category, CategoriesAdapter.CategoryViewHolder>(DIFF_CALLBACK) {

    class CategoryViewHolder(private val itemBinding: ItemRoundCategoryBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoryViewHolder {
        TODO("Not yet implemented")
    }


    override fun onBindViewHolder(holder: CategoriesAdapter.CategoryViewHolder, position: Int) {

    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Category>() {
            override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
                return oldItem == newItem
            }

        }
    }
}