package com.yuriikonovalov.recipeapp.util

object Request {
    object GetRandomRecipes {
        const val NUMBER = 5
        const val PATH = "/recipes/random?number=$NUMBER"
        const val FILE = "response_random_recipes.json"
    }

    object SearchRecipes {
        const val NUMBER = 10
        const val OFFSET = 0
        const val QUERY = "pasta"
        const val PATH = "/recipes/complexSearch?number=$NUMBER&offset=$OFFSET&query=$QUERY"
        const val FILE = "response_search.json"
    }

    object SearchRecipesEmpty {
        const val NUMBER = 10
        const val OFFSET = 0
        const val QUERY = "pasta"
        const val PATH = "/recipes/complexSearch?number=$NUMBER&offset=$OFFSET&query=$QUERY"
        const val FILE = "response_search_empty.json"
    }
}