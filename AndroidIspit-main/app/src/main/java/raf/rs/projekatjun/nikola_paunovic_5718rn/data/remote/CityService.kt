package raf.rs.projekatjun.nikola_paunovic_5718rn.data.remote

import io.reactivex.Observable
import raf.rs.projekatjun.nikola_paunovic_5718rn.data.models.api.CityResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CityService {

    @GET("timezone/Europe/{city}")
    fun getCity(@Path("city") city: String): Observable<CityResponse>
}