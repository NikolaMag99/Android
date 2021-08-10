package raf.rs.projekatjun.nikola_paunovic_5718rn.data.local

import androidx.room.Dao
import androidx.room.Query
import io.reactivex.Observable
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.models.CityEntity

@Dao
abstract class CityDao {

    @Query("SELECT * FROM location WHERE city LIKE :name || '%'")
    abstract fun getByName(name: String): Observable<List<CityEntity>>
}