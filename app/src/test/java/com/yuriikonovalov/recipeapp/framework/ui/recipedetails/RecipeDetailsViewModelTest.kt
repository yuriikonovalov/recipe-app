package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import com.google.common.truth.Truth.*
import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.application.usecases.*
import com.yuriikonovalov.recipeapp.fake.usecase.FakeGetRecipeDetails
import com.yuriikonovalov.recipeapp.fake.usecase.FakeSaveRecipe
import com.yuriikonovalov.recipeapp.fake.usecase.FakeUnsaveRecipe
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import com.yuriikonovalov.recipeapp.fake.mapper.FakeRecipeMapperUi
import com.yuriikonovalov.recipeapp.util.MainDispatcherRule
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class RecipeDetailsViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private val mockEspressoIdlingResource: EspressoIdlingResource = mock()

    private fun initSUT(
        id: Int,
        saveRecipe: SaveRecipe = FakeSaveRecipe(),
        unsaveRecipe: UnsaveRecipe = FakeUnsaveRecipe(),
        getRecipeDetails: GetRecipeDetails = FakeGetRecipeDetails()
    ) = RecipeDetailsViewModel(
        id,
        saveRecipe,
        unsaveRecipe,
        getRecipeDetails,
        FakeRecipeMapperUi,
        mockEspressoIdlingResource
    )

    @Test
    fun `if open saved recipe - saved flag should be true`() = runTest {
        // BEFORE
        val recipe = recipe(saved = true)
        val sut = initSUT(id = recipe.id, getRecipeDetails = FakeGetRecipeDetails(recipe))

        // WHEN
        runCurrent()

        // THEN
        val actual = sut.stateFlow.value.recipe?.saved
        assertThat(actual).isTrue()
    }

    @Test
    fun `if open not saved recipe - saved flag should be false`() = runTest {
        // BEFORE
        val recipe = recipe(saved = false)
        val sut = initSUT(id = recipe.id, getRecipeDetails = FakeGetRecipeDetails(recipe))

        // WHEN
        runCurrent()

        // THEN
        val actual = sut.stateFlow.value.recipe?.saved
        assertThat(actual).isFalse()
    }

    @Test
    fun `if start the view model - loading flag should be true`() {
        // BEFORE
        val recipe = recipe()
        val sut = initSUT(id = recipe.id, getRecipeDetails = FakeGetRecipeDetails(recipe))

        // THEN
        val actual = sut.stateFlow.value.loading
        assertThat(actual).isTrue()
    }

    @Test
    fun `if getRecipeDetails returns Failure - error flag should be true and loading flag false`() =
        runTest {
            // BEFORE
            val recipe = recipe()
            val sut =
                initSUT(id = recipe.id, getRecipeDetails = FakeGetRecipeDetails(isSuccess = false))

            // WHEN
            advanceUntilIdle()

            // THEN
            val actualError = sut.stateFlow.value.error
            assertThat(actualError).isTrue()

            val actualLoading = sut.stateFlow.value.loading
            assertThat(actualLoading).isFalse()
        }

    @Test
    fun `if change MeasureSystem - should update state with correct MeasureSystem`() {
        /*
           0 -> MeasureSystem.Metric
           1 -> MeasureSystem.Us
           else -> throw IllegalArgumentException("Was expected only 2 items.")
        * */
        // BEFORE
        val sut = initSUT(id = 1)
        // Make sure the current measure system is not the one that we are going to set.
        val actualBeforeChange = sut.stateFlow.value.measureSystem
        assertThat(actualBeforeChange).isNotEqualTo(MeasureSystem.Us)

        // WHEN
        sut.onSelectMeasureSystem(1)

        // THEN
        val actualAfterChange = sut.stateFlow.value.measureSystem
        assertThat(actualAfterChange).isEqualTo(MeasureSystem.Us)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `if select measureSystem that is out of range - should throw exception`() {
        // BEFORE
        val sut = initSUT(id = 1)
        /*
            0 -> MeasureSystem.Metric
            1 -> MeasureSystem.Us
            else -> throw IllegalArgumentException("Was expected only 2 items.")
         * */

        // WHEN
        sut.onSelectMeasureSystem(2)
    }
}