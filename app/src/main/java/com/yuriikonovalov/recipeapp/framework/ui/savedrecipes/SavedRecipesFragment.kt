package com.yuriikonovalov.recipeapp.framework.ui.savedrecipes

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.yuriikonovalov.recipeapp.R

import com.yuriikonovalov.recipeapp.databinding.FragmentSavedRecipesBinding
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.SavedRecipesEvent
import com.yuriikonovalov.recipeapp.presentation.savedrecipes.SavedRecipesState
import com.yuriikonovalov.recipeapp.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedRecipesFragment : Fragment() {
    private lateinit var binding: FragmentSavedRecipesBinding
    private val viewModel: SavedRecipesViewModel by hiltNavGraphViewModels(R.id.savedRecipesNavGraph)
    private val recipeAdapter = RecipeAdapter()
    private lateinit var widthWindowSizeClass: WindowSizeClass

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSavedRecipesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupOnBackPressedDispatcher()
        computeWindowSizeClass()
        with(binding) {
            bindWindowSizeComputing()
            applyWindowInsets()
            bindToolbar()
            bindRecipeList()
            bindEmptyView()
            bindSlidingPaneLayout()
        }
        collectEventFlow()
    }

    private fun collectEventFlow() {
        collectEvent(viewModel.eventFlow, viewModel.eventConsumer) { event ->
            when (event) {
                is SavedRecipesEvent.OpenDetailsPane -> binding.slidingPaneLayout.openPane()
                is SavedRecipesEvent.CloseDetailsPane -> binding.slidingPaneLayout.closePane()
                is SavedRecipesEvent.NavigateUp -> findNavController().navigateUp()
            }
        }
    }

    private fun FragmentSavedRecipesBinding.bindToolbar() {
        toolbar.setNavigationOnClickListener {
            viewModel.onClickNavigateUpButton()
        }
    }


    private fun FragmentSavedRecipesBinding.bindRecipeList() {
        recipeAdapter.setOnRecipeClick(viewModel::onSelectRecipe)
        recipes.layoutManager = getLinearLayoutManager()
        recipes.adapter = recipeAdapter

        collectDistinctStateProperty(viewModel.stateFlow, SavedRecipesState::recipes) {
            recipeAdapter.submitList(it)
        }
        collectDistinctStateProperty(
            viewModel.stateFlow, SavedRecipesState::selectedRecipeCard
        ) { id ->
            // Draw a recipe card selected only when a recipe list and
            // a recipe details fragment are both visible.
            id?.let { recipeAdapter.selectCard(it) }
        }
    }

    private fun getLinearLayoutManager(): LinearLayoutManager {
        return when (widthWindowSizeClass) {
            WindowSizeClass.COMPACT -> LinearLayoutManager(requireContext())
            WindowSizeClass.MEDIUM -> GridLayoutManager(requireContext(), 2)
            WindowSizeClass.EXPANDED -> LinearLayoutManager(requireContext())
        }
    }

    private fun FragmentSavedRecipesBinding.bindEmptyView() {
        // Placeholder text.
        emptyPlaceholder.setText(R.string.message_empty_saved_recipes)
        collectDistinctStateProperty(viewModel.stateFlow, SavedRecipesState::emptyList) { empty ->
            emptyPlaceholder.isVisible = empty
        }
    }

    private fun FragmentSavedRecipesBinding.bindSlidingPaneLayout() {
        // Don't let to open/close a details container by slide gestures.
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        slidingPaneLayout.addPanelSlideListener(object :
            SlidingPaneLayout.PanelSlideListener {
            override fun onPanelSlide(panel: View, slideOffset: Float) {
                /* no-op */
            }

            override fun onPanelOpened(panel: View) {
                viewModel.onUpdatePaneState(open = true)
            }

            override fun onPanelClosed(panel: View) {
                viewModel.onUpdatePaneState(open = false)
            }
        })
    }


    private fun FragmentSavedRecipesBinding.applyWindowInsets() {
        toolbar.doOnApplyWindowInsetsCompat { toolbar, windowInsetsCompat, initialPadding ->
            toolbar.updatePadding(top = initialPadding.top + windowInsetsCompat.statusBar.top)
        }

        recipes.doOnApplyWindowInsetsCompat { list, windowInsetsCompat, initialPadding ->
            list.updatePadding(bottom = initialPadding.bottom + windowInsetsCompat.systemBars.bottom)
        }
        root.doOnApplyWindowInsetsCompat { content, windowInsetsCompat, initialPadding ->
            content.updatePadding(
                right = initialPadding.right + windowInsetsCompat.systemBars.right
            )
        }
    }

    private fun FragmentSavedRecipesBinding.bindWindowSizeComputing() {
        root.addView(object : View(requireContext()) {
            override fun onConfigurationChanged(newConfig: Configuration?) {
                super.onConfigurationChanged(newConfig)
                computeWindowSizeClass()
            }
        })
    }

    private fun setupOnBackPressedDispatcher() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            viewModel.onClickBackButton()
        }
    }

    private fun computeWindowSizeClass() {
        widthWindowSizeClass = requireActivity().computeWidthWindowSizeClass()
        // Update window size class
        viewModel.onUpdateWindowSizeClass(widthWindowSizeClass)
    }
}

