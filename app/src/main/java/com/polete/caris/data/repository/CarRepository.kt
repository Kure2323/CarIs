package com.polete.caris.data.repository

import com.polete.caris.data.local.CarDao
import com.polete.caris.data.local.entities.Car
import kotlinx.coroutines.flow.Flow

class CarRepository(private val carDao: CarDao) {

    fun getAllCars(): Flow<List<Car>> = carDao.getAllCars()

    fun getParkedCars(): Flow<List<Car>> = carDao.getParkedCars()

    suspend fun insertCar(car: Car) {
        carDao.insert(car)
    }

    suspend fun deleteCar(car: Car) {
        carDao.delete(car)
    }

    suspend fun updateCar(car: Car) {
        carDao.update(car)
    }

}