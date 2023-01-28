//[app](../../index.md)/[com.yuriikonovalov.recipeapp.presentation.home](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the classes related to the home feature of the presentation layer of the application.

## Types

| Name | Summary |
|---|---|
| [HomeEvent](-home-event/index.md) | [androidJvm]<br>sealed class [HomeEvent](-home-event/index.md)<br>This class represents events related to the home feature. |
| [HomeState](-home-state/index.md) | [androidJvm]<br>data class [HomeState](-home-state/index.md)(val recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[RandomRecipeUi](../com.yuriikonovalov.recipeapp.presentation.model/-random-recipe-ui/index.md)&gt; = emptyList(), val loading: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val empty: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)<br>This class holds state of the home screen. |
