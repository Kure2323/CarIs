package com.polete.caris.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.polete.caris.data.local.entities.Car
import com.polete.caris.data.local.entities.Parking

@Database(entities = [Car::class, Parking::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun carDao(): CarDao
    abstract fun parkingDao(): ParkingDao

    companion object {
        const val DATABASE_NAME = "caris_database"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    klass = AppDatabase::class.java,
                    name = DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
            }
        }

}