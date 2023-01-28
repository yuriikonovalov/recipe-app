package com.yuriikonovalov.recipeapp.data.local

/**
 * Defines the interface for classes that will provide current date.
 */
interface DateProvider {
    fun today(): String
}