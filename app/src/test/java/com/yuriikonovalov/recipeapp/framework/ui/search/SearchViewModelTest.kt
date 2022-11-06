package com.yuriikonovalov.recipeapp.framework.ui.search

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.usecases.SearchRecipes
import com.yuriikonovalov.recipeapp.fake.usecase.FakeSearchRecipes
import com.yuriikonovalov.recipeapp.presentation.search.SearchEvent
import com.yuriikonovalov.recipeapp.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private fun initSUT(searchRecipes: SearchRecipes = FakeSearchRecipes()) =
        SearchViewModel(searchRecipes)

    @Test
    fun `if input a query - state's query value should be updated`() {
        // BEFORE
        val expected = "abc"
        val sut = initSUT()

        // WHEN
        sut.onInputQuery(expected)

        // THEN
        val actual = sut.stateFlow.value.query
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `if input a query with white spaces at the beginning and end - the white spaces should be trimmed`() {
        // BEFORE
        val sut = initSUT()
        val input = "   abc "
        val expected = input.trim()

        // WHEN
        sut.onInputQuery(input)

        // THEN
        val actual = sut.stateFlow.value.query
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `if perform search with a blank query - event value should be IncorrectQueryToast`() {
        // BEFORE
        val sut = initSUT()
        val input = " "
        val expected = SearchEvent.IncorrectQueryToast
        sut.onInputQuery(input)

        // WHEN
        sut.onPerformSearch()

        // THEN
        val actual = sut.eventFlow.value
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `id perform search with a not blank query - event value should not be IncorrectQueryToast`() {
        // BEFORE
        val sut = initSUT()
        val input = "not blank"
        sut.onInputQuery(input)

        // WHEN
        sut.onPerformSearch()

        // THEN
        val actual = sut.eventFlow.value
        assertThat(actual).isNotEqualTo(SearchEvent.IncorrectQueryToast)
    }
}