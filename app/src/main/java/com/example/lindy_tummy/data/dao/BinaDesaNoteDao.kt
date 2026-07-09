package com.example.lindy_tummy.data.dao

import androidx.room.*
import com.example.lindy_tummy.data.entity.BinaDesaNoteEntity

@Dao
interface BinaDesaNoteDao {
    @Query("SELECT * FROM bina_desa_notes")
    suspend fun getAllNotes(): List<BinaDesaNoteEntity>

    @Insert
    suspend fun insertNote(note: BinaDesaNoteEntity)

    @Delete
    suspend fun deleteNote(note: BinaDesaNoteEntity)
}