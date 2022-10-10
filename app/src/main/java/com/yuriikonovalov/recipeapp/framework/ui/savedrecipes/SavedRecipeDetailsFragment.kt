package com.yuriikonovalov.recipeapp.framework.ui.savedrecipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.databinding.FragmentSavedRecipeDetailsBinding
import com.yuriikonovalov.recipeapp.framework.ui.asSavedIconRes
import com.yuriikonovalov.recipeapp.framework.ui.asSavedStringRes
import com.yuriikonovalov.recipeapp.framework.ui.recipedetails.IngredientAdapter
import com.yuriikonovalov.recipeapp.presentation.model.timeVisible
import com.yuriikonovalov.recipeapp.presentation.model.*
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.*
import com.yuriikonovalov.recipeapp.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedRecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentSavedRecipeDetailsBinding
    private val viewModel: SavedRecipesViewModel by hiltNavGraphViewModels(R.id.savedRecipesNavGraph)
    private val ingredientAdapter = IngredientAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSavedRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            applyWindowInsets()
            bindContentView()
        }
        collectEventFlow()
    }


    private fun collectEventFlow() {
        collectEvent(viewModel.detailsEventFlow, viewModel.detailsEventConsumer) { event ->
            when (event) {
                is SavedRecipeDetailsEvent.OpenSourcePage -> onOpenSourcePageEvent(event.url)
            }
        }
    }

    private fun onOpenSourcePageEvent(url: String) {
        findNavController().navigate(SavedRecipeDetailsFragmentDirections.toSourcePageDialog(url))
    }

    private fun FragmentSavedRecipeDetailsBinding.bindContentView() {
        bindButtons()
        bindIngredientList()
        bindMeasureSystemSpinner()
        collectDistinctStateProperty(
            viewModel.stateFlow,
            SavedRecipesState::selectedRecipe
        ) { recipe ->
            content.root.isGone = recipe == null
            recipe?.let { recipeUi ->
                content.title.text = recipeUi.title
                content.image.load(recipeUi.image) {
                    crossfade(100)
                    error(R.drawable.placeholder_meal)
                    placeholder(R.drawable.placeholder_meal)
                }
                content.vegetarian.isVisible = recipeUi.vegetarian
                content.vegetarianIcon.isVisible = recipeUi.vegetarian

                content.time.isVisible = recipeUi.timeVisible
                content.timeIcon.isVisible = recipeUi.timeVisible
                content.time.text = recipeUi.time

                content.servings.isVisible = recipeUi.servingsVisible
                content.servingsIcon.isVisible = recipeUi.servingsVisible
                content.servings.text = recipeUi.servings

                content.mealTypes.isVisible = recipeUi.mealTypeVisible
                content.mealTypesIcon.isVisible = recipeUi.mealTypeVisible
                content.mealTypes.text = recipeUi.mealTypes

                content.ingredients.isVisible = recipeUi.ingredientsVisible
                content.ingredientsLabel.isVisible = recipeUi.ingredientsVisible
                ingredientAdapter.submitList(recipeUi.ingredients)

                content.instructionsLabel.isVisible = recipeUi.instructionsVisible
                content.instructions.isVisible = recipeUi.instructionsVisible
                content.instructions.text = recipeUi.instructions

                content.sourceButton.isVisible = recipeUi.sourceButtonVisible
                content.measureSystemSpinner.isVisible = recipeUi.measureSpinnerVisible

                content.saveButton.apply {
                    setIconResource(true.asSavedIconRes())
                    setText(true.asSavedStringRes())
                }
            }
        }
    }

    private fun FragmentSavedRecipeDetailsBinding.bindMeasureSystemSpinner() {
        content.measureSystemSpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long,
                ) {
                    viewModel.onSelectMeasureSystem(position)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    /* no-op */
                }
            }
    }

    private fun FragmentSavedRecipeDetailsBinding.bindButtons() {
        // Save button
        content.saveButton.setOnClickListener {
            viewModel.onSaveButtonClick()
        }
        // Source page button
        content.sourceButton.setOnClickListener {
            viewModel.onSourceButtonClick()
        }
    }

    private fun FragmentSavedRecipeDetailsBinding.bindIngredientList() {
        content.ingredients.layoutManager = LinearLayoutManager(requireContext())
        content.ingredients.adapter = ingredientAdapter
        collectDistinctStateProperty(viewModel.stateFlow, SavedRecipesState::measureSystem) {
            ingredientAdapter.measureSystem = it
        }
    }

    private fun FragmentSavedRecipeDetailsBinding.applyWindowInsets() {
        root.doOnApplyWindowInsetsCompat { content, windowInsetsCompat, initialPadding ->
            content.updatePadding(
                bottom = initialPadding.bottom + windowInsetsCompat.systemBars.bottom,
            )
        }
    }
}