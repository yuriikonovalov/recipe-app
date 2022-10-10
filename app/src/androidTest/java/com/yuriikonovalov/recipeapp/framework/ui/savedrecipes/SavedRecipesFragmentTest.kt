package com.yuriikonovalov.recipeapp.framework.ui.savedrecipes

import androidx.lifecycle.ViewModelStore
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.fakes.recipe
import com.yuriikonovalov.recipeapp.util.WindowSizeClass
import com.yuriikonovalov.recipeapp.util.computeWidthWindowSizeClass
import com.yuriikonovalov.recipeapp.util.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.Matchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@MediumTest
@HiltAndroidTest
class SavedRecipesFragmentTest {

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    //
    @Inject
    lateinit var localSource: RecipeLocalDataSource

    private lateinit var testNavHostController: TestNavHostController
    private lateinit var widthWindowSizeClass: WindowSizeClass

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        testNavHostController = TestNavHostController(ApplicationProvider.getApplicationContext())

        UiThreadStatement.runOnUiThread {
            testNavHostController.setViewModelStore(ViewModelStore())
            testNavHostController.setGraph(R.navigation.nav_graph)
            testNavHostController.setCurrentDestination(R.id.savedRecipesFragment)
        }
        launchFragmentInHiltContainer<SavedRecipesFragment>(navHostController = testNavHostController) {
            widthWindowSizeClass = requireActivity().computeWidthWindowSizeClass()
        }
    }

    @Test
    fun noSavedRecipes_messageEmptyDisplayed() {
        onView(withId(R.id.empty_placeholder))
            .check(matches(isDisplayed()))
    }

    @Test
    fun savedRecipesExist_messageEmptyNotDisplayed() = runTest {
        localSource.insertRecipe(recipe(saved = true))
        onView(withId(R.id.empty_placeholder))
            .check(matches(not(isDisplayed())))
    }


    @Test
    fun clickOnListItem_detailsDisplayed() = runTest {
        // Add recipes to local source.
        val recipe = recipe(saved = true)
        localSource.insertRecipe(recipe)

        // Check if a list of the recipes is displayed.
        onView(withId(R.id.recipes))
            .check(matches(isDisplayed()))

        if (widthWindowSizeClass == WindowSizeClass.EXPANDED) {
            // The detail container is always displayed when WindowSizeClass(width) is EXPANDED.
            onView(withId(R.id.detail_container))
                .check(matches(isDisplayed()))
        } else {
            // For smaller window size classes the details container is displayed
            // only after clicking on a list item.
            onView(withId(R.id.detail_container))
                .check(matches(not(isDisplayed())))
        }

        // Click on a list item.
        onView(withId(R.id.recipes))
            .perform(
                actionOnItemAtPosition<RecipeAdapter.RecipeViewHolder>(0, click())
            )

        // Check if the detail container displayed.
        onView(withId(R.id.detail_container))
            .check(matches(isDisplayed()))
    }
}