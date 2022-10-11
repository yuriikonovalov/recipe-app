package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.databinding.FragmentRecipeDetailsBinding
import com.yuriikonovalov.recipeapp.framework.ui.asSavedIconRes
import com.yuriikonovalov.recipeapp.framework.ui.asSavedStringRes
import com.yuriikonovalov.recipeapp.presentation.model.*
import com.yuriikonovalov.recipeapp.presentation.recipedetails.*
import com.yuriikonovalov.recipeapp.util.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailsBinding
    private val args: RecipeDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: RecipeDetailsViewModel.Factory
    private val viewModel: RecipeDetailsViewModel by viewModels {
        RecipeDetailsViewModel.provideFactory(viewModelFactory, args.recipeId)
    }

    private val ingredientAdapter = IngredientAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            applyWindowInsets()
            bindToolbar()
            bindContentView()
            bindLoadingView()
            bindErrorView()
        }

        collectEvent(viewModel.eventFlow, viewModel.eventConsumer) { event ->
            when (event) {
                is RecipeDetailsEvent.OpenSourcePage -> {
                    findNavController().navigate(
                        RecipeDetailsFragmentDirections.toSourcePageDialog(event.sourceUrl)
                    )
                }
            }
        }
    }

    private fun FragmentRecipeDetailsBinding.bindLoadingView() {
        collectDistinctStateProperty(viewModel.stateFlow, RecipeDetailsState::loading) { loading ->
            loadingView.root.isVisible = loading
        }
    }

    private fun FragmentRecipeDetailsBinding.bindErrorView() {
        errorView.retryButton.setOnClickListener { viewModel.onRetryButtonClick(args.recipeId) }
        collectDistinctStateProperty(viewModel.stateFlow, RecipeDetailsState::error) { error ->
            errorView.root.isVisible = error
        }
    }

    private fun FragmentRecipeDetailsBinding.bindContentView() {
        bindButtons()
        bindMeasureSystemSpinner()
        bindIngredientList()

        collectDistinctStateProperty(viewModel.stateFlow, RecipeDetailsState::contentVisible) {
            content.root.isVisible = it
        }
        collectDistinctStateProperty(viewModel.stateFlow, RecipeDetailsState::recipe) { recipe ->
            recipe?.let { recipeUi ->
                content.title.text = recipeUi.title
                content.image.load(recipeUi.image) {
                    crossfade(100)
                    error(R.drawable.placeholder_meal)
                    placeholder(R.drawable.placeholder_meal)
                }
                content.vegetarian.isVisible = recipeUi.vegetarian
                content.vegetarianIcon.isVisible = recipeUi.vegetarian

                content.instructionsLabel.isVisible = recipeUi.instructionsVisible
                content.instructions.isVisible = recipeUi.instructionsVisible
                content.instructions.text = recipeUi.instructions

                content.time.isVisible = recipeUi.timeVisible
                content.timeIcon.isVisible = recipeUi.timeVisible
                content.time.text = recipeUi.time

                content.servings.isVisible = recipeUi.servingsVisible
                content.servingsIcon.isVisible = recipeUi.servingsVisible
                content.servings.text = recipeUi.servings

                content.mealTypes.isVisible = recipeUi.mealTypeVisible
                content.mealTypesIcon.isVisible = recipeUi.mealTypeVisible
                content.mealTypes.text = recipeUi.mealTypes

                binding.content.ingredients.isVisible = recipeUi.ingredientsVisible
                binding.content.ingredientsLabel.isVisible = recipeUi.ingredientsVisible
                ingredientAdapter.submitList(recipeUi.ingredients)

                content.measureSystemSpinner.isVisible = recipeUi.measureSpinnerVisible
                content.sourceButton.isVisible = recipeUi.sourceButtonVisible

                content.saveButton.setIconResource(recipeUi.saved.asSavedIconRes())
                content.saveButton.setText(recipeUi.saved.asSavedStringRes())
            }
        }
    }


    private fun FragmentRecipeDetailsBinding.bindMeasureSystemSpinner() {
        content.measureSystemSpinner.onItemSelectedListener =
            object : OnItemSelectedListener {
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

    private fun FragmentRecipeDetailsBinding.bindButtons() {
        // Save button
        content.saveButton.setOnClickListener {
            viewModel.onSaveButtonClick()
        }
        // Source page button
        content.sourceButton.setOnClickListener {
            viewModel.onSourceButtonClick()
        }
    }


    private fun FragmentRecipeDetailsBinding.bindIngredientList() {
        content.ingredients.layoutManager = LinearLayoutManager(requireContext())
        content.ingredients.adapter = ingredientAdapter
        collectDistinctStateProperty(viewModel.stateFlow, RecipeDetailsState::measureSystem) {
            ingredientAdapter.measureSystem = it
        }
    }

    private fun FragmentRecipeDetailsBinding.bindToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun FragmentRecipeDetailsBinding.applyWindowInsets() {
        toolbar.doOnApplyWindowInsetsCompat { toolbar, windowInsetsCompat, initialPadding ->
            toolbar.updatePadding(top = initialPadding.top + windowInsetsCompat.statusBar.top)
        }
        content.root.doOnApplyWindowInsetsCompat { content, windowInsetsCompat, initialPadding ->
            content.updatePadding(
                right = initialPadding.right + windowInsetsCompat.systemBars.right,
                bottom = initialPadding.bottom + windowInsetsCompat.systemBars.bottom,
            )
        }
    }
}

