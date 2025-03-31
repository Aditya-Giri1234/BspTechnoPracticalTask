package com.aditya.bsptechnopracticaltask.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(private val dataStore: DataStore<Preferences>) {

    companion object {
        private val LAST_TIME_API_TIME_STAMP = longPreferencesKey("last_time_api_time_stamp")
        private val IS_DATA_LOADED = booleanPreferencesKey("is_data_loaded")
    }

    suspend fun setLastTimeApiTimeStamp(timeStamp: Long) {
        dataStore.edit { preferences ->
            preferences[LAST_TIME_API_TIME_STAMP] = timeStamp
        }
    }

    suspend fun getLastTimeApiTimeStamp(): Long {
        return dataStore.data.map { preferences ->
            preferences[LAST_TIME_API_TIME_STAMP]
        }.first() ?: System.currentTimeMillis()
    }

    suspend fun setIsDataLoaded(isDataLoaded: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_DATA_LOADED] = isDataLoaded
        }
    }

    suspend fun getIsDataLoaded(): Boolean {
        return dataStore.data.map { preferences ->
            preferences[IS_DATA_LOADED]
        }.first() ?: false
    }

}