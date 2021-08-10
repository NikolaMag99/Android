package raf.rs.projekatjun.nikola_paunovic_5718rn.data.repositories

import io.reactivex.Observable
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.local.CityDao
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.models.City
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.models.Resource
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.models.api.CityResponse
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.remote.CityService

class CityRepoImpl (
    private val localDataSource: CityDao,
    private val remoteDataSource: CityService

) : CityRepo {

    override fun fetchCity(name: String): Observable<Resource<Unit>>  {
//        return remoteDataSource.getCity(name).doOnNext{
//            val city = City(
//                it.day_of_week
//            )
//        }.map {
//            localDataSource.
//        }

    }


}