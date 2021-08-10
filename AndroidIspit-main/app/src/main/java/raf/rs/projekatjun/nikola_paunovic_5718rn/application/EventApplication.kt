package raf.rs.projekatjun.nikola_paunovic_5718rn.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin

import raf.rs.projekatjun.nikola_paunovic_5718rn.modules.coreModule
import timber.log.Timber
import java.util.logging.Level

class EventApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }


    private fun initKoin() {
        val modules = listOf(
                coreModule
//                cityModule
        )
        startKoin {
            androidLogger(org.koin.core.logger.Level.ERROR)
            // Use application context
            androidContext(this@EventApplication)
            // Use properties from assets/koin.properties
            androidFileProperties()
            // Use koin fragment factory for fragment instantiation
            fragmentFactory()
            // modules
            modules(modules)
        }
    }
}