package com.example.lindy_tummy.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bina_desa_notes")
data class BinaDesaNoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val content: String,
    val createdAt: Long
)