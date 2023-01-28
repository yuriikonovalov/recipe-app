package com.yuriikonovalov.recipeapp.util

import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigationrail.NavigationRailView


/**
 * This is an object that contains methods for updating navigation views
 * depending on the current window size.
 */
object AdaptiveNavUtils {
    private const val MEDIUM_SCREEN_WIDTH_SIZE = 600
    private const val LARGE_SCREEN_WIDTH_SIZE = 1240

    /**
     * Updates the visibility of the main navigation view components according to screen size.
     *
     *
     * The small screen layout should have a modal navigation drawer. The medium
     * layout should have a navigation rail, and the large layout should have a standard navigation
     * drawer.
     */
    fun updateNavigationViewLayout(
        screenWidth: Int,
        drawerLayout: DrawerLayout,
        modalNavDrawer: NavigationView,
        navRail: NavigationRailView,
        standardNavDrawer: NavigationView,
    ) {
        // Set navigation menu button to show a modal navigation drawer in medium screens.
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)

        if (screenWidth < MEDIUM_SCREEN_WIDTH_SIZE) {
            // Small screen
            modalNavDrawer.visibility = View.VISIBLE
            navRail.visibility = View.GONE
            standardNavDrawer.visibility = View.GONE
        } else if (screenWidth < LARGE_SCREEN_WIDTH_SIZE) {
            // Medium screen
            modalNavDrawer.visibility = View.GONE
            navRail.visibility = View.VISIBLE
            standardNavDrawer.visibility = View.GONE
        } else {
            // Large screen
            modalNavDrawer.visibility = View.GONE
            navRail.visibility = View.GONE
            standardNavDrawer.visibility = View.VISIBLE
        }
    }
}