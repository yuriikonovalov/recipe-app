package com.yuriikonovalov.recipeapp.framework.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.databinding.FragmentHomeBinding
import com.yuriikonovalov.recipeapp.presentation.home.HomeEvent
import com.yuriikonovalov.recipeapp.presentation.home.HomeState
import com.yuriikonovalov.recipeapp.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var widthWindowSizeClass: WindowSizeClass
    private val recipeAdapter by lazy { RandomRecipeAdapter(viewModel::onRecipeClick) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        computeWindowSizeClass()
        with(binding) {
            bindWidthWindowSizeClassComputing()
            applyWindowInsets()
            bindToolbar()
            bindSearchButton()
            bindRetryButton()
            bindRecipeList()
            bindRecipeListTitle()
            bindLoadingPlaceholder()
            bindEmptyPlaceholder()
        }

        collectEvent(viewModel.eventFlow, viewModel.eventConsumer) { event ->
            when (event) {
                is HomeEvent.GoToSearchFragment -> {
                    findNavController().navigate(HomeFragmentDirections.toSearchFragment())
                }
                is HomeEvent.OpenRecipeDetails -> {
                    findNavController().navigate(
                        HomeFragmentDirections.toRecipeDetailsFragment(event.id)
                    )
                }
            }
        }
    }

    private fun FragmentHomeBinding.bindEmptyPlaceholder() {
        content.emptyPlaceholder.setText(R.string.loading_error_message)
        collectDistinctStateProperty(viewModel.stateFlow, HomeState::emptyPlaceholderVisible) {
            content.emptyPlaceholder.isVisible = it
        }
    }

    private fun FragmentHomeBinding.bindRetryButton() {
        content.retryButton.setOnClickListener { viewModel.refreshRecipes() }
        collectDistinctStateProperty(viewModel.stateFlow, HomeState::emptyPlaceholderVisible) {
            content.retryButton.isVisible = it
        }
    }

    private fun FragmentHomeBinding.bindRecipeListTitle() {
        collectDistinctStateProperty(viewModel.stateFlow, HomeState::empty) {
            content.listTitle.isVisible = it.not()
        }
    }

    private fun FragmentHomeBinding.bindLoadingPlaceholder() {
        content.loadingPlaceholder.message.setText(R.string.loading_random_recipes)
        collectDistinctStateProperty(viewModel.stateFlow, HomeState::loadingPlaceholderVisible) {
            content.loadingPlaceholder.root.isVisible = it
        }
    }

    private fun FragmentHomeBinding.bindToolbar() {
        toolbar?.let {
            val drawer = requireActivity().findViewById<DrawerLayout>(R.id.drawer_layout)
            it.setupWithNavController(findNavController(), drawer)
        }
    }

    private fun FragmentHomeBinding.bindSearchButton() {
        content.searchButton.setOnClickListener { viewModel.onSearchButtonClick() }
    }

    private fun FragmentHomeBinding.bindRecipeList() {
        content.randomRecipeList.layoutManager = getLayoutManager()
        content.randomRecipeList.adapter = recipeAdapter
        collectDistinctStateProperty(
            viewModel.stateFlow,
            HomeState::recipes,
            recipeAdapter::submitList
        )
    }

    private fun FragmentHomeBinding.bindWidthWindowSizeClassComputing() {
        root.addView(object : View(requireContext()) {
            override fun onConfigurationChanged(newConfig: Configuration?) {
                super.onConfigurationChanged(newConfig)
                computeWindowSizeClass()
            }
        })
    }

    private fun computeWindowSizeClass() {
        widthWindowSizeClass = requireActivity().computeWidthWindowSizeClass()
    }

    private fun getLayoutManager(): RecyclerView.LayoutManager {
        return when (widthWindowSizeClass) {
            WindowSizeClass.COMPACT -> LinearLayoutManager(requireContext())
            else -> GridLayoutManager(requireContext(), 2)
        }
    }

    private fun FragmentHomeBinding.applyWindowInsets() {
        toolbar?.doOnApplyWindowInsetsCompat { toolbar, windowInsetsCompat, initialPadding ->
            toolbar.updatePadding(
                top = initialPadding.top + windowInsetsCompat.statusBar.top
            )
        }
        content.root.doOnApplyWindowInsetsCompat { root, windowInsetsCompat, initialPadding ->
            root.updatePadding(
                right = initialPadding.right + windowInsetsCompat.systemBars.right,
                top = windowSizeRelativePadding(
                    initialPadding.top,
                    windowInsetsCompat.statusBar.top
                )
            )
        }
        content.randomRecipeList.doOnApplyWindowInsetsCompat { list, windowInsetsCompat, initialPadding ->
            list.updatePadding(bottom = initialPadding.bottom + windowInsetsCompat.navigationBars.bottom)
        }
    }

    private fun windowSizeRelativePadding(initialPadding: Int, top: Int): Int {
        // For WindowSizeClass.COMPACT screens a toolbar takes care of the status bar insets.
        // For larger screens there's no toolbar, so we should apply status bar insets in these case.
        return if (widthWindowSizeClass == WindowSizeClass.COMPACT) {
            initialPadding
        } else {
            initialPadding + top
        }
    }
}