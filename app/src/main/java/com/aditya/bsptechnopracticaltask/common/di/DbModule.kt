package com.aditya.bsptechnopracticaltask.common.di

import android.content.Context
import androidx.room.Room
import com.aditya.bsptechnopracticaltask.data.local.db.BookDao
import com.aditya.bsptechnopracticaltask.data.local.db.BookDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun getBookDao(database : BookDatabase) : BookDao {
        return database.getBookDao()
    }

    @Provides
    @Singleton
    fun getMealDatabase(@ApplicationContext context : Context) : BookDatabase {
        return Room.databaseBuilder(context , BookDatabase::class.java , "BookDb").fallbackToDestructiveMigration().build()
    }


}