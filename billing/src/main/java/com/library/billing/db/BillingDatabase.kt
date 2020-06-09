package com.library.billing.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * The [Room] database for this app.
 */
@Database(
    entities = [
        AugmentedSkuDetails::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BillingDatabase : RoomDatabase() {
    abstract fun skuDetailsDao(): AugmentedSkuDetailsDao

    companion object {
        private const val databaseName = "google_billing_db"

        fun buildDatabase(context: Context): BillingDatabase {
            // Since Room is only used for FTS, destructive migration is enough because the tables
            // are cleared every time the app launches.
            // https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
            return Room.databaseBuilder(context, BillingDatabase::class.java, databaseName)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}