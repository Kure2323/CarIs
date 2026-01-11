package com.polete.caris.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.polete.caris.data.local.entities.Car
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {

    @Insert
    suspend fun insert(car: Car)

    @Update
    suspend fun update(car: Car)

    @Delete
    suspend fun delete(car: Car)

    @Query("SELECT * FROM car")
    fun getAllCars(): Flow<List<Car>>

    @Query("""
        SELECT * FROM car
        WHERE id IN (
            SELECT carId FROM parking WHERE carId IS NOT NULL
        )
    """)
    fun getParkedCars(): Flow<List<Car>>


}