package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import androidx.core.os.bundleOf
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import com.adevinta.android.barista.interaction.BaristaScrollInteractions
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.fakes.recipe
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import com.yuriikonovalov.recipeapp.util.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.Matchers.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@MediumTest
@HiltAndroidTest
class RecipeDetailsFragmentTest {
    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Inject
    lateinit var localSource: RecipeLocalDataSource

    @Inject
    lateinit var espressoIdlingResource: EspressoIdlingResource

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        IdlingRegistry.getInstance().register(espressoIdlingResource.instance)
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(espressoIdlingResource.instance)
    }

    @Test
    fun recipeIsSaved_saveButtonHasCorrectText() = runTest {
        // BEFORE
        val recipe = recipe(saved = true, cache = true)
        localSource.insertRecipe(recipe)

        // WHEN
        launchFragmentInHiltContainer<RecipeDetailsFragment>(
            fragmentArgs = bundleOf("recipeId" to recipe.id)
        )

        // THEN
        onView(withId(R.id.save_button))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.saved)))
    }

    @Test
    fun recipeIsNotSaved_saveButtonHasCorrectText() = runTest {
        // BEFORE
        val recipe = recipe(saved = false, cache = true)
        localSource.insertRecipe(recipe)

        // WHEN
        launchFragmentInHiltContainer<RecipeDetailsFragment>(
            fragmentArgs = bundleOf("recipeId" to recipe.id)
        )

        // THEN
        onView(withId(R.id.save_button))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.save)))
    }

    @Test
    fun clickSaveButton_textChanged() = runTest {
        // BEFORE
        val recipe = recipe(saved = false)
        localSource.insertRecipe(recipe)

        // WHEN
        launchFragmentInHiltContainer<RecipeDetailsFragment>(
            fragmentArgs = bundleOf("recipeId" to recipe.id)
        )

        // THEN
        onView(withId(R.id.save_button))
            .check(matches(isDisplayed()))
            .check(matches(withText(R.string.save)))
            .perform(click())
            .check(matches(withText(R.string.saved)))
    }

    @Test
    fun sourcePageUrl_sourceButtonDisplayed() = runTest {
        // BEFORE
        val recipe = recipe().copy(sourceUrl = "www.source.com")
        localSource.insertRecipe(recipe)

        // WHEN
        launchFragmentInHiltContainer<RecipeDetailsFragment>(
            fragmentArgs = bundleOf("recipeId" to recipe.id)
        )

        // THEN
        // Scroll to the source button.
        BaristaScrollInteractions.scrollTo(R.id.source_button)
        onView(withId(R.id.source_button))
            .check(matches(isDisplayed()))
    }

    @Test
    fun changeMeasureSystem() = runTest {
        // BEFORE
        val recipe = recipe().copy(sourceUrl = "www.source.com")
        localSource.insertRecipe(recipe)

        // WHEN
        launchFragmentInHiltContainer<RecipeDetailsFragment>(
            fragmentArgs = bundleOf("recipeId" to recipe.id)
        )

        // Click on spinner.
        onView(withId(R.id.measure_system_spinner))
            .check(matches(isDisplayed()))
            .perform(click())
        // Click on the second item in the spinner.
        onData(`is`(instanceOf(String::class.java)))
            .atPosition(1)
            .perform(click())

        // Check selected item.
        onView(withId(R.id.measure_system_spinner))
            .check(matches(withSpinnerText(R.string.us)))
    }
}