package com.yuriikonovalov.recipeapp.framework.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.databinding.ItemSearchRecipeLoadStateAdapterBinding

/**
 * A custom implementation of [LoadStateAdapter].
 */
class SearchRecipeLoadStateAdapter(private val onRetry: () -> Unit) :
    LoadStateAdapter<SearchRecipeLoadStateAdapter.LoadStateViewHolder>() {

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder.from(parent, onRetry)
    }

    class LoadStateViewHolder private constructor(
        private val binding: ItemSearchRecipeLoadStateAdapterBinding,
        private val onRetry: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.tryAgainButton.setOnClickListener { onRetry() }
        }

        fun bind(loadState: LoadState) {
            binding.errorMessage.isVisible = loadState is LoadState.Error
            binding.errorMessage.setText(R.string.error_message)
            binding.tryAgainButton.isVisible = loadState is LoadState.Error
            binding.progressBar.isVisible = loadState is LoadState.Loading
        }

        companion object {
            fun from(parent: ViewGroup, onRetry: () -> Unit): LoadStateViewHolder {
                return LoadStateViewHolder(
                    ItemSearchRecipeLoadStateAdapterBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ),
                    onRetry
                )
            }
        }
    }
}