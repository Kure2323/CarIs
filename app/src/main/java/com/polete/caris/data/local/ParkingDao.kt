package com.polete.caris.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.polete.caris.data.local.entities.Parking
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkingDao {

    @Insert
    suspend fun insertParking(parking: Parking)

    @Delete
    suspend fun deleteParking(parking: Parking)

    @Update
    suspend fun updateParking(parking: Parking)

    @Query("SELECT * FROM parking")
    fun getAllParking(): Flow<List<Parking>>

    @Query("SELECT * FROM parking WHERE carId IS NOT NULL")
    fun getFilledParking(): Flow<List<Parking>>

    @Query("SELECT * FROM parking WHERE carId = :id")
    fun getParkingByCarId(id: Int): Flow<Parking>


}