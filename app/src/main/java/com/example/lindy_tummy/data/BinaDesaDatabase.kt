package com.example.lindy_tummy.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lindy_tummy.data.dao.BinaDesaNoteDao
import com.example.lindy_tummy.data.entity.BinaDesaNoteEntity

@Database(entities = [BinaDesaNoteEntity::class], version = 1)
abstract class BinaDesaDatabase : RoomDatabase() {

    abstract fun binaDesaNoteDao(): BinaDesaNoteDao

    companion object {
        @Volatile
        private var INSTANCE: BinaDesaDatabase? = null

        fun getInstance(context: Context): BinaDesaDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    BinaDesaDatabase::class.java,
                    "bina_desa_db"
                )
                    .fallbackToDestructiveMigration() // Menangani perubahan skema otomatis saat dev
                    .build().also { INSTANCE = it }
            }
        }
    }
}