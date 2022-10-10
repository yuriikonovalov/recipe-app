package com.yuriikonovalov.recipeapp.data.local

import kotlinx.coroutines.flow.Flow

interface PreferenceDataStore {
    fun getLastCacheDate(): Flow<String>
    suspend fun updateLastCacheDate(date: String)
}