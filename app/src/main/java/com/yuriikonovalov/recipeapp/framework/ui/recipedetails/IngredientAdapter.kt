package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.databinding.ItemIngredientAdapterBinding
import com.yuriikonovalov.recipeapp.presentation.model.IngredientUi

/**
 * A custom implementation of [ListAdapter] for displaying a list of ingredients.
 */
class IngredientAdapter :
    ListAdapter<IngredientUi, IngredientAdapter.IngredientViewHolder>(diffCallback) {

    /**
     * Keeps a type of [MeasureSystem] that is used for displaying.
     *
     * The list will be redrawn when it changes.
     */
    var measureSystem: MeasureSystem = MeasureSystem.Metric
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            if (value != field) {
                field = value
                notifyDataSetChanged()
            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, measureSystem)
    }

    class IngredientViewHolder private constructor(
        private val binding: ItemIngredientAdapterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: IngredientUi, measureSystem: MeasureSystem) {
            binding.image.load(item.image) {
                error(R.drawable.ic_image_not_supported)
                crossfade(100)
                networkCachePolicy(CachePolicy.ENABLED)
            }
            binding.name.text = item.name
            binding.measure.text = when (measureSystem) {
                is MeasureSystem.Metric -> item.measureMetric
                is MeasureSystem.Us -> item.measureUs
            }
        }

        companion object {
            fun from(parent: ViewGroup): IngredientViewHolder {
                val binding = ItemIngredientAdapterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return IngredientViewHolder(binding)
            }
        }
    }

}

private val diffCallback = object : DiffUtil.ItemCallback<IngredientUi>() {
    override fun areItemsTheSame(oldItem: IngredientUi, newItem: IngredientUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: IngredientUi, newItem: IngredientUi): Boolean {
        return oldItem == newItem
    }
}