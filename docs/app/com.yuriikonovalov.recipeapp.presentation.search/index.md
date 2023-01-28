//[app](../../index.md)/[com.yuriikonovalov.recipeapp.presentation.search](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes related to the search feature of the presentation layer of the application.

## Types

| Name | Summary |
|---|---|
| [SearchEvent](-search-event/index.md) | [androidJvm]<br>sealed class [SearchEvent](-search-event/index.md)<br>This sealed class represents events related to the search feature. |
| [SearchState](-search-state/index.md) | [androidJvm]<br>data class [SearchState](-search-state/index.md)(val query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val combinedLoadStates: [CombinedLoadStates](https://developer.android.com/reference/kotlin/androidx/paging/CombinedLoadStates.html) = defaultCombinedLoadStates(), val resultItemCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)<br>This class holds state of the search screen. |
