//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.presentation.search](../index.md)/[SearchState](index.md)

# SearchState

[androidJvm]\
data class [SearchState](index.md)(val query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val combinedLoadStates: [CombinedLoadStates](https://developer.android.com/reference/kotlin/androidx/paging/CombinedLoadStates.html) = defaultCombinedLoadStates(), val resultItemCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)

This class holds state of the search screen.

## Constructors

| | |
|---|---|
| [SearchState](-search-state.md) | [androidJvm]<br>fun [SearchState](-search-state.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, combinedLoadStates: [CombinedLoadStates](https://developer.android.com/reference/kotlin/androidx/paging/CombinedLoadStates.html) = defaultCombinedLoadStates(), resultItemCount: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0)<br>Creates an instance of [SearchState](index.md). |

## Functions

| Name | Summary |
|---|---|
| [updateCombinedLoadStates](update-combined-load-states.md) | [androidJvm]<br>fun [updateCombinedLoadStates](update-combined-load-states.md)(combinedLoadStates: [CombinedLoadStates](https://developer.android.com/reference/kotlin/androidx/paging/CombinedLoadStates.html), count: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [SearchState](index.md) |
| [updateQuery](update-query.md) | [androidJvm]<br>fun [updateQuery](update-query.md)(query: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [SearchState](index.md) |

## Properties

| Name | Summary |
|---|---|
| [combinedLoadStates](combined-load-states.md) | [androidJvm]<br>val [combinedLoadStates](combined-load-states.md): [CombinedLoadStates](https://developer.android.com/reference/kotlin/androidx/paging/CombinedLoadStates.html) |
| [emptyViewVisible](empty-view-visible.md) | [androidJvm]<br>val [emptyViewVisible](empty-view-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [errorViewVisible](error-view-visible.md) | [androidJvm]<br>val [errorViewVisible](error-view-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loadingViewVisible](loading-view-visible.md) | [androidJvm]<br>val [loadingViewVisible](loading-view-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [query](query.md) | [androidJvm]<br>val [query](query.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [resultItemCount](result-item-count.md) | [androidJvm]<br>val [resultItemCount](result-item-count.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0 |
| [searchRecipeListVisible](search-recipe-list-visible.md) | [androidJvm]<br>val [searchRecipeListVisible](search-recipe-list-visible.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
