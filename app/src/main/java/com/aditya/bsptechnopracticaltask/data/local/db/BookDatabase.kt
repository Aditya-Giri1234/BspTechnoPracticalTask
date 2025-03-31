package com.aditya.bsptechnopracticaltask.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aditya.bsptechnopracticaltask.domain.models.BookResponse
import com.aditya.bsptechnopracticaltask.domain.models.UserInfo
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.AudiobookTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.AvailableVariantsTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.CategoryTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.ComponentItemTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.CoverTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.EbookTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.EbookXTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.EbookXXTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.ElementTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.LanguageTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.MediaDataTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.MediaDataXTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.PageTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.PillFilterTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.ProductPropertyTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.PropertyTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.PublisherTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.SubtitleTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.TopicTypeConverter
import com.aditya.bsptechnopracticaltask.domain.models.type_converter.UserInfoTypeConverter

@Database(entities = [BookResponse::class] , version = 1 , exportSchema = false)
@TypeConverters(AudiobookTypeConverter::class , AudiobookTypeConverter::class , AvailableVariantsTypeConverter::class , CategoryTypeConverter::class , ComponentItemTypeConverter::class , CoverTypeConverter::class , EbookTypeConverter::class , EbookXTypeConverter::class , EbookXXTypeConverter::class , ElementTypeConverter::class , LanguageTypeConverter::class , MediaDataTypeConverter::class , MediaDataXTypeConverter::class , PageTypeConverter::class , PillFilterTypeConverter::class , ProductPropertyTypeConverter::class , PropertyTypeConverter::class , PublisherTypeConverter::class , SubtitleTypeConverter::class , TopicTypeConverter::class,UserInfoTypeConverter::class)
abstract class BookDatabase : RoomDatabase() {
    abstract fun getBookDao() : BookDao
}