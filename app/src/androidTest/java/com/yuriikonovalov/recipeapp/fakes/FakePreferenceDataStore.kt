package com.yuriikonovalov.recipeapp.fakes

import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class FakePreferenceDataStore @Inject constructor() : PreferenceDataStore {
    val date: String = ""
    val cacheDate = MutableStateFlow(date)

    override fun getLastCacheDate(): Flow<String> {
        return cacheDate
    }

    override suspend fun updateLastCacheDate(date: String) {
        cacheDate.emit(date)
    }
}