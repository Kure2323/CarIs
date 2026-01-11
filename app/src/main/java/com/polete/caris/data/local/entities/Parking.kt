package com.polete.caris.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Parking(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    // Foreign key referencing the Car entity
    val carId: Int?,
)
