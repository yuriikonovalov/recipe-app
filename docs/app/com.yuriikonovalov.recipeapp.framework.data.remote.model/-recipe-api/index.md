//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.model](../index.md)/[RecipeApi](index.md)

# RecipeApi

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [RecipeApi](index.md)(@Json(name = &quot;dishTypes&quot;)val dishTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, @Json(name = &quot;extendedIngredients&quot;)val extendedIngredient: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExtendedIngredientApi](../-extended-ingredient-api/index.md)&gt;? = null, @Json(name = &quot;id&quot;)val id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Json(name = &quot;image&quot;)val image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;instructions&quot;)val instructions: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;readyInMinutes&quot;)val readyInMinutes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;servings&quot;)val servings: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;sourceUrl&quot;)val sourceUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;title&quot;)val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;vegetarian&quot;)val vegetarian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null)

## Constructors

| | |
|---|---|
| [RecipeApi](-recipe-api.md) | [androidJvm]<br>fun [RecipeApi](-recipe-api.md)(@Json(name = &quot;dishTypes&quot;)dishTypes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, @Json(name = &quot;extendedIngredients&quot;)extendedIngredient: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExtendedIngredientApi](../-extended-ingredient-api/index.md)&gt;? = null, @Json(name = &quot;id&quot;)id: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @Json(name = &quot;image&quot;)image: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;instructions&quot;)instructions: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;readyInMinutes&quot;)readyInMinutes: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;servings&quot;)servings: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;sourceUrl&quot;)sourceUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;title&quot;)title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;vegetarian&quot;)vegetarian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [dishTypes](dish-types.md) | [androidJvm]<br>val [dishTypes](dish-types.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null |
| [extendedIngredient](extended-ingredient.md) | [androidJvm]<br>val [extendedIngredient](extended-ingredient.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ExtendedIngredientApi](../-extended-ingredient-api/index.md)&gt;? = null |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [image](image.md) | [androidJvm]<br>val [image](image.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [instructions](instructions.md) | [androidJvm]<br>val [instructions](instructions.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [readyInMinutes](ready-in-minutes.md) | [androidJvm]<br>val [readyInMinutes](ready-in-minutes.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [servings](servings.md) | [androidJvm]<br>val [servings](servings.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [sourceUrl](source-url.md) | [androidJvm]<br>val [sourceUrl](source-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [title](title.md) | [androidJvm]<br>val [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [vegetarian](vegetarian.md) | [androidJvm]<br>val [vegetarian](vegetarian.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null |
