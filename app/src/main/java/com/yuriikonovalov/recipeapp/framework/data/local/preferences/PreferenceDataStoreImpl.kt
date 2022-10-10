package com.yuriikonovalov.recipeapp.framework.data.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import com.yuriikonovalov.recipeapp.util.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject


class PreferenceDataStoreImpl @Inject constructor(
    private val preferenceDataStore: DataStore<Preferences>,
    private val dispatcherProvider: DispatcherProvider
) : PreferenceDataStore {
    override fun getLastCacheDate(): Flow<String> {
        return preferenceDataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[PreferenceKeys.lastCacheDate] ?: ""
            }
            .flowOn(dispatcherProvider.io)
    }

    override suspend fun updateLastCacheDate(date: String) {
        withContext(dispatcherProvider.io) {
            preferenceDataStore.edit { preferences ->
                preferences[PreferenceKeys.lastCacheDate] = date
            }
        }
    }
}