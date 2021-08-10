//package raf.rs.projekatjun.nikola_paunovic_5718rn.modules
//
//import io.reactivex.schedulers.Schedulers.single
//import org.koin.dsl.module
//import raf.rs.projekatjun.nikola_paunovic_5718rn.data.local.CitiesDataBase
//import raf.rs.projekatjun.nikola_paunovic_5718rn.data.repositories.CityRepo
//import raf.rs.projekatjun.nikola_paunovic_5718rn.data.repositories.CityRepoImpl
//
//val cityModule = module {
//
//    single<CityRepo> { CityRepoImpl(localDataSource = get()) }
//
//    single { get<CitiesDataBase>().getCityDao() }
//}