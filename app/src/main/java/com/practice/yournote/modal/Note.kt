package com.practice.yournote.modal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo(name = "Title")
    val title : String = "",
    @ColumnInfo(name = "Content")
    val content : String = "",
    @ColumnInfo(name = "Data")
    val data :String = "",
    @ColumnInfo(name = "Color")
    val color : Int
) : Serializable