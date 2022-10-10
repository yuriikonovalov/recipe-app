package com.yuriikonovalov.recipeapp.application.usecases

import com.google.common.truth.Truth.assertThat
import com.yuriikonovalov.recipeapp.data.local.DateProvider
import com.yuriikonovalov.recipeapp.resource.Resource
import com.yuriikonovalov.recipeapp.util.recipes
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class UpdateRandomRecipesUseCaseTest : BaseUseCaseTest() {
    private lateinit var sut: UpdateRandomRecipesUseCase

    @Mock
    lateinit var dateProvider: DateProvider

    @Before
    fun setup() {
        super.setupBase()
        sut = UpdateRandomRecipesUseCase(repository, dateProvider)
    }

    @Test
    fun lastCacheDateIsNotToday_shouldUpdateRecipes() = runTest {
        val yesterday = "11 Oct 2022"
        val today = "12 Oct 2022"
        val oldRandomRecipes = recipes(number = 5, cache = true)
        val expectedSize = 7
        // BEFORE
        localDataSource.insertRecipes(oldRandomRecipes)
        preferenceDataSource.updateLastCacheDate(yesterday)
        whenever(dateProvider.today()).thenReturn(today)

        // WHEN
        sut(expectedSize)

        // THEN
        val actualRandomRecipes = repository.getRandomRecipes().first()
        assertThat(actualRandomRecipes).isNotEqualTo(oldRandomRecipes)
        assertThat(actualRandomRecipes).hasSize(expectedSize)
    }

    @Test
    fun lastCacheDateIsToday_returnResourceSuccessAndDontUpdateRecipes() = runTest {
        val date = "12 Oct 2022"
        val expectedRandomRecipes = recipes(number = 5, cache = true)
        // BEFORE
        localDataSource.insertRecipes(expectedRandomRecipes)
        preferenceDataSource.updateLastCacheDate(date)
        whenever(dateProvider.today()).thenReturn(date)

        // WHEN
        // Update random recipes with 10 recipes as a parameter.
        val resource = sut(10)

        // THEN
        assertThat(resource).isInstanceOf(Resource.Success::class.java)

        val actualRandomRecipes = repository.getRandomRecipes().first()
        assertThat(actualRandomRecipes).isEqualTo(expectedRandomRecipes)
    }

    @Test
    fun lastCacheDateIsTodayAndForced_shouldUpdateRecipes() = runTest {
        val date = "12 Oct 2022"
        val oldRandomRecipes = recipes(number = 5, cache = true)
        val expectedSize = 10
        // BEFORE
        localDataSource.insertRecipes(oldRandomRecipes)
        preferenceDataSource.updateLastCacheDate(date)
        whenever(dateProvider.today()).thenReturn(date)

        // WHEN
        val resource = sut(expectedSize, forced = true)

        // THEN
        assertThat(resource).isInstanceOf(Resource.Success::class.java)

        val actualRandomRecipes = repository.getRandomRecipes().first()
        assertThat(actualRandomRecipes).isNotEqualTo(oldRandomRecipes)
        assertThat(actualRandomRecipes).hasSize(expectedSize)
    }

    @Test
    fun exceptionIsThrown_returnResourceFailure() = runTest {
        // BEFORE
        remoteDataSourceAsFake.shouldThrowException(true)

        // WHEN
        val resource = sut(5)

        // THEN
        assertThat(resource).isInstanceOf(Resource.Failure::class.java)
    }
}