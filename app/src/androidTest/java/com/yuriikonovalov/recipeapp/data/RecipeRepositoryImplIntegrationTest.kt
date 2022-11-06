package com.yuriikonovalov.recipeapp.data

import app.cash.turbine.test
import com.google.common.truth.Truth.*
import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.resource.ApiException
import com.yuriikonovalov.recipeapp.util.Request
import com.yuriikonovalov.recipeapp.util.readStringFromFile
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
class RecipeRepositoryImplIntegrationTest {
    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var remoteDataSource: RecipeRemoteDataSource

    @Inject
    lateinit var localDataSource: RecipeLocalDataSource

    @Inject
    lateinit var preferenceDataStore: PreferenceDataStore

    private val server = MockWebServer()

    @Before
    fun setup() {
        hiltRule.inject()
        server.start(8080)
    }

    @After
    fun teardown() {
        server.shutdown()
    }

    @Test
    fun refreshRandomRecipeCache_shouldLoadFromRemoteAndSaveToLocal() = runTest {
        // BEFORE
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(readStringFromFile(Request.GetRandomRecipes.FILE))
            }
        }
        val sut = RecipeRepositoryImpl(localDataSource, remoteDataSource, preferenceDataStore)

        // WHEN
        sut.refreshRandomRecipeCache(Request.GetRandomRecipes.NUMBER, "04 Nov 2022")

        // THEN
        sut.getRandomRecipes().test {
            val actual = awaitItem()
            assertThat(actual).hasSize(Request.GetRandomRecipes.NUMBER)
            assertThat(actual.map { it.cache }).doesNotContain(false)
        }
        assertThat(sut.getLastCacheDate().first()).isEqualTo("04 Nov 2022")
    }


    @Test(expected = ApiException::class)
    fun refreshRandomRecipeCacheWithBadResponse_shouldThrowException() = runTest {
        // BEFORE
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(400)
            }
        }
        val sut = RecipeRepositoryImpl(localDataSource, remoteDataSource, preferenceDataStore)

        // WHEN
        sut.refreshRandomRecipeCache(Request.GetRandomRecipes.NUMBER, "04 Nov 2022")
    }
}