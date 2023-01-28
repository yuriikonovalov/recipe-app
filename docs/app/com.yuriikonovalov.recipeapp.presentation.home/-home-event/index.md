//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.presentation.home](../index.md)/[HomeEvent](index.md)

# HomeEvent

[androidJvm]\
sealed class [HomeEvent](index.md)

This class represents events related to the home feature.

## Types

| Name | Summary |
|---|---|
| [GoToSearchFragment](-go-to-search-fragment/index.md) | [androidJvm]<br>object [GoToSearchFragment](-go-to-search-fragment/index.md) : [HomeEvent](index.md) |
| [OpenRecipeDetails](-open-recipe-details/index.md) | [androidJvm]<br>data class [OpenRecipeDetails](-open-recipe-details/index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [HomeEvent](index.md)<br>Represents an event of opening recipe details for the given [id](-open-recipe-details/id.md). |

## Inheritors

| Name |
|---|
| [OpenRecipeDetails](-open-recipe-details/index.md) |
| [GoToSearchFragment](-go-to-search-fragment/index.md) |
