package com.yuriikonovalov.recipeapp.framework.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yuriikonovalov.recipeapp.databinding.ItemRandomRecipeAdapterBinding
import com.yuriikonovalov.recipeapp.presentation.model.RandomRecipeUi


/**
 * A custom implementation of [ListAdapter] for displaying a list of random recipes.
 *
 * @property onRecipeClick a function that will be called when an item of the list is clicked.
 */
class RandomRecipeAdapter(private val onRecipeClick: (id: Int) -> Unit) :
    ListAdapter<RandomRecipeUi, RandomRecipeAdapter.RecipeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent, onRecipeClick)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class RecipeViewHolder private constructor(
        private val binding: ItemRandomRecipeAdapterBinding,
        private val onRecipeClick: (id: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RandomRecipeUi) {
            binding.title.text = item.title
            binding.ingredients.text = item.ingredients
            binding.time.text = item.time
            binding.image.load(item.image) {
                crossfade(100)
            }
            binding.root.setOnClickListener {
                onRecipeClick(item.id)
            }
        }

        companion object {
            fun from(parent: ViewGroup, onRecipeClick: (id: Int) -> Unit): RecipeViewHolder {
                val binding = ItemRandomRecipeAdapterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return RecipeViewHolder(binding, onRecipeClick)
            }
        }
    }
}

private val diffCallback = object : DiffUtil.ItemCallback<RandomRecipeUi>() {
    override fun areItemsTheSame(oldItem: RandomRecipeUi, newItem: RandomRecipeUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RandomRecipeUi, newItem: RandomRecipeUi): Boolean {
        return oldItem == newItem
    }
}