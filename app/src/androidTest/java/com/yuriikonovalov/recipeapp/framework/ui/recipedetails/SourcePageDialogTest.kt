package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.net.Uri
import androidx.core.os.bundleOf
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.util.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@MediumTest
@HiltAndroidTest
class SourcePageDialogTest {
    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        Intents.init()
        Intents.intending(not(isInternal()))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_OK, null))
    }

    @After
    fun release() {
        Intents.release()
    }

    @Test
    fun openFragment_progressBarDisplayed() {
        launchFragmentInHiltContainer<SourcePageDialog>(
            fragmentArgs = bundleOf("url" to "www.google.com")
        )
        onView(withId(R.id.progress_bar))
            .check(matches(isDisplayed()))
    }

    @Test
    fun clickMenuButton_menuDisplayed() {
        launchFragmentInHiltContainer<SourcePageDialog>(
            fragmentArgs = bundleOf("url" to "www.google.com")
        )
        // Click on a menu button.
        openContextualActionModeOverflowMenu()

        // Check the menu item's are displayed.
        onView(withText(R.string.open_in_browser))
            .check(matches(isDisplayed()))
        onView(withText(R.string.copy_url))
            .check(matches(isDisplayed()))
    }

    @Test
    fun clickOpenInBrowser_intentSuccess() {
        val url = "www.google.com"
        launchFragmentInHiltContainer<SourcePageDialog>(
            fragmentArgs = bundleOf("url" to url)
        )
        // Click on a menu button.
        openContextualActionModeOverflowMenu()

        // Check the menu item's are displayed.
        onView(withText(R.string.open_in_browser))
            .check(matches(isDisplayed()))
            .perform(click())

        // Check an intent.
        Intents.intended(
            allOf(
                hasAction(Intent.ACTION_VIEW),
                hasData(Uri.parse(url))
            )
        )
    }
}