package com.yuriikonovalov.recipeapp.framework.ui.home

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.application.usecases.GetRandomRecipesUseCase
import com.yuriikonovalov.recipeapp.application.usecases.UpdateRandomRecipesUseCase
import com.yuriikonovalov.recipeapp.data.local.DateProvider
import com.yuriikonovalov.recipeapp.framework.ui.BaseViewModelTest
import com.yuriikonovalov.recipeapp.util.EspressoIdlingResource
import com.yuriikonovalov.recipeapp.util.FakeRandomRecipeMapperUi
import com.yuriikonovalov.recipeapp.util.MainDispatcherRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineScheduler
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest : BaseViewModelTest() {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(StandardTestDispatcher(TestCoroutineScheduler()))

    @Mock
    lateinit var dateProvider: DateProvider
    private lateinit var sut: HomeViewModel


    @Before
    fun setup() {
        super.setupBase()
        remoteDataSourceAsFake
        val mockEspressoIdlingResource = mock<EspressoIdlingResource>()
        sut = HomeViewModel(
            GetRandomRecipesUseCase(repository),
            UpdateRandomRecipesUseCase(repository, dateProvider),
            FakeRandomRecipeMapperUi,
            mainDispatcherRule.testDispatcherProvider,
            mockEspressoIdlingResource
        )
    }

    @Test
    fun refreshRecipes_setLoadingFlagToTrueWhenWorkingAndToFalseWhenDone() = runTest {
        // BEFORE
        // Set last cache date any date that's before the today date.
        val beforeToday = "10 Oct 2022"
        val today = "12 Oct 2022"
        preferenceDataSourceAsFake.cacheDate.value = beforeToday
        whenever(dateProvider.today()).thenReturn(today)

        // WHEN
        sut.refreshRecipes()
        assertThat(sut.stateFlow.value.loading).isTrue()

        advanceUntilIdle()
        // THEN
        assertThat(sut.stateFlow.value.loading).isFalse()
    }

}