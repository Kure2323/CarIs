package com.polete.caris.data.repository

import com.polete.caris.data.local.ParkingDao
import com.polete.caris.data.local.entities.Parking
import kotlinx.coroutines.flow.Flow

class ParkingRepository(private val parkingDao: ParkingDao) {

    fun getAllParking(): Flow<List<Parking>> = parkingDao.getAllParking()

    fun getFilledParking(): Flow<List<Parking>> = parkingDao.getFilledParking()

    suspend fun insertParking(parking: Parking) {
        parkingDao.insertParking(parking)
    }

    suspend fun deleteParking(parking: Parking) {
        parkingDao.deleteParking(parking)
    }

    suspend fun updateParking(parking: Parking) {
        parkingDao.updateParking(parking)
    }

}