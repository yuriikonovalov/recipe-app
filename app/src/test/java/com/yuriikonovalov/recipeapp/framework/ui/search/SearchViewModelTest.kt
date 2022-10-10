package com.yuriikonovalov.recipeapp.framework.ui.search

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.usecases.SearchRecipesUseCase
import com.yuriikonovalov.recipeapp.framework.ui.BaseViewModelTest
import com.yuriikonovalov.recipeapp.presentation.search.SearchEvent
import com.yuriikonovalov.recipeapp.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class SearchViewModelTest : BaseViewModelTest() {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var sut: SearchViewModel

    @Before
    fun setup() {
        super.setupBase()
        sut = SearchViewModel(
            SearchRecipesUseCase(repository),
            mainDispatcherRule.testDispatcherProvider
        )
    }

    @Test
    fun onInputQuery_shouldUpdateState() {
        // BEFORE
        val input = "abc"

        // WHEN
        sut.onInputQuery(input)

        // THEN
        assertThat(sut.stateFlow.value.query).isEqualTo(input)
    }

    @Test
    fun onInputQueryWithWhiteSpacesAtTheBeginningAndEnd_shouldUpdateStateOmittingWhiteSpaces() {
        // BEFORE
        val input = "   abc"
        val expected = input.trim()

        // WHEN
        sut.onInputQuery(input)

        // THEN
        assertThat(sut.stateFlow.value.query).isEqualTo(expected)
    }

    @Test
    fun onPerformSearchWithBlankQuery_shouldShowErrorToast() {
        // BEFORE
        val input = " "
        sut.onInputQuery(input)

        // WHEN
        sut.onPerformSearch()

        // THEN
        assertThat(sut.eventFlow.value).isEqualTo(SearchEvent.IncorrectQueryToast)
    }

    @Test
    fun onPerformSearchWithNotBlankQuery_shouldNotShowErrorToast() {
        // BEFORE
        val input = "not blank"
        sut.onInputQuery(input)

        // WHEN
        sut.onPerformSearch()

        // THEN
        assertThat(sut.eventFlow.value).isEqualTo(null)
    }
}