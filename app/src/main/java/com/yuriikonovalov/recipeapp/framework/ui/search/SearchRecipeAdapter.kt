package com.yuriikonovalov.recipeapp.framework.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.databinding.ItemSearchRecipeAdapterBinding

/**
 * A custom implementation of [PagingDataAdapter] for displaying a list of search results.
 *
 * @property onItemClick a function that will be called an item of the list clicked.
 */
class SearchRecipeAdapter(
    private val onItemClick: (id: Int) -> Unit
) : PagingDataAdapter<SearchRecipe, SearchRecipeAdapter.SearchRecipeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecipeViewHolder {
        return SearchRecipeViewHolder.from(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: SearchRecipeViewHolder, position: Int) {
        getItem(position).also {
            holder.bind(it)
        }
    }

    class SearchRecipeViewHolder private constructor(
        private val binding: ItemSearchRecipeAdapterBinding,
        private val onItemClick: (id: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchRecipe?) {
            binding.image.load(item?.image) {
                error(R.drawable.ic_image_not_supported)
                crossfade(100)
            }
            binding.title.text = item?.title
            item?.let { searchRecipe ->
                binding.root.setOnClickListener {
                    onItemClick(searchRecipe.id)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup, onItemClick: (id: Int) -> Unit): SearchRecipeViewHolder {
                val binding = ItemSearchRecipeAdapterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return SearchRecipeViewHolder(binding, onItemClick)
            }
        }
    }
}

private val diffCallback = object : DiffUtil.ItemCallback<SearchRecipe>() {
    override fun areItemsTheSame(oldItem: SearchRecipe, newItem: SearchRecipe): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SearchRecipe, newItem: SearchRecipe): Boolean {
        return oldItem == newItem
    }
}