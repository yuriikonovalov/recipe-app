//[app](../../../index.md)/[com.yuriikonovalov.recipeapp.framework.data.remote.model](../index.md)/[MeasureApi](index.md)

# MeasureApi

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [MeasureApi](index.md)(@Json(name = &quot;metric&quot;)val metric: [MeasureApi.MeasureCompoundApi](-measure-compound-api/index.md)? = null, @Json(name = &quot;us&quot;)val us: [MeasureApi.MeasureCompoundApi](-measure-compound-api/index.md)? = null)

## Constructors

| | |
|---|---|
| [MeasureApi](-measure-api.md) | [androidJvm]<br>fun [MeasureApi](-measure-api.md)(@Json(name = &quot;metric&quot;)metric: [MeasureApi.MeasureCompoundApi](-measure-compound-api/index.md)? = null, @Json(name = &quot;us&quot;)us: [MeasureApi.MeasureCompoundApi](-measure-compound-api/index.md)? = null) |

## Types

| Name | Summary |
|---|---|
| [MeasureCompoundApi](-measure-compound-api/index.md) | [androidJvm]<br>@JsonClass(generateAdapter = true)<br>data class [MeasureCompoundApi](-measure-compound-api/index.md)(@Json(name = &quot;amount&quot;)val amount: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)? = null, @Json(name = &quot;unitLong&quot;)val unitLong: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Json(name = &quot;unitShort&quot;)val unitShort: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [metric](metric.md) | [androidJvm]<br>val [metric](metric.md): [MeasureApi.MeasureCompoundApi](-measure-compound-api/index.md)? = null |
| [us](us.md) | [androidJvm]<br>val [us](us.md): [MeasureApi.MeasureCompoundApi](-measure-compound-api/index.md)? = null |
