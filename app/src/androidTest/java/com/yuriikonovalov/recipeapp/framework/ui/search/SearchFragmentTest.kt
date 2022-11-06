package com.yuriikonovalov.recipeapp.framework.ui.search

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.data.local.RecipeLocalDataSource
import com.yuriikonovalov.recipeapp.data.remote.RecipeRemoteDataSource
import com.yuriikonovalov.recipeapp.util.Request
import com.yuriikonovalov.recipeapp.util.launchFragmentInHiltContainer
import com.yuriikonovalov.recipeapp.util.readSearchRecipeResponseFromJson
import com.yuriikonovalov.recipeapp.util.readStringFromFile
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import org.hamcrest.Matchers.not
import org.junit.After
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

    @Inject
    lateinit var okHttpClient: OkHttpClient

    private val server = MockWebServer()
    private lateinit var okHttpIdlingResource: OkHttp3IdlingResource

    @Before
    fun setup() {
        hiltRule.inject()
        okHttpIdlingResource = OkHttp3IdlingResource.create("okhttp", okHttpClient)
        IdlingRegistry.getInstance().register(okHttpIdlingResource)
        server.start(8080)
    }

    @After
    fun teardown() {
        server.shutdown()
        IdlingRegistry.getInstance().unregister(okHttpIdlingResource)
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
    fun thrownExceptionDuringLoading_errorViewDisplayed() {
        // BEFORE
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(400)
            }
        }

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
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(readStringFromFile(Request.SearchRecipes.FILE))
            }
        }
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
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(readStringFromFile(Request.SearchRecipesEmpty.FILE))
            }
        }
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

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun clickOnListItem_navigateToRecipeDetailsFragment() {
        // BEFORE
        server.dispatcher = object : Dispatcher() {
            override fun dispatch(request: RecordedRequest): MockResponse {
                return MockResponse()
                    .setResponseCode(200)
                    .setBody(readStringFromFile(Request.SearchRecipes.FILE))
            }
        }
        val recipes = readSearchRecipeResponseFromJson(Request.SearchRecipes.FILE)!!
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