package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.entities.MeasureSystem
import com.yuriikonovalov.recipeapp.application.usecases.GetRecipeDetailsUseCase
import com.yuriikonovalov.recipeapp.application.usecases.SaveRecipeUseCase
import com.yuriikonovalov.recipeapp.application.usecases.UnsaveRecipeUseCase
import com.yuriikonovalov.recipeapp.framework.ui.BaseViewModelTest
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import com.yuriikonovalov.recipeapp.util.FakeRecipeMapperUi
import com.yuriikonovalov.recipeapp.util.MainDispatcherRule
import com.yuriikonovalov.recipeapp.util.recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class RecipeDetailsViewModelTest : BaseViewModelTest() {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var sut: RecipeDetailsViewModel

    // ViewModel's argument.
    private val id = 1

    @Before
    fun setup() {
        super.setupBase()
        val mockEspressoIdlingResource = mock<EspressoIdlingResource>()
        sut = RecipeDetailsViewModel(
            id,
            SaveRecipeUseCase(repository),
            UnsaveRecipeUseCase(repository),
            GetRecipeDetailsUseCase(repository),
            mainDispatcherRule.testDispatcherProvider,
            FakeRecipeMapperUi,
            mockEspressoIdlingResource
        )
    }

    @Test
    fun onSaveButtonClickWhenRecipeIsNotSaved_shouldSetFlagSavedAsTrue() = runTest {
        // BEFORE
        val expectedRecipe = recipe().copy(id = id, saved = false)
        localDataSource.insertRecipe(expectedRecipe)
        assertThat(repository.getRecipe(expectedRecipe.id)!!.saved).isFalse()
        // Make sure recipe details loaded.
        sut.loadRecipeDetails(id)

        // WHEN
        sut.onSaveButtonClick()

        // THEN
        assertThat(repository.getRecipe(expectedRecipe.id)!!.saved).isTrue()
    }

    @Test
    fun onSaveButtonClickWhenRecipeIsSaved_shouldSetFlagSavedAsFalse() = runTest {
        // BEFORE
        val expectedRecipe = recipe().copy(id = id, cache = true, saved = true)
        localDataSource.insertRecipe(expectedRecipe)
        assertThat(repository.getRecipe(expectedRecipe.id)!!.saved).isTrue()
        // Make sure recipe details loaded.
        sut.loadRecipeDetails(id)

        // WHEN
        sut.onSaveButtonClick()

        // THEN
        assertThat(repository.getRecipe(expectedRecipe.id)!!.saved).isFalse()
    }

    @Test
    fun onSelectMeasureSystemCorrectPosition_shouldUpdateStateWithCorrectMeasureSystem() {
        /*
            0 -> MeasureSystem.Metric
            1 -> MeasureSystem.Us
            else -> throw IllegalArgumentException("Was expected only 2 items.")
         * */
        // BEFORE
        // Make sure the current measure system is not one that we are going to set.
        assertThat(sut.stateFlow.value.measureSystem).isNotEqualTo(MeasureSystem.Us)

        // WHEN
        sut.onSelectMeasureSystem(1)

        // THEN
        assertThat(sut.stateFlow.value.measureSystem).isEqualTo(MeasureSystem.Us)
    }

    @Test(expected = IllegalArgumentException::class)
    fun onSelectMeasureSystemOutOfRange_shouldThrowException() {
        /*
            0 -> MeasureSystem.Metric
            1 -> MeasureSystem.Us
            else -> throw IllegalArgumentException("Was expected only 2 items.")
         * */

        // WHEN
        sut.onSelectMeasureSystem(2)
    }

    @Test
    fun exceptionIsThrownWhenLoadingRecipeDetails_shouldSetErrorFlagAsTrue() = runTest {
        // BEFORE
        // Make sure there's no recipe with the given id in local data source.
        remoteDataSourceAsFake.shouldThrowException(true)

        sut.loadRecipeDetails(id)
        assertThat(sut.stateFlow.value.error).isTrue()
    }
}