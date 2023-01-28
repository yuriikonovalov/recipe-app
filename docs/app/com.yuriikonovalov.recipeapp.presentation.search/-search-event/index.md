//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.presentation.search](../index.md)/[SearchEvent](index.md)

# SearchEvent

[androidJvm]\
sealed class [SearchEvent](index.md)

This sealed class represents events related to the search feature.

## Types

| Name | Summary |
|---|---|
| [IncorrectQueryToast](-incorrect-query-toast/index.md) | [androidJvm]<br>object [IncorrectQueryToast](-incorrect-query-toast/index.md) : [SearchEvent](index.md)<br>Represents an event of showing a toast when a query is not correct. |
| [OpenRecipeDetails](-open-recipe-details/index.md) | [androidJvm]<br>data class [OpenRecipeDetails](-open-recipe-details/index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [SearchEvent](index.md)<br>Represents an event of opening a recipe details screen. |

## Inheritors

| Name |
|---|
| [OpenRecipeDetails](-open-recipe-details/index.md) |
| [IncorrectQueryToast](-incorrect-query-toast/index.md) |
