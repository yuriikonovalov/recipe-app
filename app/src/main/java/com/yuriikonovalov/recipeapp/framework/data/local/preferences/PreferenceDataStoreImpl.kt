package com.yuriikonovalov.recipeapp.framework.data.local.preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.yuriikonovalov.recipeapp.data.local.PreferenceDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject


class PreferenceDataStoreImpl @Inject constructor(
    private val preferenceDataStore: DataStore<Preferences>
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
    }

    override suspend fun updateLastCacheDate(date: String) {
        preferenceDataStore.edit { preferences ->
            preferences[PreferenceKeys.lastCacheDate] = date
        }
    }
}