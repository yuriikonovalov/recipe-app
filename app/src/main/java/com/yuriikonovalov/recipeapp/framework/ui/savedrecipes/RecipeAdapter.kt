package com.yuriikonovalov.recipeapp.framework.ui.savedrecipes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yuriikonovalov.recipeapp.databinding.ItemRecipeAdapterBinding
import com.yuriikonovalov.recipeapp.presentation.model.RecipeUi

/**
 * A custom implementation of [ListAdapter] for displaying a list of recipes.
 *
 * @property onRecipeClick a function that will be called when an item of the list is clicked.
 */
class RecipeAdapter : ListAdapter<RecipeUi, RecipeAdapter.RecipeViewHolder>(diffCallback) {
    private lateinit var onRecipeClick: ((recipe: RecipeUi) -> Unit)
    fun setOnRecipeClick(onRecipeClick: (recipe: RecipeUi) -> Unit) {
        this.onRecipeClick = onRecipeClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent, onRecipeClick)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, selectedId)
    }

    private var selectedId = -1

    @SuppressLint("NotifyDataSetChanged")
    fun selectCard(id: Int) {
        selectedId = id
        notifyDataSetChanged()
    }

    class RecipeViewHolder private constructor(
        private val binding: ItemRecipeAdapterBinding,
        private val onRecipeClick: ((recipe: RecipeUi) -> Unit),
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RecipeUi, selectedId: Int) {
            binding.image.load(item.image) { crossfade(100) }
            binding.title.text = item.title
            binding.mealTypes.text = item.mealTypes
            binding.time.text = item.time
            binding.servings.text = item.servings
            binding.root.isChecked = item.id == selectedId
            binding.root.setOnClickListener { onRecipeClick(item) }
        }

        companion object {
            fun from(
                parent: ViewGroup, onRecipeClick: ((recipe: RecipeUi) -> Unit)
            ): RecipeViewHolder {
                val binding = ItemRecipeAdapterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return RecipeViewHolder(binding, onRecipeClick)
            }
        }
    }
}

private val diffCallback = object : DiffUtil.ItemCallback<RecipeUi>() {
    override fun areItemsTheSame(oldItem: RecipeUi, newItem: RecipeUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecipeUi, newItem: RecipeUi): Boolean {
        return oldItem == newItem
    }
}