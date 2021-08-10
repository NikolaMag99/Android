package raf.rs.projekatjun.nikola_paunovic_5718rn.data.repositories

import com.bumptech.glide.load.engine.Resource
import io.reactivex.Completable
import io.reactivex.Observable
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.models.City

interface CityRepo {

    fun fetchCity(name: String): Observable<City>
    //fun getAll(): Observable<List<City>>
    //fun insert(movie: City): Completable
}
