package com.yuriikonovalov.recipeapp.framework.ui.home

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.usecases.GetRandomRecipes
import com.yuriikonovalov.recipeapp.application.usecases.UpdateRandomRecipes
import com.yuriikonovalov.recipeapp.fake.usecase.FakeGetRandomRecipes
import com.yuriikonovalov.recipeapp.fake.usecase.FakeUpdateRandomRecipes
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import com.yuriikonovalov.recipeapp.fake.mapper.FakeRandomRecipeMapperUi
import com.yuriikonovalov.recipeapp.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val mockEspressoIdlingResource: EspressoIdlingResource = mock()

    private fun initSUT(
        getRandomRecipes: GetRandomRecipes = FakeGetRandomRecipes(),
        updateRandomRecipes: UpdateRandomRecipes = FakeUpdateRandomRecipes()
    ): HomeViewModel {
        return HomeViewModel(
            getRandomRecipes,
            updateRandomRecipes,
            FakeRandomRecipeMapperUi,
            mockEspressoIdlingResource
        )
    }

    @Test
    fun `if refresh recipes - loading flag should be true when working and false when done`() =
        runTest {
            // BEFORE
            val sut = initSUT()

            // WHEN
            sut.refreshRecipes()
            assertThat(sut.stateFlow.value.loading).isTrue()

            advanceUntilIdle()
            // THEN
            assertThat(sut.stateFlow.value.loading).isFalse()
        }

}