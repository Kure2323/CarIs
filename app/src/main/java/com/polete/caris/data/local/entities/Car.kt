package com.polete.caris.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Car(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val licensePlate: String
)
