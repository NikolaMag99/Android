package raf.rs.projekatjun.nikola_paunovic_5718rn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [],
    version = 1,
    exportSchema = false)
@TypeConverters()
abstract class CitiesDataBase : RoomDatabase() {
            abstract fun getCityDao(): CityDao

}