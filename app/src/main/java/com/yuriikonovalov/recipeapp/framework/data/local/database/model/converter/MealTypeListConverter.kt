package com.yuriikonovalov.recipeapp.framework.data.local.database.model.converter

import androidx.room.TypeConverter
import com.yuriikonovalov.recipeapp.application.entities.MealType
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * This is a converter that is used by the Room library.
 *
 * It converts a list of [MealType] to [String] and back.
 */
class MealTypeListConverter {
    @TypeConverter
    fun listMealTypeToString(value: List<MealType>): String = Json.encodeToString(value)

    @TypeConverter
    fun stringToListMealType(value: String) = Json.decodeFromString<List<MealType>>(value)
}