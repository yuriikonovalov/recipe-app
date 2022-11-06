package com.yuriikonovalov.recipeapp.framework.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.databinding.FragmentSearchBinding
import com.yuriikonovalov.recipeapp.presentation.search.SearchEvent
import com.yuriikonovalov.recipeapp.util.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()
    private val searchRecipeAdapter by lazy { SearchRecipeAdapter(viewModel::onSearchRecipeClick) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            applyWindowInsets()
            bindNavigationButton()
            bindSearchEditText()
            bindSearchRecipeList()
            bindErrorView()
            bindEmptyView()
            bindLoadingView()
        }

        collectEvent(viewModel.eventFlow, viewModel.eventConsumer) { event ->
            when (event) {
                is SearchEvent.OpenRecipeDetails -> {
                    findNavController().navigate(
                        SearchFragmentDirections.toRecipeDetailsFragment(event.id)
                    )
                }
                is SearchEvent.IncorrectQueryToast -> {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.incorrect_query_toast),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    private fun FragmentSearchBinding.bindSearchRecipeList() {
        searchRecipes.layoutManager = LinearLayoutManager(requireContext())
        searchRecipes.adapter = searchRecipeAdapter
            .withLoadStateFooter(SearchRecipeLoadStateAdapter(searchRecipeAdapter::retry))

        searchRecipeAdapter.submitPagingData(viewModel.pagingData)
        searchRecipeAdapter.doOnStateChanged(viewModel::updateCombinedLoadState)
        launchSafely {
            viewModel.stateFlow.map { it.searchRecipeListVisible }
                .distinctUntilChanged()
                .collect {
                    searchRecipes.isVisible = it
                }
        }
    }

    private fun SearchRecipeAdapter.doOnStateChanged(onCollect: (state: CombinedLoadStates, itemCount: Int) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            loadStateFlow.collect { loadState ->
                onCollect(loadState, itemCount)
            }
        }
    }

    private fun SearchRecipeAdapter.submitPagingData(pagingDataFlow: Flow<PagingData<SearchRecipe>>) {
        launchSafely {
            pagingDataFlow.collectLatest {
                submitData(it)
            }
        }
    }

    private fun FragmentSearchBinding.bindLoadingView() {
        launchSafely {
            viewModel.stateFlow.map { it.loadingViewVisible }
                .distinctUntilChanged()
                .collect {
                    loadingView.root.isVisible = it
                }
        }
    }

    private fun FragmentSearchBinding.bindErrorView() {
        errorView.retryButton.setOnClickListener { viewModel.onPerformSearch() }
        launchSafely {
            viewModel.stateFlow.map { it.errorViewVisible }
                .distinctUntilChanged()
                .collect {
                    errorView.root.isVisible = it
                }
        }
    }

    private fun FragmentSearchBinding.bindEmptyView() {
        launchSafely {
            viewModel.stateFlow.map { it.emptyViewVisible }
                .distinctUntilChanged()
                .collect {
                    emptyView.isVisible = it
                }
        }
    }

    private fun FragmentSearchBinding.bindSearchEditText() {
        header.search.doOnTextChanged { text, _, _, _ ->
            text?.toString()?.let(viewModel::onInputQuery)
        }

        header.searchContainer.setEndIconOnClickListener {
            header.search.text?.clear()
            viewModel.onInputQuery("")
        }

        header.search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.onPerformSearch()
                requireView().hideKeyboard()
                true
            } else {
                false
            }
        }
    }

    private fun FragmentSearchBinding.applyWindowInsets() {
        header.toolbar.doOnApplyWindowInsetsCompat { toolbar, windowInsetsCompat, initialPadding ->
            toolbar.updatePadding(top = initialPadding.top + windowInsetsCompat.statusBar.top)
        }
        root.doOnApplyWindowInsetsCompat { root, windowInsetsCompat, initialPadding ->
            root.updatePadding(right = initialPadding.right + windowInsetsCompat.systemBars.right)
        }
        searchRecipes.doOnApplyWindowInsetsCompat { list, windowInsetsCompat, initialPadding ->
            list.updatePadding(bottom = initialPadding.bottom + windowInsetsCompat.systemBars.bottom)
        }
    }

    private fun FragmentSearchBinding.bindNavigationButton() {
        header.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}