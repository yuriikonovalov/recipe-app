//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.model](../index.md)/[SearchRecipeResponseApi](index.md)

# SearchRecipeResponseApi

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [SearchRecipeResponseApi](index.md)(@Json(name = &quot;number&quot;)val number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;offset&quot;)val offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;results&quot;)val recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SearchRecipeApi](../-search-recipe-api/index.md)&gt;? = null, @Json(name = &quot;totalResults&quot;)val totalResults: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null)

## Constructors

| | |
|---|---|
| [SearchRecipeResponseApi](-search-recipe-response-api.md) | [androidJvm]<br>fun [SearchRecipeResponseApi](-search-recipe-response-api.md)(@Json(name = &quot;number&quot;)number: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;offset&quot;)offset: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Json(name = &quot;results&quot;)recipes: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SearchRecipeApi](../-search-recipe-api/index.md)&gt;? = null, @Json(name = &quot;totalResults&quot;)totalResults: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [number](number.md) | [androidJvm]<br>val [number](number.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [offset](offset.md) | [androidJvm]<br>val [offset](offset.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [recipes](recipes.md) | [androidJvm]<br>val [recipes](recipes.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[SearchRecipeApi](../-search-recipe-api/index.md)&gt;? = null |
| [totalResults](total-results.md) | [androidJvm]<br>val [totalResults](total-results.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
