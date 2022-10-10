package com.yuriikonovalov.recipeapp.framework.data.local.preferences

import androidx.datastore.preferences.core.stringPreferencesKey

const val PREFERENCES_NAME = "app_preferences"

object PreferenceKeys {
    val lastCacheDate = stringPreferencesKey("last_cache_date")
}
