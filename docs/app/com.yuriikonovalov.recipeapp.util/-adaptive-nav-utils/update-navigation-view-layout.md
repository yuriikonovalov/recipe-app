//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.util](../index.md)/[AdaptiveNavUtils](index.md)/[updateNavigationViewLayout](update-navigation-view-layout.md)

# updateNavigationViewLayout

[androidJvm]\
fun [updateNavigationViewLayout](update-navigation-view-layout.md)(screenWidth: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), drawerLayout: [DrawerLayout](https://developer.android.com/reference/kotlin/androidx/drawerlayout/widget/DrawerLayout.html), modalNavDrawer: NavigationView, navRail: NavigationRailView, standardNavDrawer: NavigationView)

Updates the visibility of the main navigation view components according to screen size.

The small screen layout should have a modal navigation drawer. The medium layout should have a navigation rail, and the large layout should have a standard navigation drawer.
