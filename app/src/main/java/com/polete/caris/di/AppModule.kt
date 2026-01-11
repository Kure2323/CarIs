package com.polete.caris.di

import android.app.Application
import com.polete.caris.data.local.AppDatabase
import com.polete.caris.data.repository.CarRepository
import com.polete.caris.data.repository.ParkingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDatabase =
        AppDatabase.getDatabase(app)

    @Provides
    @Singleton
    fun provideCarRepository(db: AppDatabase): CarRepository =
        CarRepository(db.carDao())

    @Provides
    @Singleton
    fun provideParkingRepository(db: AppDatabase): ParkingRepository =
        ParkingRepository(db.parkingDao())
}
