package com.yuriikonovalov.recipeapp.fake.datasource

import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakePreferenceDataStore(date: String = "") : PreferenceDataStore {
    val cacheDate = MutableStateFlow(date)

    override fun getLastCacheDate(): Flow<String> {
        return cacheDate
    }

    override suspend fun updateLastCacheDate(date: String) {
        cacheDate.emit(date)
    }
}