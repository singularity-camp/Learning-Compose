package kz.singularity.learningcompose.ui

import android.app.Application
import kz.singularity.data.di.roomDatabaseModule
import kz.singularity.learningcompose.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

class CustomApplication : Application() {

    private val modulesToUse = listOf(
        networkModule,
        viewModelModule,
        repositoryModule,
        useCaseModule,
        mapperModule,
        roomDatabaseModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CustomApplication)
            parametersOf("https://jsonplaceholder.typicode.com")
            modules(modulesToUse)
        }
    }

}