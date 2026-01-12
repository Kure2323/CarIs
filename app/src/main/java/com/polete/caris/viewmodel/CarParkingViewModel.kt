package com.polete.caris.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.polete.caris.data.local.entities.Car
import com.polete.caris.data.local.entities.Parking
import com.polete.caris.data.repository.CarRepository
import com.polete.caris.data.repository.ParkingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarParkingViewModel @Inject constructor(private val repoC: CarRepository, private val repoP: ParkingRepository): ViewModel() {

    // Cars
    val parkedCars: StateFlow<List<Car>> = repoC.getParkedCars().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )
    val allCars: StateFlow<List<Car>> = repoC.getAllCars().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )
    fun insertCar(car: Car) {
        viewModelScope.launch {
            repoC.insertCar(car)
        }
    }
    fun deleteCar(car: Car) {
        viewModelScope.launch {
            repoC.deleteCar(car)
        }
    }
    fun updateCar(car: Car) {
        viewModelScope.launch {
            repoC.updateCar(car)
        }
    }

    // Parkings
    val filledParkings: StateFlow<List<Parking>> = repoP.getFilledParking().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )
    val allParkings: StateFlow<List<Parking>> = repoP.getAllParking().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )
    /*TODO*/ //Toca separar viewModels, no puedo meter siempre un id para el coche al crear el viewModel
    //val carParked: StateFlow<Car?> = repoP.getParkingByCarId()
    fun insertParking(p: Parking) {
        viewModelScope.launch {
            repoP.insertParking(p)
        }
    }
    fun deleteParking(p: Parking) {
        viewModelScope.launch {
            repoP.deleteParking(p)
        }
    }
    fun updateParking(p: Parking) {
        viewModelScope.launch {
            repoP.updateParking(p)
        }
    }

}