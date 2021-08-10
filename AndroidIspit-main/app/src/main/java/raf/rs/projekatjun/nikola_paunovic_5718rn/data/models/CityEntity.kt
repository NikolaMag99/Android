package raf.rs.projekatjun.nikola_paunovic_5718rn.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "location")
data class CityEntity (
    @PrimaryKey
    val city: String
)