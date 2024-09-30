package com.testando.aula15.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "livro_table")
data class Livro(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nome: String,
    val ano: Int
): Parcelable