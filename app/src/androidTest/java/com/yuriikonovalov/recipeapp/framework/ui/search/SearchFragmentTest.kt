package com.yuriikonovalov.recipeapp.framework.ui.search

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.fakes.searchRecipes
import com.yuriikonovalov.recipeapp.util.asFake
import com.yuriikonovalov.recipeapp.util.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import javax.inject.Inject

@MediumTest
@HiltAndroidTest
class SearchFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var localSource: RecipeLocalDataSource

    @Inject
    lateinit var remoteSource: RecipeRemoteDataSource

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun onOpenFragment_noResultsMessageDisplayed() {
        // WHEN
        launchFragmentInHiltContainer<SearchFragment>()

        // THEN
        // Empty view is displayed.
        onView(withText(R.string.search_empty_message))
            .check(matches(isDisplayed()))
    }

    @Test
    fun onNavigateUpButtonClick_navigateUp() {
        // BEFORE
        // Mock the nav controller and pass it to the Fragment.
        val navController = mock<NavController>()
        launchFragmentInHiltContainer<SearchFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }

        // WHEN
        onView(withContentDescription(R.string.content_description_navigate_up))
            .check(matches(isDisplayed()))
            .perform(click())

        // THEN
        verify(navController).navigateUp()
    }

    @Test
    fun editTextEmpty_clearTextIconNotDisplayed() {
        // BEFORE
        launchFragmentInHiltContainer<SearchFragment>()

        // WHEN
        onView(withId(R.id.search))
            .perform(click())
            .perform(typeText(""))

        // THEN
        onView(withContentDescription(R.string.content_description_clear_text))
            .check(matches(not(isDisplayed())))
    }

    @Test
    fun editTextNotEmpty_clearTextIconDisplayed() {
        // BEFORE
        launchFragmentInHiltContainer<SearchFragment>()

        // WHEN
        // Input some text in the edit text.
        onView(withId(R.id.search))
            .perform(click())
            .perform(typeText("query"))

        // THEN
        // Check if the clear button displayed then click it and check if it is not displayed anymore.
        onView(withContentDescription(R.string.content_description_clear_text))
            .check(matches(isDisplayed()))
            .perform(click())
            .check(matches(not(isDisplayed())))

        // Check that the edit text is cleared.
        onView(withId(R.id.search))
            .check(matches(withText("")))
    }

    @Test
    fun clickSearchButton_loadingViewDisplayed() {
        // BEFORE
        // Set fake loading time as 1 second.
        remoteSource.asFake().delay = 1000

        launchFragmentInHiltContainer<SearchFragment>()

        // WHEN
        // Input a query and press the ime search button.
        onView(withId(R.id.search))
            .check(matches(isDisplayed()))
            .perform(click(), typeText("pizza"), pressImeActionButton())

        // THEN
        onView(withId(R.id.loading_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun thrownExceptionDuringLoading_errorViewDisplayed() {
        // BEFORE
        // Set fake remote source to throw an exception.
        remoteSource.asFake().shouldThrowException(true)

        launchFragmentInHiltContainer<SearchFragment>()

        // WHEN
        // Input a query and press the ime search button.
        onView(withId(R.id.search))
            .check(matches(isDisplayed()))
            .perform(click(), typeText("pizza"), pressImeActionButton())

        // THEN
        onView(withId(R.id.error_view))
            .check(matches(isDisplayed()))
    }

    @Test
    fun successResponse_listOfResultsDisplayed() {
        // BEFORE
        // Set a fake response.
        remoteSource.asFake().searchRecipes = searchRecipes(10, "pizza")
        launchFragmentInHiltContainer<SearchFragment>()

        // WHEN
        // Input a query and press the ime search button.
        onView(withId(R.id.search))
            .check(matches(isDisplayed()))
            .perform(click(), typeText("pizza"), pressImeActionButton())

        // THEN
        onView(withId(R.id.search_recipes))
            .check(matches(isDisplayed()))

        onView(withId(R.id.error_view))
            .check(matches(not(isDisplayed())))

        onView(withId(R.id.loading_view))
            .check(matches(not(isDisplayed())))
    }

    @Test
    fun emptyResponse_showNoResultsMessage() {
        // BEFORE
        // Set a fake response.
        remoteSource.asFake().searchRecipes = emptyList()
        launchFragmentInHiltContainer<SearchFragment>()

        // WHEN
        // Input a query and press the ime search button.
        onView(withId(R.id.search))
            .check(matches(isDisplayed()))
            .perform(click(), typeText("pizza"), pressImeActionButton())

        // THEN
        // Empty view is displayed.
        onView(withText(R.string.search_empty_message))
            .check(matches(isDisplayed()))
    }

    @Test
    fun clickOnListItem_navigateToRecipeDetailsFragment() {
        // BEFORE
        val recipes = searchRecipes(10, "pizza")
        remoteSource.asFake().searchRecipes = recipes
        val navController = mock<NavController>()
        launchFragmentInHiltContainer<SearchFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }
        val position = 5

        // WHEN
        // Input a query and press the ime search button.
        onView(withId(R.id.search))
            .check(matches(isDisplayed()))
            .perform(click(), typeText("pizza"), pressImeActionButton())

        // THEN
        // Scroll to an item at the position 5.
        onView(withId(R.id.search_recipes))
            .perform(scrollToPosition<SearchRecipeAdapter.SearchRecipeViewHolder>(position))
        // Click on an item at the position 5.
        onView(withText(recipes[position].title))
            .check(matches(isDisplayed()))
            .perform(click())
        // Check if the navigation method has been called with the correct id.
        verify(navController).navigate(SearchFragmentDirections.toRecipeDetailsFragment(recipes[position].id))
    }
}