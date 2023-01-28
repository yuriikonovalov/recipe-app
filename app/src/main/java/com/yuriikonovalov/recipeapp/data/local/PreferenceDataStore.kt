package com.yuriikonovalov.recipeapp.data.local

import kotlinx.coroutines.flow.Flow

/**
 * Defines the interface for a class that will provide access to app preferences.
 */
interface PreferenceDataStore {
    /**
     * Creates a [Flow] that emits last cache date as [String].
     *
     * @return a [Flow] that emits last cache date as [String].
     */
    fun getLastCacheDate(): Flow<String>

    /**
     * Update last cache date with the given [date].
     *
     * @param date new date.
     */
    suspend fun updateLastCacheDate(date: String)
}