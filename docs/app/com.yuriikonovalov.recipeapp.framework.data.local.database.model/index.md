//[app](../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.local.database.model](index.md)

# Package-level declarations

[androidJvm]\
Contains all of the db model classes.

## Types

| Name | Summary |
|---|---|
| [IngredientDb](-ingredient-db/index.md) | [androidJvm]<br>data class [IngredientDb](-ingredient-db/index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0, val recipeId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val amountUs: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)?, val unitLongUs: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val unitShortUs: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val amountMetric: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)?, val unitLongMetric: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val unitShortMetric: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [RecipeDb](-recipe-db/index.md) | [androidJvm]<br>data class [RecipeDb](-recipe-db/index.md)(val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val mealTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[MealType](../com.yuriikonovalov.recipeapp.application.entities/-meal-type/index.md)&gt;, val instructions: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val readyInMinutes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, val servings: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val sourceUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val vegetarian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?, val cache: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val saved: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
