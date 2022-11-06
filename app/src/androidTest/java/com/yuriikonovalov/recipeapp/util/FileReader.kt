package com.yuriikonovalov.recipeapp.util

import androidx.test.platform.app.InstrumentationRegistry
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.yuriikonovalov.recipeapp.application.entities.SearchRecipe
import com.yuriikonovalov.recipeapp.framework.data.remote.mapper.SearchRecipeMapperApi
import com.yuriikonovalov.recipeapp.framework.data.remote.mapper.SearchRecipeResponseMapperApi
import com.yuriikonovalov.recipeapp.framework.data.remote.model.SearchRecipeResponseApi
import java.io.IOException


fun readStringFromFile(fileName: String): String {
    return try {
        val inputStream = InstrumentationRegistry.getInstrumentation().context.assets
            .open(fileName)

        buildString {
            inputStream.reader().forEachLine { string ->
                append(string)
            }
        }
    } catch (e: IOException) {
        throw e
    }
}

@ExperimentalStdlibApi
fun readSearchRecipeResponseFromJson(fileName: String): List<SearchRecipe>? {
    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter<SearchRecipeResponseApi>()
    val searchRecipeResponseApi = jsonAdapter.fromJson(readStringFromFile(fileName))
    val mapper = SearchRecipeResponseMapperApi(SearchRecipeMapperApi())
    return searchRecipeResponseApi?.let {
        mapper.mapToDomain(it).recipes
    }
}

