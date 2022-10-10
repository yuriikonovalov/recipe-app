package com.yuriikonovalov.recipeapp.framework.ui.home

import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.fakes.recipe
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import com.yuriikonovalov.recipeapp.util.asFake
import com.yuriikonovalov.recipeapp.util.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@MediumTest
@HiltAndroidTest
class HomeFragmentTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var localSource: RecipeLocalDataSource

    @Inject
    lateinit var remoteSource: RecipeRemoteDataSource

    @Inject
    lateinit var idlingResource: EspressoIdlingResource

    private lateinit var testNavHostController: TestNavHostController

    @Before
    fun setup() {
        hiltRule.inject()
        IdlingRegistry.getInstance().register(idlingResource.instance)
        testNavHostController = TestNavHostController(ApplicationProvider.getApplicationContext())
        UiThreadStatement.runOnUiThread {
            testNavHostController.setGraph(R.navigation.nav_graph)
            testNavHostController.setCurrentDestination(R.id.homeFragment)
        }
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(idlingResource.instance)
    }


    @Test
    fun clickSearchButton_navigateToSearchFragment() {
        // BEFORE
        launchFragmentInHiltContainer<HomeFragment>(navHostController = testNavHostController)

        // WHEN
        onView(withId(R.id.search_button))
            .perform(click())

        // THEN
        assertThat(testNavHostController.currentDestination?.id).isEqualTo(R.id.searchFragment)
    }

    @Test
    fun clickRandomRecipe_navigateToRecipeDetailsFragment() = runTest {
        // BEFORE
        // Set recipes which will be passed to a recycler view.
        remoteSource.asFake().randomRecipes = emptyList()
        val recipe = recipe(cache = true)
        localSource.insertRecipe(recipe)
        launchFragmentInHiltContainer<HomeFragment>(navHostController = testNavHostController)

        // WHEN
        // Click on the first item in the list.
        onView(withId(R.id.random_recipe_list))
            .perform(actionOnItemAtPosition<RandomRecipeAdapter.RecipeViewHolder>(0, click()))

        // THEN
        assertThat(testNavHostController.currentDestination?.id).isEqualTo(R.id.recipeDetailsFragment)
    }
}