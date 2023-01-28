//[app](../../../../index.md)/[com.yuriikonovalov.recipeapp.resource](../../index.md)/[Resource](../index.md)/[Failure](index.md)

# Failure

[androidJvm]\
data class [Failure](index.md)&lt;[T](index.md)&gt;(val resourceError: [ResourceError](../../-resource-error/index.md)) : [Resource](../index.md)&lt;[T](index.md)&gt; 

A wrapper class for results of failed operations.

## Constructors

| | |
|---|---|
| [Failure](-failure.md) | [androidJvm]<br>fun [Failure](-failure.md)(resourceError: [ResourceError](../../-resource-error/index.md)) |

## Properties

| Name | Summary |
|---|---|
| [resourceError](resource-error.md) | [androidJvm]<br>val [resourceError](resource-error.md): [ResourceError](../../-resource-error/index.md)<br>a [ResourceError](../../-resource-error/index.md) that caused a failure. |
