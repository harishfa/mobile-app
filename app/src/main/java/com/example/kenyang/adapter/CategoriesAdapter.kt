package com.example.kenyang.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kenyang.data.dataclass.Category
import com.example.kenyang.databinding.ItemRoundCategoryBinding

class CategoriesAdapter : ListAdapter<Category, CategoriesAdapter.CategoryViewHolder>(DIFF_CALLBACK) {

    class CategoryViewHolder(private val itemBinding: ItemRoundCategoryBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(category: Category) {
            itemBinding.tvCategoryName.text = category.name
            itemBinding.ivImage.setImageResource(category.image)
        }

        // set on click listener to category page with switch
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.CategoryViewHolder {
        val binding = ItemRoundCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CategoriesAdapter.CategoryViewHolder, position: Int) {
        val category = getItem(position)
        holder.bind(category)
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